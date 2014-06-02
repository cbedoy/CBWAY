package cbedoy.cbway.services;

import cbedoy.cbway.lib.CBGeocoding;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
       long time_start = System.currentTimeMillis(); 
       WeatherService service               = WeatherService.getInstance();
       GravityMethodService gravity         = GravityMethodService.getInstance();
       CBGeocoding geocoding                = new CBGeocoding();
       String[] countries                   = new String[]{"mexico", "brazil", "argentina", "españa"};
       HashMap<Object, Object> wheatherData = new HashMap<Object, Object>();
        try {
            
           for(String country : countries){
                Point2D.Double coordinates  = geocoding.getCoordinates(country);
                service.requestWithCordinates(coordinates.getX(), coordinates.getY());
                HashMap<WeatherKeySet, Object> information = service.getDataModel();    
                wheatherData.put(information.get(WeatherKeySet.NAME), information);
           }
           
           
           
        } catch (UnsupportedEncodingException | MalformedURLException ex) {

        }       
        
        System.out.println(wheatherData);
        
       long time_end = System.currentTimeMillis();

        System.out.println(time_end-time_start);
    }
}
