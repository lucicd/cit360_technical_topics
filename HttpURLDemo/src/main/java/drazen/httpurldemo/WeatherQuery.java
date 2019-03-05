/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drazen.httpurldemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Drazen
 */
public class WeatherQuery {
    public static String getForecast(String state, String town)
    {
        String result = "";
        URL url;
        try {
            url = new URL("https://api.wunderground.com/api/87680c9fcd92f4f7/conditions/forecast/forecast10day/q/" +
                    state + "/" + town + ".json");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setConnectTimeout(10 * 1000);
            
            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()))) 
            {
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    result += inputLine;
                }
            } catch (UnknownHostException ex) {
                System.err.println("Unknown host: " + ex.getMessage());    
            }
        } catch (MalformedURLException ex) {
            System.err.println("Malformed URL: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("IO Exception: " + ex.getMessage());
        }
        
        return result;
    }
}
