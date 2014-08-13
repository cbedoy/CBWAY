package cbedoy.cbway.interfaces;

import cbedoy.cbway.services.WeatherKeySet;
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
 * 25-may-2014 - 0:09:36
 */

public interface INodeRepresentationDelegate {

    public void reloadData(HashMap<String, Object> dataModel);
    public void reloadTable(HashMap<WeatherKeySet, Object> dataModel);
    
}
