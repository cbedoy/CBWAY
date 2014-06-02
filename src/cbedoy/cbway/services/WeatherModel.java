package cbedoy.cbway.services;

import java.util.HashMap;

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
 * 1/06/2014 - 07:29:42 PM
 */

public class WeatherModel {
    
    private final HashMap<String, Object> dataModel;
    
    public WeatherModel(HashMap<String, Object> dataModel){
        this.dataModel = dataModel;
    }

    private Object getId(){
        return dataModel.get("id");
    }
    
    private Object getDt(){
        return dataModel.get("dt");
    }
    
    private Object getLatitude(){
        return this.dataModel.get("latitude");
    }
    
    private Object getLength(){
        return this.dataModel.get("length");
    }
    
    private Object getName(){
        return this.dataModel.get("name");
    }
    
    private Object getCode(){
        return this.dataModel.get("code");
    }
    
    private Object getMessage(){
        return this.dataModel.get("message");
    }
    
    private Object getCountry(){
        return this.dataModel.get("country");
    }
    
    private Object getSunrise(){
        return this.dataModel.get("sunrise");
    }
    
    private Object getSunset(){
        return this.dataModel.get("sunset");
    }
    
    private Object getTemp(){
        return this.dataModel.get("temp");
    }
    
    private Object getPressure(){
        return this.dataModel.get("pressure");
    }
    
    private Object getHumidity(){
        return this.dataModel.get("humidity");
    }
    
    private Object getTempMax(){
        return this.dataModel.get("temp_max");
    }
    
    private Object getTempMin(){
        return this.dataModel.get("temp_min");
    }
    
    private Object getSpeed(){
        return this.dataModel.get("speed");
    }
    
    private Object getDeg(){
        return this.dataModel.get("deg");
    }
}

