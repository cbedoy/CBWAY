package cbedoy.cbway.unittest;

import cbedoy.cbway.guice.Module;
import cbedoy.cbway.interfaces.IGravityServiceInformationHandler;
import cbedoy.cbway.services.GravityMethodService;
import cbedoy.cbway.services.WeatherKeySet;
import cbedoy.cbway.interfaces.IGravityServiceInformationHandler.SOLUTIONS;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
 * 1/06/2014 - 09:53:22 PM
 */

public class UnitTestGravityMethodService {
    public static void main(String[]cbedoy){

        Injector injector = Guice.createInjector(new Module());

        IGravityServiceInformationHandler method = injector.getInstance(GravityMethodService.class);
        List<Object> country = new ArrayList<>();
        HashMap<WeatherKeySet, Object> info;
        
        //NODE A
        info  = new HashMap<WeatherKeySet, Object>();
        info.put(WeatherKeySet.COST, (double)1500);
        info.put(WeatherKeySet.LATITUDE, (double)325);
        info.put(WeatherKeySet.LENGTH, (double)75);
        country.add(info);
        
        //NODE B
        info  = new HashMap<WeatherKeySet, Object>();
        info.put(WeatherKeySet.COST, (double)250);
        info.put(WeatherKeySet.LATITUDE, (double)400);
        info.put(WeatherKeySet.LENGTH, (double)150);
        country.add(info);
        
        //NODE C
        info  = new HashMap<WeatherKeySet, Object>();
        info.put(WeatherKeySet.COST, (double)450);
        info.put(WeatherKeySet.LATITUDE, (double)450);
        info.put(WeatherKeySet.LENGTH, (double)350);
        country.add(info);
        
        //NODE D
        info  = new HashMap<WeatherKeySet, Object>();
        info.put(WeatherKeySet.COST, (double)350);
        info.put(WeatherKeySet.LATITUDE, (double)350);
        info.put(WeatherKeySet.LENGTH, (double)400);
        country.add(info);
        
        //NODE E
        info  = new HashMap<WeatherKeySet, Object>();
        info.put(WeatherKeySet.COST, (double)450);
        info.put(WeatherKeySet.LATITUDE, (double)25);
        info.put(WeatherKeySet.LENGTH, (double)450);
        country.add(info);
        
        method.solveNodes(country);
        HashMap<SOLUTIONS, Object> solution = method.getSolution();
        System.out.println("Position X:" +solution.get(SOLUTIONS.X));
        System.out.println("Position Y:" +solution.get(SOLUTIONS.Y));
    }
}
