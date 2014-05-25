package cb.cmap.bussinescontrollers;

import cb.cmap.interfaces.IGravityServiceDelegate;
import cb.cmap.interfaces.INodeHandlerDelagate;
import cb.cmap.interfaces.INodeRepresentationDelegate;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;


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

public class MasterViewController implements INodeHandlerDelagate{
    
    private MasterController            masterController;
    private static MasterViewController masterViewController;
    private INodeRepresentationDelegate nodeRepresentationDelegate;
    private IGravityServiceDelegate     gravityServiceDelegate;
    
    
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
            solution.put("city", cityAbbreviature[0]);
            solution.put("abbreviature", cityAbbreviature[1]);
            nodeRepresentationDelegate.reloadData(solution);
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            
        }
    }

    @Override
    public void userRequestInformationTable() {
        
    }
    
}
