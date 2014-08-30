package cbedoy.cbway.interfaces;

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
 * 25-may-2014 - 10:56:09
 */

public interface IGravityServiceInformationHandler {


    public enum SOLUTIONS{
        X,
        Y,
        COUNTRY,
        STATE,
        CITY,
        DELEGATION
    }


    public void solveNodes(List<Object> dataModel);
    
    public HashMap<Object, Object> getSolution();
    
}
