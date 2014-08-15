package cbedoy.cbway.lib;

import java.awt.Dimension;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.imageio.ImageIO;
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
public class StaticMapService extends AbstractMap
{
    private final String URLRoot="http://maps.googleapis.com/maps/api/staticmap";

    public enum Format{
        png,
        png32,
        gif,
        jpg,
        jpg_baseline
    }

    public enum Maptype{roadmap, satellite, hybrid,terrain}
    
    @Override
    protected void onError(URL urlRequest, String status, Exception ex) {
        super.storageRequest(urlRequest.toString(), "Static maps request", "NO STATUS", ex);
    }

    @Override
    protected String getStatus(XPath xpath, Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void storeInfoRequest(URL urlRequest, String info, String status, Exception exception) {
        super.storageRequest(urlRequest.toString(), "Static maps request", "OK", exception);
    }
    
    /**
     * Crea un mapa estático con las características indicadas en los diferentes parámetros de la función
     * @param centerAddress centro del mapa que se creará (como "dirección postal" o "latitud,longitud")
     * @param zoom define el nivel de zoom del mapa, que determina su nivel de ampliación. Valores 0 muestran
     * todo el planeta y mayores que 21 muestran edificios individuales
     * @param size tamaño del mapa que se generará
     * @param scale afecta al número de píxeles que se muestran. Los dos valores posibles son 1 o 2
     * @param format define el formato de la imagen resultante
     * @param maptype define el tipo de mapa que se va a generar
     * @return devuelve una Image con el mapa estático asociado.<br/>
     * En caso de error devuelve null
     * @see StaticMapService.Format
     * @see StaticMapService.Maptype
     */
    public Image getStaticMap(String centerAddress,int zoom,Dimension size,int scale,Format format, Maptype maptype) throws MalformedURLException, UnsupportedEncodingException{
        URL url=new URL(URLRoot + "?center=" + URLEncoder.encode(centerAddress, "utf-8") + "&zoom=" + zoom +
                "&size=" + size.width + "x" + size.height + "&scale=" + scale +
                "&format=" + format.toString() + "&maptype=" + maptype.toString() + 
                "&markers=" + URLEncoder.encode(centerAddress, "utf-8") + super.getSelectPropertiesRequest());
        try {
            Image imageReturn;
            imageReturn=ImageIO.read(url);
            storeInfoRequest(url,null,null,null);
            return imageReturn;
        } catch (Exception e) {
            onError(url, "NO STATUS", e);
            return null;
        }
    }
}
