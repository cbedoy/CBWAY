package cbedoy.cbway.unittest;

import cbedoy.cbway.services.BrowserService;
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
 * 2/06/2014 - 01:20:44 AM
 */

public class UnitTestBrowser {
    public static void main(String[]cbedoy) throws URISyntaxException{
        URI uri = new URI("www.facebook.com");
        BrowserService.getInstance().openWebPage(uri);
    }
}
