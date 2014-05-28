package cb.cmap.bussinescontrollers;

import cb.cmap.interfaces.IGravityServiceDelegate;
import cb.cmap.interfaces.INodeDelegate;
import cb.cmap.interfaces.INodeHandlerDelegate;
import cb.cmap.interfaces.INodeRepresentationDelegate;
import cb.cmap.interfaces.IWheaterServiceDelegate;
import cb.cmap.lib.CBGeocoding;
import cb.map.services.GravityMethodService;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
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
 * 25-may-2014 - 0:18:42
 */

public class MasterViewController implements INodeHandlerDelegate, INodeDelegate{
    
    private MasterController            masterController;
    private static MasterViewController masterViewController;
    private INodeRepresentationDelegate nodeRepresentationDelegate;
    private IGravityServiceDelegate     gravityServiceDelegate;
    private IWheaterServiceDelegate     wheatherServiceDelegate;
    
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
        nodeRepresentationDelegate.reloadTable((HashMap<String, Object>) lastRow);
    }

    @Override
    public void userSelectedCountryWithCost(String country, Double cost) {
        try {
            List<Object> dataModel          = masterController.getDataModel();
            HashMap<String, Object> data    = new HashMap<String, Object>();
            CBGeocoding geocoding           = masterController.getGeocoding();
            Point2D.Double coordinates      = geocoding.getCoordinates(country);
            data.put("name", country);
            data.put("latitude", coordinates.getX());
            data.put("length", coordinates.getY());
            data.put("cost", cost);
            dataModel.add(data);
            masterController.setDataModel(dataModel);
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            
        }
    }    

    public void setWheatherServiceDelegate(IWheaterServiceDelegate wheatherServiceDelegate) {
        this.wheatherServiceDelegate = wheatherServiceDelegate;
    }
}
