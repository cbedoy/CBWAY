package cb.map.services;

import cb.cmap.interfaces.IWheaterServiceDelegate;
import cb.cmap.interfaces.IWheaterServiceInformationDelegate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        } catch (MalformedURLException  ex) {
            
        } catch (IOException | ParseException ex) {
           
        }
       
    }
    
    public void setDataModel(HashMap<String, Object> dataModel){
        this.dataModel = dataModel;
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
    public HashMap<String, Object> getData() {
        return dataModel;
    }

}
