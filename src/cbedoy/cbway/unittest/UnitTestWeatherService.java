package cbedoy.cbway.unittest;

import cbedoy.cbway.guice.Module;
import cbedoy.cbway.interfaces.IGravityServiceInformationHandler;
import cbedoy.cbway.interfaces.IWheaterServiceInformationDelegate;
import cbedoy.cbway.interfaces.IWheaterServiceInformationHandler;
import cbedoy.cbway.lib.GeocodingService;
import cbedoy.cbway.services.GravityMethodService;
import cbedoy.cbway.services.WeatherKeySet;
import cbedoy.cbway.services.WeatherService;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;

import com.google.inject.Guice;
import com.google.inject.Injector;
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

public class UnitTestWeatherService{
    public static void main(String[]cbedoy) throws ParseException{
       long time_start = System.currentTimeMillis();
        Injector injector = Guice.createInjector(new Module());

        IGravityServiceInformationHandler method = injector.getInstance(GravityMethodService.class);
        WeatherService service = injector.getInstance(WeatherService.class);
       GeocodingService geocoding                = new GeocodingService();
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
