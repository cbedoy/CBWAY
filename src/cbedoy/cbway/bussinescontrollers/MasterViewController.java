package cbedoy.cbway.bussinescontrollers;

import cbedoy.cbway.interfaces.IGravityServiceDelegate;
import cbedoy.cbway.interfaces.INodeDelegate;
import cbedoy.cbway.interfaces.INodeHandlerDelegate;
import cbedoy.cbway.interfaces.INodeRepresentationDelegate;
import cbedoy.cbway.interfaces.IWheaterServiceDelegate;
import cbedoy.cbway.interfaces.IWheaterServiceInformationDelegate;
import cbedoy.cbway.lib.CBGeocoding;
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

public class MasterViewController implements INodeHandlerDelegate, INodeDelegate{
    
    private MasterController                    masterController;
    private static MasterViewController         masterViewController;
    private INodeRepresentationDelegate         nodeRepresentationDelegate;
    private IGravityServiceDelegate             gravityServiceDelegate;
    private IWheaterServiceDelegate             wheatherServiceDelegate;
    private IWheaterServiceInformationDelegate  wheatherServiceInformationDelegate;
    public static MasterViewController getInstance(){
        if(masterViewController == null)
            masterViewController = new MasterViewController();
        return masterViewController;
    }
    

    public MasterController getMasterController() {
        return masterController;
    }

    public void setMasterController(MasterController masterController) {
        this.masterController = masterController;
    }

    public void setNodeRepresentationDelegate(INodeRepresentationDelegate nodeRepresentationDelegate) {
        this.nodeRepresentationDelegate = nodeRepresentationDelegate;
    }

    public IGravityServiceDelegate getGravityServiceDelegate() {
        return gravityServiceDelegate;
    }

    public void setGravityServiceDelegate(IGravityServiceDelegate gravityServiceDelegate) {
        this.gravityServiceDelegate = gravityServiceDelegate;
    }

    public INodeRepresentationDelegate getNodeRepresentationDelegate() {
        return nodeRepresentationDelegate;
    }

    @Override
    public void userRequestSolution() {
        try {
            HashMap<String, Object> solution    = gravityServiceDelegate.getSolution();
            double positionX                    = (double) solution.get("position_x");
            double positionY                    = (double) solution.get("position_y");
            ArrayList<String> address           = masterController.getGeocoding().getAddress(positionX, positionY);
            String[] countryState               = address.get(1).split(", ");
            String[] cityAbbreviature           = address.get(0).split(", ");
            solution.put("country", address.get(2));
            solution.put("state", countryState[0]);
            solution.put("city", cityAbbreviature[1]);
            solution.put("delegation", cityAbbreviature[0]);
            nodeRepresentationDelegate.reloadData(solution);
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            
        }
    }

    @Override
    public void userRequestInformationTable() {
        List<Object> dataModel          = masterController.getDataModel();
        Object lastRow                  = dataModel.get(dataModel.size()-1);
        nodeRepresentationDelegate.reloadTable((HashMap<WeatherKeySet, Object>) lastRow);
    }

    @Override
    public void userSelectedCountryWithCost(String country, Double cost) {
        try {
            List<Object> dataModel                              = masterController.getDataModel();
            HashMap<WeatherKeySet, Object> data                 = new HashMap<WeatherKeySet, Object>();
            CBGeocoding geocoding                               = masterController.getGeocoding();
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
            masterController.setDataModel(dataModel);
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            
        }
    }    

    public void setWheatherServiceDelegate(IWheaterServiceDelegate wheatherServiceDelegate) {
        this.wheatherServiceDelegate = wheatherServiceDelegate;
    }

    public void setWheatherServiceInformationDelegate(IWheaterServiceInformationDelegate wheatherServiceInformationDelegate) {
        this.wheatherServiceInformationDelegate = wheatherServiceInformationDelegate;
    }

    @Override
    public void userRequestMap() {
        
    }
}
