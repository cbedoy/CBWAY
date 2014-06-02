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
       List<WeatherModel> wheatherList      = new ArrayList<WeatherModel>();
        try {
            
           for(String country : countries){
                Point2D.Double coordinates  = geocoding.getCoordinates(country);
                service.requestWithCordinates(coordinates.getX(), coordinates.getY());
                HashMap<String, Object> information = service.getDataModel();    
                wheatherList.add(new WeatherModel(information));
           }
           
           
           
        } catch (UnsupportedEncodingException | MalformedURLException ex) {

        }
       
        for(WeatherModel object : wheatherList){
            System.out.println(object.getSunrise());
            System.out.println(object.getName());
            System.out.println(object.getMessage());
        }

       
       long time_end = System.currentTimeMillis();

        System.out.println(time_end-time_start);
    }
}
