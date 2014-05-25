package cb.cmap.bussinescontrollers;

import cb.cmap.interfaces.INodeDelegate;
import cb.cmap.lib.CBElevation;
import cb.cmap.lib.CBGeocoding;
import cb.cmap.lib.CBPlaces;
import cb.cmap.lib.CBRoute;
import cb.cmap.lib.CBStreetView;
import cb.map.services.GravityMethodService;
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
    
    private static MasterController masterController;
    private List<Object>            dataModel;
    private CBElevation             elevation;
    private CBGeocoding             geocoding;
    private CBPlaces                places;
    private CBRoute                 route;
    private CBStreetView            streetView;
    private GravityMethodService    gravityService;
    
    public static MasterController getInstanse(){
        if(masterController == null)
            masterController = new MasterController();
        return masterController;
    }

    public CBElevation getElevation() {
        return elevation;
    }

    public void setElevation(CBElevation elevation) {
        this.elevation = elevation;
    }

    public CBGeocoding getGeocoding() {
        return geocoding;
    }

    public void setGeocoding(CBGeocoding geocoding) {
        this.geocoding = geocoding;
    }

    public CBPlaces getPlaces() {
        return places;
    }

    public void setPlaces(CBPlaces places) {
        this.places = places;
    }

    public CBRoute getRoute() {
        return route;
    }

    public void setRoute(CBRoute route) {
        this.route = route;
    }

    public CBStreetView getStreetView() {
        return streetView;
    }

    public void setStreetView(CBStreetView streetView) {
        this.streetView = streetView;
    }

    public GravityMethodService getGravityService() {
        return gravityService;
    }

    public void setGravityService(GravityMethodService gravityService) {
        this.gravityService = gravityService;
    }

    @Override
    public void userSelectedCountryWithCost(String country, Double cost) {
        
        try {
            HashMap<String, Object> data    = new HashMap<String, Object>();
            Point2D.Double coordinates      = geocoding.getCoordinates(country);
            data.put("name",                country);
            data.put("latitude",            coordinates.getX());
            data.put("length",              coordinates.getY());
            data.put("cost",                cost);
            dataModel                       .add(data);
            coordinates                     = null;
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            
        }
    }

    public void setDataModel(List<Object> dataModel) {
        this.dataModel = dataModel;
    }
    
    
}
