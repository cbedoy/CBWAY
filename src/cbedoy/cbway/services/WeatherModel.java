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
    
    private HashMap<String, Object> dataModel;
    
    public WeatherModel(HashMap<String, Object> dataModel){
        this.dataModel = dataModel;
    }

    public Object getId(){
        System.out.println(dataModel.get("id"));
        return dataModel.get("id");
    }
    
    public Object getDt(){
        return dataModel.get("dt");
    }
    
    public Object getLatitude(){
        return this.dataModel.get("latitude");
    }
    
    public Object getLength(){
        return this.dataModel.get("length");
    }
    
    public Object getName(){
        return this.dataModel.get("name");
    }
    
    public Object getCode(){
        return this.dataModel.get("code");
    }
    
    public Object getMessage(){
        return this.dataModel.get("message");
    }
    
    public Object getCountry(){
        return this.dataModel.get("country");
    }
    
    public Object getSunrise(){
        return this.dataModel.get("sunrise");
    }
    
    public Object getSunset(){
        return this.dataModel.get("sunset");
    }
    
    public Object getTemp(){
        return this.dataModel.get("temp");
    }
    
    public Object getPressure(){
        return this.dataModel.get("pressure");
    }
    
    public Object getHumidity(){
        return this.dataModel.get("humidity");
    }
    
    public Object getTempMax(){
        return this.dataModel.get("temp_max");
    }
    
    public Object getTempMin(){
        return this.dataModel.get("temp_min");
    }
    
    public Object getSpeed(){
        return this.dataModel.get("speed");
    }
    
    public Object getDeg(){
        return this.dataModel.get("deg");
    }
}

