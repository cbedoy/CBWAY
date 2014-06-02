package cbedoy.cbway.main;

import cbedoy.cbway.services.GravityMethodService;
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
        GravityMethodService method = GravityMethodService.getInstance();
        List<Object> country = new ArrayList<>();
        HashMap<String, Object> info;
        
        //NODE A
        info  = new HashMap< >();
        info.put("cost", (double)1500);
        info.put("latitude", (double)325);
        info.put("length", (double)75); 
        country.add(info);
        
        //NODE B
        info  = new HashMap< >();
        info.put("cost", (double)250);
        info.put("latitude", (double)400);
        info.put("length", (double)150); 
        country.add(info);
        
        //NODE C
        info  = new HashMap< >();
        info.put("cost", (double)450);
        info.put("latitude", (double)450);
        info.put("length", (double)350); 
        country.add(info);
        
        //NODE D
        info  = new HashMap< >();
        info.put("cost", (double)350);
        info.put("latitude", (double)350);
        info.put("length", (double)400); 
        country.add(info);
        
        //NODE E
        info  = new HashMap< >();
        info.put("cost", (double)450);
        info.put("latitude", (double)25);
        info.put("length", (double)450); 
        country.add(info);
        
        method.solveNodes(country);
        HashMap<String, Object> solution = method.getSolution();
        System.out.println("Position X:" +solution.get("position_x"));
        System.out.println("Position Y:" +solution.get("position_y"));
    }
}
