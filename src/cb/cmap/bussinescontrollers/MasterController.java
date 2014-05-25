package cb.cmap.bussinescontrollers;

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
 * 25-may-2014 - 0:11:41
 */

public class MasterController {
    
    private static MasterController masterController;
    
    public MasterController getInstanse(){
        if(masterController == null)
            masterController = new MasterController();
        return masterController;
    }
    
    
}
