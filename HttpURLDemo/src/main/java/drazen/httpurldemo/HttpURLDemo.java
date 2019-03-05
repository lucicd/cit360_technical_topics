package drazen.httpurldemo;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drazen
 */
public class HttpURLDemo {
    public static void main(String[] args)
    {
        String json = WeatherQuery.getForecast("IL", "Chicago");
        if (json.length() == 0)
            return;
        try {
            JSONParser parser = new JSONParser();
            JSONObject forecast = (JSONObject)parser.parse(json);
            JSONObject currentObservation = (JSONObject)forecast.get("current_observation");
            JSONObject location = (JSONObject)currentObservation.get("observation_location");
            System.out.println(currentObservation.toString());
            System.out.println("Location: " + location.get("full"));
            System.out.println("Observation Time: " + currentObservation.get("observation_time"));
            System.out.println("Weather: " + currentObservation.get("weather"));
            System.out.println("Temperature: " + currentObservation.get("temperature_string"));
            System.out.println("Feels like: " + currentObservation.get("feelslike_string"));
            System.out.println("Precipitation [in]: " + currentObservation.get("precip_1hr_in"));
            System.out.println("Wind: " + currentObservation.get("wind_string"));
            System.out.println("Wind Direction: " + currentObservation.get("wind_dir"));
            System.out.println("Relative Humidity: " + currentObservation.get("relative_humidity"));
            System.out.println("Pressure [mb]: " + currentObservation.get("pressure_mb"));
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
