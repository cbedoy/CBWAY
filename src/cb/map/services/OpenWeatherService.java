package cb.map.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
/**
 *
 * Carlos Alfredo Cervantes Bedoy
 * Mobile Developer
 * CBGrandSlam
 * Email:           carlos.bedoy@gmail.com
 * Facebook:        https://www.facebook.com/carlos.bedoy
 * Github:          https://github.com/cbedoy
 * WebSite:         http://cbedoy.github.io/
 *
 * 27/05/2014 - 10:47:17 PM
 */

public class OpenWeatherService{
    
    private final String rootURL = "http://api.openweathermap.org/data/2.5/weather?q";
    private URLConnection urlConnection;
    private BufferedReader bufferedReader;
    private String response;
    public static void main(String[]c) throws ParseException{
        URL oracle;
        try {
            oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
            
            String out = in.readLine();
            System.out.println(out);
            
            
            JSONParser parser = new JSONParser();
            Object parse = parser.parse(out);
            
            JSONObject object = (JSONObject) parse;
            HashMap<String, Object> request  = new HashMap<String, Object>();
            request.put("id", object.get("id"));
            
            System.out.println("1");
        } catch (MalformedURLException ex) {
            
        } catch (IOException ex) {
           
        }
        
    }
    
    /*
    {
    "coord": {
        "lon": -0.13,
        "lat": 51.51
    },
    "sys": {
        "message": 0.0349,
        "country": "GB",
        "sunrise": 1401249106,
        "sunset": 1401307433
    },
    "weather": [
        {
            "id": 500,
            "main": "Rain",
            "description": "light rain",
            "icon": "10n"
        },
        {
            "id": 301,
            "main": "Drizzle",
            "description": "drizzle",
            "icon": "09n"
        }
    ],
    "base": "cmc stations",
    "main": {
        "temp": 283.15,
        "pressure": 1011,
        "humidity": 93,
        "temp_min": 282.04,
        "temp_max": 285.15
    },
    "wind": {
        "speed": 4.6,
        "deg": 280
    },
    "rain": {
        "1h": 0.51
    },
    "clouds": {
        "all": 92
    },
    "dt": 1401247845,
    "id": 2643743,
    "name": "London",
    "cod": 200
}
    
    */
}
