package cbedoy.cbway.interfaces;

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
 * 28/05/2014 - 05:23:53 PM
 */

public interface IWheaterServiceDelegate {
    
    public void requestWithCity(String city);
    
    public void requestWithCordinates(double latitude, double length);
    
    public void requestWithCountryCity(String country, String city);
    
}
