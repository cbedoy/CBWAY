package cbedoy.cbway.main;

import cbedoy.cbway.bussinescontrollers.MasterController;
import cbedoy.cbway.bussinescontrollers.MasterViewController;
import cbedoy.cbway.guice.Module;
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
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Carlos Alfredo Cervantes Bedoy
 * Mobile Developer
 * CBWAY
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
            
            Injector injector = Guice.createInjector(new Module());
            
            long time_start = System.currentTimeMillis();
            IViewDelegate viewDelegateSplash                                = injector.getInstance(SplashView.class);
            viewDelegateSplash.showView();
            MainView mainView                                               = injector.getInstance(MainView.class);
            IViewDelegate viewDelegateMain                                  = injector.getInstance(MainView.class);
            MasterController masterController                               = injector.getInstance(MasterController.class);
            GravityMethodService gravityMethodService                       = injector.getInstance(GravityMethodService.class);
            List<Object> dataModel                                          = new ArrayList<Object>();
            
            IGravityServiceDelegate serviceDelegate                         = injector.getInstance(GravityMethodService.class);
            MasterViewController masterViewController                       = injector.getInstance(MasterViewController.class);
            INodeRepresentationDelegate representationDelegate              = injector.getInstance(MainView.class);
            INodeDelegate nodeDelegate                                      = injector.getInstance(MasterViewController.class);
            INodeHandlerDelegate handlerDelegate                            = injector.getInstance(MasterViewController.class);
            
            representationDelegate.reloadData(null);
            masterController.setElevation(injector.getInstance(CBElevation.class));
            masterController.setGeocoding(injector.getInstance(CBGeocoding.class));
            masterController.setPlaces(injector.getInstance(CBPlaces.class));
            masterController.setRoute(injector.getInstance(CBRoute.class));
            masterController.setStreetView(injector.getInstance(CBStreetView.class));
            masterController.setGravityService(injector.getInstance(GravityMethodService.class));
            masterController.setDataModel(dataModel);
            
            masterViewController.setMasterController(masterController);
            masterViewController.setNodeRepresentationDelegate(representationDelegate);
            masterViewController.setGravityServiceDelegate(serviceDelegate);
            masterViewController.setWheatherServiceDelegate(injector.getInstance(WeatherService.class));
            masterViewController.setWheatherServiceInformationDelegate(injector.getInstance(WeatherService.class));
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
