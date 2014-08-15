package cbedoy.cbway.guice;

import cbedoy.cbway.bussinescontrollers.MasterBusinessController;
import cbedoy.cbway.bussinescontrollers.MasterViewController;
import cbedoy.cbway.interfaces.*;
import cbedoy.cbway.interfaces.IGravityServiceInformationHandler;
import cbedoy.cbway.lib.*;
import cbedoy.cbway.lib.ElevationService;
import cbedoy.cbway.services.BrowserService;
import cbedoy.cbway.services.DecoratorService;
import cbedoy.cbway.services.GravityMethodService;
import cbedoy.cbway.services.WeatherService;
import cbedoy.cbway.viewcontrollers.MainView;
import cbedoy.cbway.viewcontrollers.SplashView;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

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
 * 13/07/2014 - 03:18:16 PM
 */

public class Module extends AbstractModule{

    @Override
    protected void configure() {
        this.bind(SplashView.class).in(Scopes.SINGLETON);
        this.bind(MainView.class).in(Scopes.SINGLETON);
        
        this.bind(MasterBusinessController.class).in(Scopes.SINGLETON);
        this.bind(MasterViewController.class).in(Scopes.SINGLETON);
        
        this.bind(WeatherService.class).in(Scopes.SINGLETON);
        this.bind(GravityMethodService.class).in(Scopes.SINGLETON);
        this.bind(DecoratorService.class).in(Scopes.SINGLETON);
        this.bind(BrowserService.class).in(Scopes.SINGLETON);
        
        this.bind(ElevationService.class).in(Scopes.SINGLETON);
        this.bind(GeocodingService.class).in(Scopes.SINGLETON);
        this.bind(PlaceService.class).in(Scopes.SINGLETON);
        this.bind(RouteService.class).in(Scopes.SINGLETON);
        this.bind(StreetViewService.class).in(Scopes.SINGLETON);
        this.bind(MapURLService.class).in(Scopes.SINGLETON);
        this.bind(StaticMapService.class).in(Scopes.SINGLETON);
        

        
        this.bind(IViewRepresentationHandler.class).annotatedWith(Names.named("splash")).to(SplashView.class).in(Scopes.SINGLETON);
        this.bind(IViewRepresentationHandler.class).annotatedWith(Names.named("main")).to(MainView.class).in(Scopes.SINGLETON);
        this.bind(IWheaterServiceInformationHandler.class).to(WeatherService.class);
        this.bind(IWheaterServiceInformationDelegate.class).to(WeatherService.class);
        
        this.bind(IMapInformationHandler.class).annotatedWith(Names.named("elevation")).to(ElevationService.class);
        this.bind(IMapInformationHandler.class).annotatedWith(Names.named("geocoding")).to(GeocodingService.class);
        this.bind(IMapInformationHandler.class).annotatedWith(Names.named("places")).to(PlaceService.class);
        this.bind(IMapInformationHandler.class).annotatedWith(Names.named("rouce")).to(RouteService.class);
        this.bind(IMapInformationHandler.class).annotatedWith(Names.named("streetview")).to(StreetViewService.class);
        this.bind(IMapInformationHandler.class).annotatedWith(Names.named("showmaps")).to(MapURLService.class);
        this.bind(IMapInformationHandler.class).annotatedWith(Names.named("staticmaps")).to(StaticMapService.class);
        
        this.bind(IGravityServiceInformationHandler.class).to(GravityMethodService.class);
        this.bind(INodeRepresentationDelegate.class).to(MainView.class);
        this.bind(INodeInformationDelegate.class).to(MasterViewController.class);
        this.bind(INodeInformationHandler.class).to(MasterViewController.class);
        
        
        
        
    }

}
