//package com.mkyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class HouseSearch {

    public static void main(String[] args) throws IOException {

        // Make a URL to the web page
        URL url = new URL("https://www.99.co/singapore/sale/property/queens-peak-condo-cGunqncV2VkDGgNHjSQWTH");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        // read each line and write to System.out
        int i = 0;
        while ((line = br.readLine()) != null) {
            i++;
            boolean isPriceExists = (line.indexOf("\"price\":") != -1);
            boolean isQuoteExist = (line.indexOf("Would like to check the availability for ") != -1);

            if(isPriceExists && isQuoteExist) {
                //print out entire line
                System.out.print(i + ") ");
                System.out.println(line);
                //title, price, bedrooms, area_ppsf, area_size, completed_at, tenure, bedrooms_formatted, bathrooms_formatted,
                //phone, highlights, address_line_2, address_line_1

            }
            //information to pull: price, br
        }
    }
}
