package cb.map.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import org.json.simple.JSONArray;
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
    public static void main(String[]cbedoy) throws ParseException{
        try {
            URL urlDomain                       = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk");
            URLConnection urlConnection         = urlDomain.openConnection();
            BufferedReader input                = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); 
            String out                          = input.readLine();
            JSONParser parser                   = new JSONParser();
            Object parse                        = parser.parse(out);
            JSONObject object                   = (JSONObject) parse;
            
            JSONObject coord                    = (JSONObject)object.get("coord");
            JSONObject sys                      = (JSONObject)object.get("sys");
            JSONObject main                     = (JSONObject)object.get("main");
            JSONObject wind                     = (JSONObject)object.get("wind");
            JSONObject rain                     = (JSONObject)object.get("rain");
            JSONArray weather                   = (JSONArray)object.get("weather");
            
            Object id_weather                   = weather.get(0);
            Object icon_weather                 = weather.get(1);
            Object description_weather          = weather.get(2);
            Object main_weather                 = weather.get(3);
            
            Object id                           = object.get("id");
            Object dt                           = object.get("dt");
            Object name                         = object.get("name");
            Object code                         = object.get("cod");
            
            Object latitude                     = coord.get("lat");
            Object lenght                       = coord.get("long");
            
            Object message                      = sys.get("message");
            Object country                      = sys.get("country");
            Object sunrise                      = sys.get("sunrise");
            Object sunset                       = sys.get("sunset");
            
            Object temp                         = main.get("temp");
            Object pressure                     = main.get("pressure");
            Object humidity                     = main.get("humidity");
            Object temp_min                     = main.get("temp_min");
            Object temp_max                     = main.get("temp_max");
            
            Object speed                        = wind.get("speed");
            Object deg                          = wind.get("deg");      
            
            Object rains                        = rain.get("1h");
            
            HashMap<String, Object> dataModel   = new HashMap<String, Object>();
            dataModel.put("id", id);
            dataModel.put("dt", dt);
            dataModel.put("latitude", latitude);
            dataModel.put("length", lenght);
            dataModel.put("name", name);
            dataModel.put("code", code);
            dataModel.put("message", message);
            dataModel.put("country", country);
            dataModel.put("sunrise", sunrise);
            dataModel.put("sunset", sunset);
            dataModel.put("temp", temp);
            dataModel.put("pressure", pressure);
            dataModel.put("humidity", humidity);
            dataModel.put("temp_max", temp_max);
            dataModel.put("temp_min", temp_min);
            dataModel.put("speed", speed);
            dataModel.put("deg", deg);
            dataModel.put("rains", rains);
            dataModel.put("id_weather", id_weather);
            dataModel.put("icon_weather", icon_weather);
            dataModel.put("main_weather", main_weather);
            dataModel.put("description_weather", description_weather);
            
        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        }
        
    }
}
