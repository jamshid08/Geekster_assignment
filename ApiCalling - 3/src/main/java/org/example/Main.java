package org.example;



import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws IOException {

        URL url = null;
        HttpURLConnection connection = null;
        int responseCode = 0;
        String urlString = " https://api.zippopotam.us/us/33162";


        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("problem in URL");
        }

        //connection

        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("connection problem");
        }



        if(responseCode == 200)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while((readLine = in.readLine())!= null)
            {
                apiData.append(readLine);
            }


            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            Object objectMapper = new Object();


        JSONObject jsonAPIResponse = new JSONObject(apiData.toString());
            System.out.print("post code:  ");
            System.out.println(jsonAPIResponse.get("post code"));
            System.out.print("country:  ");
            System.out.println(jsonAPIResponse.get("country"));
            System.out.print("country abbreviation:  ");
            System.out.println(jsonAPIResponse.get("country abbreviation"));
           System.out.println("places:  ");


            Object o1 = jsonAPIResponse.get("places");
            String s1 = o1.toString();
            s1 = s1.substring(1,s1.length()-1);
            String[] strArray = null;
            strArray = s1.split(",");

            for(String s : strArray)
            {
                System.out.println(s);
            }
        }
        else
            System.out.println("API call could not be made!!!");



    }
}