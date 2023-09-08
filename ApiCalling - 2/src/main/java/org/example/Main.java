package org.example;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = null;
        HttpURLConnection connection = null;
        int responseCode = 0;
        String urlString = "https://api.chucknorris.io/jokes/random";


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

           JSONObject jsonAPIResponse = new JSONObject(apiData.toString());
        //    System.out.println(jsonAPIResponse);
         /*   System.out.print("categories:  ");
            System.out.println(jsonAPIResponse.get("categories"));
            System.out.print("created_at:  ");
            System.out.println(jsonAPIResponse.get("created_at"));
            System.out.print("icon_url:  ");
            System.out.println(jsonAPIResponse.get("icon_url"));
            System.out.print("id:  ");
            System.out.println(jsonAPIResponse.get("id"));
            System.out.print("updated_at:  ");
            System.out.println(jsonAPIResponse.get("updated_at"));
            System.out.print("url:  ");
            System.out.println(jsonAPIResponse.get("url"));
            System.out.print("value:  ");
            System.out.println(jsonAPIResponse.get("value")); */


            Object o1 = new AtomicReference<>(jsonAPIResponse);
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