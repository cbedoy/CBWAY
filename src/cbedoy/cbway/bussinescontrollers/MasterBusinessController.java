package cbedoy.cbway.bussinescontrollers;

import cbedoy.cbway.interfaces.INodeInformationDelegate;
import cbedoy.cbway.lib.*;
import cbedoy.cbway.lib.ElevationService;
import cbedoy.cbway.services.GravityMethodService;
import java.awt.geom.Point2D;
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

public class MasterBusinessController implements INodeInformationDelegate {
    
    private static MasterBusinessController masterBusinessController;
    private List<Object>            dataModel;
    private ElevationService elevation;
    private GeocodingService geocoding;
    private PlaceService places;
    private RouteService route;
    private StreetViewService streetView;
    private GravityMethodService    gravityService;
    
    public static MasterBusinessController getInstanse(){
        if(masterBusinessController == null)
            masterBusinessController = new MasterBusinessController();
        return masterBusinessController;
    }

    public ElevationService getElevation() {
        return elevation;
    }

    public void setElevation(ElevationService elevation) {
        this.elevation = elevation;
    }

    public GeocodingService getGeocoding() {
        return geocoding;
    }

    public void setGeocoding(GeocodingService geocoding) {
        this.geocoding = geocoding;
    }

    public PlaceService getPlaces() {
        return places;
    }

    public void setPlaces(PlaceService places) {
        this.places = places;
    }

    public RouteService getRoute() {
        return route;
    }

    public void setRoute(RouteService route) {
        this.route = route;
    }

    public StreetViewService getStreetView() {
        return streetView;
    }

    public void setStreetView(StreetViewService streetView) {
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
            data.put("name", country);
            data.put("latitude", coordinates.getX());
            data.put("length", coordinates.getY());
            data.put("cost", cost);
            dataModel.add(data);
        } catch (Exception e) {
            
        }
    }

    public void setDataModel(List<Object> dataModel) {
        this.dataModel = dataModel;
    }

    public List<Object> getDataModel() {
        return dataModel;
    }
    
    
}
