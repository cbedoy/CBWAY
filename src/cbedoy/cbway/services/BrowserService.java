package cbedoy.cbway.services;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

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
 * 2/06/2014 - 01:09:14 AM
 */

public class BrowserService {
    private static BrowserService browserService;
    
    public static BrowserService getInstance(){
        if(browserService == null)
            browserService = new BrowserService();
        return browserService;
    }
    
    public void openWebPage(URI uri){
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
