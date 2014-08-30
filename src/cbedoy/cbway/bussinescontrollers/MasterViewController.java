package cbedoy.cbway.bussinescontrollers;

import cbedoy.cbway.interfaces.*;
import cbedoy.cbway.interfaces.IGravityServiceInformationHandler.*;
import cbedoy.cbway.lib.GeocodingService;
import cbedoy.cbway.services.WeatherKeySet;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
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
 * 25-may-2014 - 0:18:42
 */

public class MasterViewController implements INodeInformationHandler, INodeInformationDelegate {
    
    private MasterBusinessController            masterBusinessController;
    private static MasterViewController         masterViewController;
    private INodeRepresentationDelegate         nodeRepresentationDelegate;
    private IGravityServiceInformationHandler   gravityServiceDelegate;
    private IWheaterServiceInformationHandler   wheatherServiceDelegate;
    private IWheaterServiceInformationDelegate  wheatherServiceInformationDelegate;
    
    public static MasterViewController getInstance(){
        if(masterViewController == null)
            masterViewController = new MasterViewController();
        return masterViewController;
    }
    

    public MasterBusinessController getMasterBusinessController() {
        return masterBusinessController;
    }

    public void setMasterBusinessController(MasterBusinessController masterBusinessController) {
        this.masterBusinessController = masterBusinessController;
    }

    public void setNodeRepresentationDelegate(INodeRepresentationDelegate nodeRepresentationDelegate) {
        this.nodeRepresentationDelegate = nodeRepresentationDelegate;
    }

    public IGravityServiceInformationHandler getGravityServiceDelegate() {
        return gravityServiceDelegate;
    }

    public void setGravityServiceDelegate(IGravityServiceInformationHandler gravityServiceDelegate) {
        this.gravityServiceDelegate = gravityServiceDelegate;
    }

    public INodeRepresentationDelegate getNodeRepresentationDelegate() {
        return nodeRepresentationDelegate;
    }

    @Override
    public void userRequestSolution() {
        try {
            HashMap<Object, Object> solution    = gravityServiceDelegate.getSolution();
            double positionX                    = (double) solution.get("position_x");
            double positionY                    = (double) solution.get("position_y");
            ArrayList<String> address           = masterBusinessController.getGeocoding().getAddress(positionX, positionY);
            String[] countryState               = address.get(1).split(", ");
            String[] cityAbbreviature           = address.get(0).split(", ");
            solution.put(SOLUTIONS.COUNTRY, address.get(2));
            solution.put(SOLUTIONS.STATE, countryState[0]);
            solution.put(SOLUTIONS.CITY, cityAbbreviature[1]);
            solution.put(SOLUTIONS.DELEGATION, cityAbbreviature[0]);
            nodeRepresentationDelegate.reloadData(solution);
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            
        }
    }

    @Override
    public void userRequestInformationTable() {
        List<Object> dataModel          = masterBusinessController.getDataModel();
        Object lastRow                  = dataModel.get(dataModel.size()-1);
        nodeRepresentationDelegate.reloadTable((HashMap<WeatherKeySet, Object>) lastRow);
    }

    @Override
    public void userSelectedCountryWithCost(String country, Double cost) {
        try {
            List<Object> dataModel                              = masterBusinessController.getDataModel();
            HashMap<WeatherKeySet, Object> data                 = new HashMap<WeatherKeySet, Object>();
            GeocodingService geocoding                               = masterBusinessController.getGeocoding();
            Point2D.Double coordinates                          = geocoding.getCoordinates(country);
            wheatherServiceDelegate.requestWithCordinates(coordinates.x, coordinates.y);
            HashMap<WeatherKeySet, Object> serviceInformation   = wheatherServiceInformationDelegate.getDataModel();
            data.put(WeatherKeySet.COUNTRY,     country);
            data.put(WeatherKeySet.LATITUDE,    coordinates.getX());
            data.put(WeatherKeySet.LENGTH,      coordinates.getY());
            data.put(WeatherKeySet.COST,        cost);
            data.put(WeatherKeySet.MESSAGE,     serviceInformation.get(WeatherKeySet.MESSAGE));
            data.put(WeatherKeySet.TEMP,        serviceInformation.get(WeatherKeySet.TEMP));
            data.put(WeatherKeySet.TEMP_MAX,    serviceInformation.get(WeatherKeySet.TEMP_MAX));
            data.put(WeatherKeySet.TEMP_MIN,    serviceInformation.get(WeatherKeySet.TEMP_MIN));
            data.put(WeatherKeySet.HUMIDITY,    serviceInformation.get(WeatherKeySet.HUMIDITY));
            data.put(WeatherKeySet.PRESURE,     serviceInformation.get(WeatherKeySet.PRESURE));
            data.put(WeatherKeySet.SPEED,       serviceInformation.get(WeatherKeySet.SPEED));
            data.put(WeatherKeySet.SUNRISE,     serviceInformation.get(WeatherKeySet.SUNRISE));
            data.put(WeatherKeySet.SUNSET,      serviceInformation.get(WeatherKeySet.SUNSET));
            dataModel.add(data);
            masterBusinessController.setDataModel(dataModel);
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            
        }
    }    

    public void setWheatherServiceDelegate(IWheaterServiceInformationHandler wheatherServiceDelegate) {
        this.wheatherServiceDelegate = wheatherServiceDelegate;
    }

    public void setWheatherServiceInformationDelegate(IWheaterServiceInformationDelegate wheatherServiceInformationDelegate) {
        this.wheatherServiceInformationDelegate = wheatherServiceInformationDelegate;
    }

    @Override
    public void userRequestMap() {
        
    }
}
