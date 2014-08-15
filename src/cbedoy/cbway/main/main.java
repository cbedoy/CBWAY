package cbedoy.cbway.main;

import cbedoy.cbway.bussinescontrollers.MasterBusinessController;
import cbedoy.cbway.bussinescontrollers.MasterViewController;
import cbedoy.cbway.guice.Module;
import cbedoy.cbway.interfaces.*;
import cbedoy.cbway.interfaces.IGravityServiceInformationHandler;
import cbedoy.cbway.lib.*;
import cbedoy.cbway.lib.ElevationService;
import cbedoy.cbway.viewcontrollers.MainView;
import cbedoy.cbway.viewcontrollers.SplashView;
import cbedoy.cbway.services.GravityMethodService;
import cbedoy.cbway.services.WeatherService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.List;

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
            IViewRepresentationHandler viewDelegateSplash                                = injector.getInstance(SplashView.class);
            viewDelegateSplash.showView();
            MainView mainView                                               = injector.getInstance(MainView.class);
            IViewRepresentationHandler viewDelegateMain                                  = injector.getInstance(MainView.class);
            MasterBusinessController masterBusinessController = injector.getInstance(MasterBusinessController.class);
            GravityMethodService gravityMethodService                       = injector.getInstance(GravityMethodService.class);
            List<Object> dataModel                                          = new ArrayList<Object>();
            
            IGravityServiceInformationHandler serviceDelegate                         = injector.getInstance(GravityMethodService.class);
            MasterViewController masterViewController                       = injector.getInstance(MasterViewController.class);
            INodeRepresentationDelegate representationDelegate              = injector.getInstance(MainView.class);
            INodeInformationDelegate nodeDelegate                                      = injector.getInstance(MasterViewController.class);
            INodeInformationHandler handlerDelegate                            = injector.getInstance(MasterViewController.class);
            
            representationDelegate.reloadData(null);
            masterBusinessController.setElevation(injector.getInstance(ElevationService.class));
            masterBusinessController.setGeocoding(injector.getInstance(GeocodingService.class));
            masterBusinessController.setPlaces(injector.getInstance(PlaceService.class));
            masterBusinessController.setRoute(injector.getInstance(RouteService.class));
            masterBusinessController.setStreetView(injector.getInstance(StreetViewService.class));
            masterBusinessController.setGravityService(injector.getInstance(GravityMethodService.class));
            masterBusinessController.setDataModel(dataModel);
            
            masterViewController.setMasterBusinessController(masterBusinessController);
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
