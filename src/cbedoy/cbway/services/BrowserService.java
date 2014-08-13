package cbedoy.cbway.services;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
    
    private final String url = "https://www.google.com.mx/maps/@";
    private StringBuilder urlBuilder;
    private static BrowserService browserService;
    
    public static BrowserService getInstance(){
        if(browserService == null)
            browserService = new BrowserService();
        return browserService;
    }
    
    public BrowserService(){
        urlBuilder = new StringBuilder(url);
    } 
    
    public void openWebPage(double latitude, double lenght, int zoom) throws URISyntaxException, IOException{
        urlBuilder.append(latitude).append(",");
        urlBuilder.append(lenght).append(",");
        urlBuilder.append(zoom).append("z");
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI(urlBuilder.toString()));
        }
        urlBuilder = new StringBuilder(url);
    }
}
