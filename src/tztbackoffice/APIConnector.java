/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.awt.List;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.NameValuePair;
import tztbackoffice.Models.KoerierModel;
import tztbackoffice.Models.PackageModel;

/**
 *
 * @author Andy
 */
public class APIConnector {

    private String sendGetRequest(String requestURL) throws IOException {
        String returnValue = "";
        try {
            URL url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                returnValue += output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return returnValue;
    }
    
    private String sendPostRequest(String requestFunction, String data) throws IOException {
        String urlParameters  = "param1=a&param2=b&param3=c";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        String returnValue = "";
        try {
            URL url = new URL(Constants.API_BASE_URL + requestFunction);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write("Key=XRYLSTO92ASD11SD5TTLL" + data);
            out.close();
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                returnValue += output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return returnValue;
    }

    public String validateAddress(String zipCode) throws IOException {
        
        if (zipCode.length() == 6) {
            JsonObject location = toJSON(sendGetRequest("http://maps.googleapis.com/maps/api/geocode/json?address=" + zipCode));
            JsonObject results = toJSON(location.get("results").toString());
            if (results == null || results.get("geometry") == null) {
                return "";
            }
            JsonElement geometry = results.get("geometry");
            JsonElement geoLocation = geometry.getAsJsonObject().get("location");
            String[] latLong = new String[]{
                geoLocation.getAsJsonObject().get("lat").toString(),
                geoLocation.getAsJsonObject().get("lng").toString()
            };
            JsonObject address = toJSON(sendGetRequest("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + stripQuotes(latLong[0]) + "," + stripQuotes(latLong[1])));
            JsonArray result = address.get("results").getAsJsonArray();
            JsonArray ad = result.get(0).getAsJsonObject().get("address_components").getAsJsonArray();
            String concatResult = "";
            
            for (int i = 0; i < ad.size(); i++) {
                if (stripQuotes(ad.get(i).getAsJsonObject().get("types").getAsJsonArray().get(0).toString()).equals("route")) {
                    concatResult = stripQuotes(ad.get(i).getAsJsonObject().get("long_name").toString().trim());
                }
                
                if (stripQuotes(ad.get(i).getAsJsonObject().get("types").getAsJsonArray().get(0).toString()).equals("locality")) {
                    concatResult += "STRINGDIVIDER"+stripQuotes(ad.get(i).getAsJsonObject().get("short_name").toString().trim());
                }
            }
            
            return concatResult;
        }
        return "";
    }

    private String stripQuotes(String value) {
        if(!value.equals("")){
            if (value.charAt(0) == '"') {
                value = value.substring(1, value.length());
            }
            if (value.charAt(value.length() - 1) == '"') {
                value = value.substring(0, value.length() - 1);
            }
        }
        return value;
    }

    public JsonObject toJSON(String value) {

        if ("[]".equals(value)) {
            return new JsonObject();
        }
        JsonObject o;
        if (value.charAt(0) == '[') {
            value = value.substring(1, value.length());
        }
        if (value.charAt(value.length() - 1) == ']') {
            value = value.substring(0, value.length() - 1);
        }

        JsonParser parser = new JsonParser();
        if (value == null) {
            o = new JsonObject();
        } else {
            o = parser.parse(value).getAsJsonObject();
        }
        return o;
    }
    
    public JsonArray toJSONArray(String value) {
        if ("[]".equals(value)) {
            return new JsonArray();
        }
        JsonArray a; 
        if (value.charAt(0) == '[') {
            value = value.substring(1, value.length());
        }
        if (value.charAt(value.length() - 1) == ']') {
            value = value.substring(0, value.length() - 1);
        }

        JsonParser parser = new JsonParser();
        if (value == null) {
            a = new JsonArray();
        } else {
            a = parser.parse(value).getAsJsonArray();
        }
        return a;
    }
    
    public ArrayList<KoerierModel> getAllCouriers(){
        ArrayList<KoerierModel> returnList = new ArrayList<>();
        
        try {
            JsonObject allCouriers = toJSON(makeValidJsonString(sendPostRequest(Constants.GET_ALL_COURIERS_FUNCTION_NAME, "")));
            JsonArray allCouriersArray = allCouriers.get("results").getAsJsonArray();
            
            for(int i = 0; i < allCouriersArray.size(); i++){
                KoerierModel addableModel = new KoerierModel();
                JsonObject addableObject = allCouriersArray.get(i).getAsJsonObject();
                addableModel.setIdUser(Integer.parseInt(addableObject.get("idUser").getAsString()));
                addableModel.setMailAddress(addableObject.get("Email").getAsString());
                addableModel.setFirstName(addableObject.get("Firstname").getAsString());
                addableModel.setMiddleName(addableObject.get("Middlename").getAsString());
                addableModel.setLastName(addableObject.get("Lastname").getAsString());
                addableModel.setStreetName(addableObject.get("Street").getAsString());
                addableModel.setHouseNumber(addableObject.get("Housenumber").getAsString());
                addableModel.setZipCode(addableObject.get("Zipcode").getAsString());
                addableModel.setCity(addableObject.get("City").getAsString());
                addableModel.setPhoneNumber(addableObject.get("Phonenumber").getAsString());
                addableModel.setSex(addableObject.get("Gender").getAsString());
                addableModel.setStatus(addableObject.get("Status").getAsString());
                addableModel.setStartDate(addableObject.get("StartDate").getAsString());

                returnList.add(addableModel);
            }
            
            return returnList;
        } catch (IOException ex) {
            return returnList;
        }
        
    }
    
    public ArrayList<PackageModel> getAllPackages(){
        ArrayList<PackageModel> returnList = new ArrayList<>();
        try {
            JsonObject allPackages = toJSON(makeValidJsonString(sendPostRequest(Constants.GET_ALL_PACKAGES_FUNCTION_NAME, "")));
            JsonArray allPackagesArray = allPackages.get("results").getAsJsonArray();

            for(int i = 0; i < allPackagesArray.size(); i ++){
                PackageModel addableModel = new PackageModel();
                JsonObject addableObject = allPackagesArray.get(i).getAsJsonObject();
                
                addableModel.setIdPackage(Integer.parseInt(addableObject.get("idPackage").getAsString()));
                addableModel.setIdCustomer(Integer.parseInt(addableObject.get("idUser").getAsString()));
                addableModel.setSignupDateTime(toDate(addableObject.get("SignUpDateTime").getAsString()));
                addableModel.setWeight(Double.parseDouble(addableObject.get("Weight").getAsString()));
                addableModel.setHeight(Double.parseDouble(addableObject.get("Height").getAsString()));
                addableModel.setLength(Double.parseDouble(addableObject.get("Length").getAsString()));
                addableModel.setWidth(Double.parseDouble(addableObject.get("Width").getAsString()));
                addableModel.setPickUpDate(toDate(addableObject.get("PickUpDate").getAsString()));
                addableModel.setDeliveryDate(toDate(addableObject.get("DeliveryDate").getAsString()));
                addableModel.setIsDelivered(addableObject.get("DeliveryDate").getAsString().equals("0000-00-00") ? "Nee" : "Ja");
                returnList.add(addableModel);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(APIConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnList;
    }
    
    public PackageModel getPackageDetails(String packageId){
        System.out.println(packageId);
        PackageModel detailedPackage = new PackageModel();
        
        try {
            JsonObject packageJson = toJSON(makeValidJsonString(sendPostRequest(Constants.GET_PACKAGE_DETAILS_FUNCTION_NAME, "&idPackage=" + packageId)));
            JsonArray packageArray = packageJson.get("results").getAsJsonArray();
            JsonObject addableObject = packageArray.get(0).getAsJsonObject();

            detailedPackage.setIdPackage(Integer.parseInt(addableObject.get("idPackage").getAsString()));
            detailedPackage.setIdCustomer(Integer.parseInt(addableObject.get("idUser").getAsString()));
            detailedPackage.setSignupDateTime(toDate(addableObject.get("SignUpDateTime").getAsString()));
            detailedPackage.setWeight(Double.parseDouble(addableObject.get("Weight").getAsString()));
            detailedPackage.setHeight(Double.parseDouble(addableObject.get("Height").getAsString()));
            detailedPackage.setLength(Double.parseDouble(addableObject.get("Length").getAsString()));
            detailedPackage.setWidth(Double.parseDouble(addableObject.get("Width").getAsString()));
            detailedPackage.setPickUpDate(toDate(addableObject.get("PickUpDate").getAsString()));
            detailedPackage.setDeliveryDate(toDate(addableObject.get("DeliveryDate").getAsString()));
            detailedPackage.setIsDelivered(addableObject.get("DeliveryDate").getAsString().equals("0000-00-00") ? "Nee" : "Ja");
            
            return detailedPackage;
            
        } catch (IOException ex) {
            Logger.getLogger(APIConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return detailedPackage;
    }
    
    public KoerierModel getCourierDetails(String courierId){
        KoerierModel detailedCourier = new KoerierModel();
        try {
            JsonObject courierJson = toJSON(makeValidJsonString(sendPostRequest(Constants.GET_PACKAGE_DETAILS_FUNCTION_NAME, "&idUser=" + courierId)));
            JsonArray courierArray = courierJson.get("results").getAsJsonArray();
            JsonObject addableObject = courierArray.get(0).getAsJsonObject();
            
                detailedCourier.setMailAddress(addableObject.get("Email").getAsString());
                detailedCourier.setFirstName(addableObject.get("Firstname").getAsString());
                detailedCourier.setMiddleName(addableObject.get("Middlename").getAsString());
                detailedCourier.setLastName(addableObject.get("Lastname").getAsString());
                detailedCourier.setStreetName(addableObject.get("Street").getAsString());
                detailedCourier.setHouseNumber(addableObject.get("Housenumber").getAsString());
                detailedCourier.setZipCode(addableObject.get("Zipcode").getAsString());
                detailedCourier.setCity(addableObject.get("City").getAsString());
                detailedCourier.setPhoneNumber(addableObject.get("Phonenumber").getAsString());
                detailedCourier.setSex(addableObject.get("Gender").getAsString());
                detailedCourier.setStatus(addableObject.get("Status").getAsString());
                detailedCourier.setStartDate(addableObject.get("StartDate").getAsString());
            
        } catch (IOException ex) {
            Logger.getLogger(APIConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return detailedCourier;
    }
    
    private Date toDate(String value){
    DateFormat df;
    if(value.contains(" ")){
         df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    } else {
        df = new SimpleDateFormat("yyyy-MM-dd");
    }

    Date result = new Date();
        try {
            result = df.parse(value);
        } catch (ParseException ex) {
            Logger.getLogger(APIConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    return result;
    }
    
    private String makeValidJsonString(String value){
        return "{\"results\":"+value+"}";
    }
    

}
