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
import java.util.ArrayList;

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
        if (value.charAt(0) == '"') {
            value = value.substring(1, value.length());
        }
        if (value.charAt(value.length() - 1) == '"') {
            value = value.substring(0, value.length() - 1);
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

}
