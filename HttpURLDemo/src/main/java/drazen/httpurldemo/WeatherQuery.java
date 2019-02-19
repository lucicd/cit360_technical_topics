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

/**
 *
 * @author Drazen
 */
public class WeatherQuery {
    public static String getForecast(String state, String town) throws MalformedURLException, IOException
    {
        String result = "";
        URL url = new URL("https://api.wunderground.com/api/87680c9fcd92f4f7/conditions/forecast/forecast10day/q/" +
            state + "/" + town + ".json");
        URLConnection urlConnection = url.openConnection();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()))) 
        {
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                result += inputLine;
            }
        }
        return result;
    }
}
