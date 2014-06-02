package cbedoy.cbway.main;

import cbedoy.cbway.bussinescontrollers.MasterController;
import cbedoy.cbway.bussinescontrollers.MasterViewController;
import cbedoy.cbway.interfaces.IGravityServiceDelegate;
import cbedoy.cbway.interfaces.IMapDelegate;
import cbedoy.cbway.interfaces.INodeDelegate;
import cbedoy.cbway.interfaces.INodeHandlerDelegate;
import cbedoy.cbway.interfaces.INodeRepresentationDelegate;
import cbedoy.cbway.interfaces.IViewDelegate;
import cbedoy.cbway.interfaces.IWheaterServiceDelegate;
import cbedoy.cbway.interfaces.IWheaterServiceInformationDelegate;
import cbedoy.cbway.lib.CBElevation;
import cbedoy.cbway.lib.CBGeocoding;
import cbedoy.cbway.lib.CBPlaces;
import cbedoy.cbway.lib.CBRoute;
import cbedoy.cbway.lib.CBStreetView;
import cbedoy.cbway.viewcontrollers.MainView;
import cbedoy.cbway.viewcontrollers.SplashView;
import cbedoy.cbway.services.GravityMethodService;
import cbedoy.cbway.services.WeatherService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            long time_start = System.currentTimeMillis();
            SplashView splash                                               = new SplashView();
            IViewDelegate viewDelegateSplash                                = splash;
            viewDelegateSplash.showView();
            WeatherService wheatherService                                  = WeatherService.getInstance();
            IWheaterServiceDelegate wheatherServiceDelegate                 = wheatherService;
            IWheaterServiceInformationDelegate wheatherInformationDelegate  = wheatherService;
            
            MainView mainView                                               = new MainView();
            IViewDelegate viewDelegateMain                                  = mainView;
            MasterController masterController                               = MasterController.getInstanse();
            GravityMethodService gravityMethodService                       = GravityMethodService.getInstance();
            List<Object> dataModel                                          = new ArrayList<Object>();
            
            IMapDelegate    elevationDelegate                               = new CBElevation();
            IMapDelegate    geocodingDelegate                               = new CBGeocoding();
            IMapDelegate    placesDelegate                                  = new CBPlaces();
            IMapDelegate    routeDelegate                                   = new CBRoute();
            IMapDelegate    streetDelegate                                  = new CBStreetView();
            
            IGravityServiceDelegate serviceDelegate                         = gravityMethodService;
            MasterViewController masterViewController                       = MasterViewController.getInstance();
            INodeRepresentationDelegate representationDelegate              = mainView;
            INodeDelegate nodeDelegate                                      = masterViewController;
            INodeHandlerDelegate handlerDelegate                            = masterViewController;
            
            representationDelegate.reloadData(null);
            masterController.setElevation(new CBElevation());
            masterController.setGeocoding(new CBGeocoding());
            masterController.setPlaces(new CBPlaces());
            masterController.setRoute(new CBRoute());
            masterController.setStreetView(new CBStreetView());
            masterController.setGravityService(gravityMethodService);
            masterController.setDataModel(dataModel);
            
            masterViewController.setMasterController(masterController);
            masterViewController.setNodeRepresentationDelegate(representationDelegate);
            masterViewController.setGravityServiceDelegate(serviceDelegate);
            masterViewController.setWheatherServiceDelegate(wheatherServiceDelegate);
            masterViewController.setWheatherServiceInformationDelegate(wheatherInformationDelegate);
            mainView.setNodeHandlerDelegate(handlerDelegate);
            mainView.setMasterViewController(masterViewController);
            mainView.setNodeDelegate(nodeDelegate);
            
            Thread.sleep(1000);
            
            viewDelegateSplash.hideView();
            viewDelegateMain.showView();
            long time_end = System.currentTimeMillis();
            System.out.println(time_end-time_start);
        } catch (InterruptedException ex) {
            
        }
    }
}
