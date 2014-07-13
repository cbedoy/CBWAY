package cbedoy.cbway.bussinescontrollers;

import cbedoy.cbway.interfaces.INodeDelegate;
import cbedoy.cbway.lib.CBElevation;
import cbedoy.cbway.lib.CBGeocoding;
import cbedoy.cbway.lib.CBPlaces;
import cbedoy.cbway.lib.CBRoute;
import cbedoy.cbway.lib.CBStreetView;
import cbedoy.cbway.services.GravityMethodService;
import com.google.inject.Injector;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
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
 * 25-may-2014 - 0:11:41
 */

public class MasterController implements INodeDelegate{

    private List<Object>            dataModel;
    private Injector                injector;
    private CBElevation             elevation;
    private CBGeocoding             geocoding;
    private CBPlaces                places;
    private CBRoute                 route;
    private CBStreetView            streetView;
    private GravityMethodService    gravityService;
    
    @Override
    public void userSelectedCountryWithCost(String country, Double cost) {
        
        try {
            HashMap<String, Object> data    = new HashMap<String, Object>();
            Point2D.Double coordinates      = geocoding.getCoordinates(country);
            data.put("name", country);
            data.put("latitude", coordinates.getX());
            data.put("length", coordinates.getY());
            data.put("cost", cost);
            dataModel.add(data);
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            
        }
    }

    public void setDataModel(List<Object> dataModel) {
        this.dataModel = dataModel;
    }

    public List<Object> getDataModel() {
        return dataModel;
    }

    public void setInjector(Injector injector) {
        this.injector = injector;
        injectInstances();
    }

    private void injectInstances() {
        elevation       = injector.getInstance(CBElevation.class);
        geocoding       = injector.getInstance(CBGeocoding.class);
        places          = injector.getInstance(CBPlaces.class);
        route           = injector.getInstance(CBRoute.class);
        streetView      = injector.getInstance(CBStreetView.class);
        gravityService  = injector.getInstance(GravityMethodService.class);
    }
    
    
}
