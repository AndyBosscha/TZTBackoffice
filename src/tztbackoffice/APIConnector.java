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

/**
 *
 * @author Andy
 */
public class APIConnector {

    private String sendRequest(String requestURL) throws IOException {
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
                returnValue = output;
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
        if(zipCode.length() == 6){
            JsonObject location = toJSON(sendRequest("http://nominatim.openstreetmap.org/search?postalcode="+zipCode+"&format=json"));
            if(location.get("lat") == null){
                return "";
            }
            JsonObject address = toJSON(sendRequest("http://nominatim.openstreetmap.org/reverse?format=json&lat=" + stripQuotes(location.get("lat").toString()) + "&lon=" + stripQuotes(location.get("lon").toString()) + "7&zoom=18&addressdetails=1"));
            JsonElement ad = address.get("address");
            return stripQuotes(toJSON(ad.toString()).get("road").toString());
        } else {
            return "";
        }
        
    }

    private String stripQuotes(String value) {
        if (value.charAt(0) == '"') {
            value = value.substring(1, value.length());
        }
        if (value.charAt(value.length() - 1) == '"') {
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }

    public JsonObject toJSON(String value) {
        if("[]".equals(value)){
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
        if(value == null){
            o = new JsonObject();
        } else {
            o = parser.parse(value).getAsJsonObject();
        }
        
        return o;
    }

}
