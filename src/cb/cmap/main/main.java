package cb.cmap.main;

import cb.cmap.bussinescontrollers.MasterController;
import cb.cmap.bussinescontrollers.MasterViewController;
import cb.cmap.interfaces.IGravityServiceDelegate;
import cb.cmap.lib.CBElevation;
import cb.cmap.lib.CBGeocoding;
import cb.cmap.lib.CBPlaces;
import cb.cmap.lib.CBRoute;
import cb.cmap.lib.CBStreetView;
import cb.cmap.viewcontrollers.MainView;
import cb.map.services.GravityMethodService;
import java.util.ArrayList;
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
 * 25-may-2014 - 0:07:47
 */

public class main {
    public static void main(String[]cbedoy){
        long time_start = System.currentTimeMillis();
        MasterController masterController           = MasterController.getInstanse();
        GravityMethodService gravityMethodService   = new GravityMethodService();
        List<Object> dataModel                      = new ArrayList<Object>();
        
        masterController.setElevation(new CBElevation());
        masterController.setGeocoding(new CBGeocoding());
        masterController.setPlaces(new CBPlaces());
        masterController.setRoute(new CBRoute());
        masterController.setStreetView(new CBStreetView());
        masterController.setGravityService(gravityMethodService);
        masterController.setDataModel(dataModel);
        
       
        
        IGravityServiceDelegate serviceDelegate     = gravityMethodService;
        MasterViewController masterViewController   = MasterViewController.getInstance();
        
        MainView     mainView                       = new MainView();
        
        masterViewController.setMasterController(masterController);
        masterViewController.setNodeRepresentationDelegate(mainView);
        masterViewController.setGravityServiceDelegate(serviceDelegate);
        
        mainView.setMasterViewController(masterViewController);
        
        long time_end = System.currentTimeMillis();
        System.out.println(time_end-time_start);
    }
}
