package cb.cmap.bussinescontrollers;

import cb.cmap.interfaces.IGravityServiceDelegate;
import cb.cmap.interfaces.INodeRepresentationDelegate;
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

public class MasterViewController{
    
    private MasterController            masterController;
    private static MasterViewController masterViewController;
    private List<Object>                dataModel;
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


    public void setDataModel(List<Object> dataModel) {
        this.dataModel = dataModel;
    }

    public void setNodeRepresentationDelegate(INodeRepresentationDelegate nodeRepresentationDelegate) {
        this.nodeRepresentationDelegate = nodeRepresentationDelegate;
    }

    public List<Object> getDataModel() {
        return dataModel;
    }

    public IGravityServiceDelegate getGravityServiceDelegate() {
        return gravityServiceDelegate;
    }

    public void setGravityServiceDelegate(IGravityServiceDelegate gravityServiceDelegate) {
        this.gravityServiceDelegate = gravityServiceDelegate;
    }
    
    
}
