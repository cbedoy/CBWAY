package cb.cmap.services;

import cb.cmap.interfaces.IWheaterServiceDelegate;
import cb.cmap.interfaces.IWheaterServiceInformationDelegate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
 * 28/05/2014 - 05:23:40 PM
 */

public class WeatherService implements IWheaterServiceDelegate, IWheaterServiceInformationDelegate{

    private final String            rootURL = "http://api.openweathermap.org/data/2.5/weather?";
    private URLConnection           urlConnection;
    private BufferedReader          bufferedReader;
    private String                  response;
    private URL                     url;
    private JSONParser              jsonParser;
    private HashMap<String, Object> dataModel;
    private Object                  objectParsed;
    private JSONObject              jsonObject;
    private static WeatherService   wheatherService;
    
    public enum ServiceOption{
        CORDINATES, 
        COUNTRY,
        COUNTRY_CITY
    }
    
    public static WeatherService getInstance(){
        if(wheatherService == null)
            wheatherService = new WeatherService();
        return wheatherService;
    }
    
    private WeatherService(){
        jsonParser = new JSONParser();
    }
    
    private void executeRequest(String requestLink){
        try {
            url                     = new URL(requestLink);
            urlConnection           = url.openConnection();
            bufferedReader          = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            response                = bufferedReader.readLine();
            objectParsed            = jsonParser.parse(response);
            jsonObject              = (JSONObject)objectParsed;
            parseDataModel(jsonObject);
        } catch (MalformedURLException  ex) {
            
        } catch (IOException | ParseException ex) {
           
        }
       
    }
    
    private void parseDataModel(JSONObject object) {
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
    }    
    
    @Override
    public void requestWithCity(String city) {
        executeRequest(rootURL+"q="+city);
    }

    @Override
    public void requestWithCordinates(double latitude, double length) {
        executeRequest(rootURL+"lat="+latitude+"&lon="+length+"");
    }

    @Override
    public void requestWithCountryCity(String country, String city) {
        executeRequest(rootURL+"q="+country+","+city);
    }

    @Override
    public HashMap<String, Object> getDataModel() {
        return dataModel;
    }

}
