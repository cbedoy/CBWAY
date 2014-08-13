package cbedoy.cbway.guice;

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
import cbedoy.cbway.lib.ShowCBMaps;
import cbedoy.cbway.lib.StaticCBMaps;
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
        
        this.bind(MasterController.class).in(Scopes.SINGLETON);
        this.bind(MasterViewController.class).in(Scopes.SINGLETON);
        
        this.bind(WeatherService.class).in(Scopes.SINGLETON);
        this.bind(GravityMethodService.class).in(Scopes.SINGLETON);
        this.bind(DecoratorService.class).in(Scopes.SINGLETON);
        this.bind(BrowserService.class).in(Scopes.SINGLETON);
        
        this.bind(CBElevation.class).in(Scopes.SINGLETON);
        this.bind(CBGeocoding.class).in(Scopes.SINGLETON);
        this.bind(CBPlaces.class).in(Scopes.SINGLETON);
        this.bind(CBRoute.class).in(Scopes.SINGLETON);
        this.bind(CBStreetView.class).in(Scopes.SINGLETON);
        this.bind(ShowCBMaps.class).in(Scopes.SINGLETON);
        this.bind(StaticCBMaps.class).in(Scopes.SINGLETON);
        

        
        this.bind(IViewDelegate.class).annotatedWith(Names.named("splash")).to(SplashView.class).in(Scopes.SINGLETON);
        this.bind(IViewDelegate.class).annotatedWith(Names.named("main")).to(MainView.class).in(Scopes.SINGLETON);
        this.bind(IWheaterServiceDelegate.class).to(WeatherService.class);
        this.bind(IWheaterServiceInformationDelegate.class).to(WeatherService.class);
        
        this.bind(IMapDelegate.class).annotatedWith(Names.named("elevation")).to(CBElevation.class);
        this.bind(IMapDelegate.class).annotatedWith(Names.named("geocoding")).to(CBGeocoding.class);
        this.bind(IMapDelegate.class).annotatedWith(Names.named("places")).to(CBPlaces.class);
        this.bind(IMapDelegate.class).annotatedWith(Names.named("rouce")).to(CBRoute.class);
        this.bind(IMapDelegate.class).annotatedWith(Names.named("streetview")).to(CBStreetView.class);
        this.bind(IMapDelegate.class).annotatedWith(Names.named("showmaps")).to(ShowCBMaps.class);
        this.bind(IMapDelegate.class).annotatedWith(Names.named("staticmaps")).to(StaticCBMaps.class);
        
        this.bind(IGravityServiceDelegate.class).to(GravityMethodService.class);
        this.bind(INodeRepresentationDelegate.class).to(MainView.class);
        this.bind(INodeDelegate.class).to(MasterViewController.class);
        this.bind(INodeHandlerDelegate.class).to(MasterViewController.class);
        
        
        
        
    }

}
