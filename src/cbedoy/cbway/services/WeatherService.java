package cbedoy.cbway.services;

import cbedoy.cbway.interfaces.IWheaterServiceDelegate;
import cbedoy.cbway.interfaces.IWheaterServiceInformationDelegate;
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

    private final String                    rootURL = "http://api.openweathermap.org/data/2.5/weather?";
    private URLConnection                   urlConnection;
    private BufferedReader                  bufferedReader;
    private String                          response;
    private URL                             url;
    private JSONParser                      jsonParser;
    private HashMap<WeatherKeySet, Object>  dataModel;
    private Object                          objectParsed;
    private JSONObject                      jsonObject;
    private static WeatherService           wheatherService;
        
    public static WeatherService getInstance(){
        if(wheatherService == null)
            wheatherService = new WeatherService();
        return wheatherService;
    }
    
    private WeatherService(){
        jsonParser                  = new JSONParser();
        dataModel                   = new HashMap<WeatherKeySet, Object>();
    }
    
    private void executeRequest(String requestLink){
        try {
            url                     = new URL(requestLink);
            urlConnection           = url.openConnection();
            bufferedReader          = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            response                = bufferedReader.readLine();
            objectParsed            = jsonParser.parse(response);
            jsonObject              = (JSONObject)objectParsed;
            dataModel.clear();
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
            
            
        dataModel.put(WeatherKeySet.ID, id);
        dataModel.put(WeatherKeySet.DT, dt);
        dataModel.put(WeatherKeySet.LATITUDE, latitude);
        dataModel.put(WeatherKeySet.LENGTH, lenght);
        dataModel.put(WeatherKeySet.NAME, name);
        dataModel.put(WeatherKeySet.CODE, code);
        dataModel.put(WeatherKeySet.MESSAGE, message);
        dataModel.put(WeatherKeySet.COUNTRY, country);
        dataModel.put(WeatherKeySet.SUNRISE, sunrise);
        dataModel.put(WeatherKeySet.SUNSET, sunset);
        dataModel.put(WeatherKeySet.TEMP, temp);
        dataModel.put(WeatherKeySet.PRESURE, pressure);
        dataModel.put(WeatherKeySet.HUMIDITY, humidity);
        dataModel.put(WeatherKeySet.TEMP_MAX, temp_max);
        dataModel.put(WeatherKeySet.TEMP_MIN, temp_min);
        dataModel.put(WeatherKeySet.SPEED, speed);
        dataModel.put(WeatherKeySet.DG, deg);
        
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
    public HashMap<WeatherKeySet, Object> getDataModel() {
        return dataModel;
    }
}
