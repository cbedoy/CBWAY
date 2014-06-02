package cbedoy.cbway.services;

import cbedoy.cbway.lib.CBGeocoding;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
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
       WeatherService service = WeatherService.getInstance();
       GravityMethodService gravity = GravityMethodService.getInstance();
       CBGeocoding geocoding = new CBGeocoding();
        try {
           Point2D.Double coordinates = geocoding.getCoordinates("durango");
           service.requestWithCordinates(coordinates.getX(), coordinates.getY());
           HashMap<String, Object> dataModel = service.getDataModel();
           for(String key: dataModel.keySet())
               System.out.println(key+" -> "+dataModel.get(key));
           
        } catch (UnsupportedEncodingException | MalformedURLException ex) {

        }
       System.out.println(service.getDataModel().keySet().size());
        
    }
}
