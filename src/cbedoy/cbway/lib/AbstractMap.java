package cbedoy.cbway.lib;

import cbedoy.cbway.interfaces.IMapInformationHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

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
public abstract class AbstractMap implements IMapInformationHandler {

    //request properties 
    private static int connectTimeout       = 300;
    private static String region            = "es";
    private static String language          = "es";
    private static Boolean sensor           = Boolean.FALSE;
    private static String APIKey            = "";
    
    //Stock request
    private static String[][] stockRequest=new String[0][6];
    
    //Abstract methods
    protected abstract void onError(URL urlRequest,String status,Exception ex);
    protected abstract String getStatus(XPath xpath, Document document);
    protected abstract void storeInfoRequest(URL urlRequest,String info,String status,Exception exception);
    

    //Protected methods
    private static int numRequest=0;
    protected void storageRequest(String urlRequest,String info,String status,
            Exception exception){
        Date date = new Date();
        numRequest+=1;
        AbstractMap.stockRequest=(String[][])(this.resizeArray(AbstractMap.stockRequest,numRequest));
        if(AbstractMap.stockRequest[numRequest-1]==null){
                AbstractMap.stockRequest[numRequest-1]=new String[6];
            }
        AbstractMap.stockRequest[numRequest-1][0]=String.valueOf(numRequest);
        AbstractMap.stockRequest[numRequest-1][1]=date.toString();
        AbstractMap.stockRequest[numRequest-1][2]=status;
        AbstractMap.stockRequest[numRequest-1][3]=urlRequest;
        AbstractMap.stockRequest[numRequest-1][4]=info;
        if(exception==null){
            AbstractMap.stockRequest[numRequest-1][5]="No exception";
        }else{
            AbstractMap.stockRequest[numRequest-1][5]=exception.toString();
        }
        
    }
    
    protected String getSelectPropertiesRequest(){
        return "&region=" + AbstractMap.region + "&language=" + AbstractMap.language +
                "&sensor=" + AbstractMap.sensor;
    }
     protected ArrayList<String> getNodesString(NodeList node){
         ArrayList<String> result=new ArrayList<String>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(nodeString);
             }
        return result;
    }
     
    protected ArrayList<Double> getNodesDouble(NodeList node){
         ArrayList<Double> result=new ArrayList<Double>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(Double.valueOf(nodeString));
             }
        return result;
    }
    
    protected ArrayList<Integer> getNodesInteger(NodeList node){
         ArrayList<Integer> result=new ArrayList<Integer>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(Integer.valueOf(nodeString));
             }
        return result;
    }
    
    /**
    * 
    * Reallocates an array with a new size, and copies the contents
    * of the old array to the new array.
    * @param oldArray  the old array, to be reallocated.
    * @param newSize   the new array size.
    * @return          A new array with the same contents.
    */
    protected Object resizeArray (Object oldArray, int newSize) {
       int oldSize = java.lang.reflect.Array.getLength(oldArray);
       Class elementType = oldArray.getClass().getComponentType();
       Object newArray = java.lang.reflect.Array.newInstance(
             elementType, newSize);
       int preserveLength = Math.min(oldSize, newSize);
       if (preserveLength > 0)
          System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
       return newArray; 
    }

    public static String APIkeyCheck(String key){
        try{
            URL url=new URL("https://maps.googleapis.com/maps/api/place/search/xml?location=0,0&radius=1000" + 
                    "&sensor=false&key=" + key);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder(); 
            Document document = builder.parse(url.openStream()); 
            XPathFactory xpathFactory = XPathFactory.newInstance(); 
            XPath xpath = xpathFactory.newXPath(); 

            NodeList nodeLatLng = (NodeList) xpath.evaluate("PlaceSearchResponse/status", 
                            document, XPathConstants.NODESET);
            String status = nodeLatLng.item(0).getTextContent();
            return status;
        }catch (Exception e){
            return "NO STATUS";
        }
    }

    public static int getConnectTimeout() {
        return connectTimeout;
    }

    public static void setConnectTimeout(int aConnectTimeout) {
        connectTimeout = aConnectTimeout;
    }

    public static String getRegion() {
        return region;
    }

    public static void setRegion(String aRegion) {
        region = aRegion;
    }

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String aLanguage) {
        language = aLanguage;
    }

    /**
     * Obtiene si se está utilizando sensor GPS (GNSS) en las peticiones para obtener ubicación (de forma predeterminada es false)
     * @return devuelve true en caso de utilización del sensor y false en caso contrario
     * @see AbstractMap#setSensor(Boolean)
     */
    public static Boolean getSensor() {
        return sensor;
    }

    public static void setSensor(Boolean aSensor) {
        sensor = aSensor;
    }

    public static String getKey() {
        return APIKey;
    }

    public static void setKey(String aKey) {
        APIKey = aKey;
    }

    public static String[][] getStockRequest() {
        return stockRequest;
    }

    public static  String[] getLastRequestRequest() {
        String[] stockRequestTemp=new String[6];
        System.arraycopy(stockRequest[stockRequest.length-1], 0, stockRequestTemp, 0, 6);
        return stockRequestTemp;
    }

    public static String getLastRequestStatus() {
         return stockRequest[stockRequest.length-1][2];
    }

    public static String getLastRequestURL() {
        return stockRequest[stockRequest.length-1][3];
    }

    public static String getLastRequestInfo() {
         return stockRequest[stockRequest.length-1][4];
    }

    public static String getLastRequestException() {
         return stockRequest[stockRequest.length-1][5];
    }

  
}
