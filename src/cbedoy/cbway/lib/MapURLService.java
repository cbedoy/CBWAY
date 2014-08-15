package cbedoy.cbway.lib;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.xml.xpath.XPath;
import org.w3c.dom.Document;

/**
 * --------------------------------------------------------
 * Created by Carlos Bedoy on 21/05/14.
 * CBMaps
 * Mobile Developer
 * Aguascalientes Mexico
 * Email:       carlos.bedoy@gmail.com
 * Facebook:    https://www.facebook.com/carlos.bedoy
 * ---------CODE && MUSIC ----------------------------------
 */
public class MapURLService extends AbstractMap {
    private String URLRoot="http://maps.google.es/maps?q=";

    @Override
    protected void onError(URL urlRequest, String status, Exception ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getStatus(XPath xpath, Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void storeInfoRequest(URL urlRequest, String info, String status, Exception exception) {
                super.storageRequest(urlRequest.toString(), "Map request", "OK", null);
    }

    public String getURLMap(String address) throws MalformedURLException, UnsupportedEncodingException{
         URL urlReturn=new URL(URLRoot + URLEncoder.encode(address, "utf-8") + "&output=embed");
         this.storeInfoRequest(urlReturn,null,null,null);
         return urlReturn.toString();
    }

    public String getURLMap(Double latitude, Double longitude) throws MalformedURLException{
        URL urlReturn=new URL(URLRoot + String.valueOf(latitude)+ "%2C" + String.valueOf(longitude) + "&output=embed");
         this.storeInfoRequest(urlReturn,null,null,null);
         return urlReturn.toString();
    }
}
