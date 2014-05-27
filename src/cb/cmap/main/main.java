package cb.cmap.main;

import cb.cmap.bussinescontrollers.MasterController;
import cb.cmap.bussinescontrollers.MasterViewController;
import cb.cmap.interfaces.IGravityServiceDelegate;
import cb.cmap.interfaces.INodeDelegate;
import cb.cmap.interfaces.INodeHandlerDelegate;
import cb.cmap.interfaces.INodeRepresentationDelegate;
import cb.cmap.interfaces.IViewDelegate;
import cb.cmap.lib.CBElevation;
import cb.cmap.lib.CBGeocoding;
import cb.cmap.lib.CBPlaces;
import cb.cmap.lib.CBRoute;
import cb.cmap.lib.CBStreetView;
import cb.cmap.viewcontrollers.MainView;
import cb.cmap.viewcontrollers.SplashView;
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
        SplashView splash                           = new SplashView();
        
        IViewDelegate viewDelegate                  = splash;
        //Master controller instances
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
        
        MainView     mainView                               = new MainView();
        IGravityServiceDelegate serviceDelegate             = gravityMethodService;
        MasterViewController masterViewController           = MasterViewController.getInstance();
        INodeRepresentationDelegate representationDelegate  = mainView;
        INodeDelegate nodeDelegate                          = masterViewController;
        INodeHandlerDelegate handlerDelegate                = masterViewController;
        representationDelegate.reloadData(null);
        masterViewController.setMasterController(masterController);
        masterViewController.setNodeRepresentationDelegate(representationDelegate);
        masterViewController.setGravityServiceDelegate(serviceDelegate);
        
        mainView.setNodeHandlerDelegate(handlerDelegate);
        mainView.setMasterViewController(masterViewController);
        mainView.setNodeDelegate(nodeDelegate);
        
        long time_end = System.currentTimeMillis();
        viewDelegate.hideView();
        System.out.println(time_end-time_start);
    }
}
