package cbedoy.cbway.interfaces;

import cbedoy.cbway.services.WeatherKeySet;
import java.util.HashMap;

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
 * 28/05/2014 - 05:28:41 PM
 */

public interface IWheaterServiceInformationDelegate {

    public HashMap<WeatherKeySet, Object> getDataModel();
    
}
