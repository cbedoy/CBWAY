package cbedoy.cbway.services;


import cbedoy.cbway.interfaces.IGravityServiceInformationHandler;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Carlos on 11/05/2014.
 */
public class GravityMethodService implements IGravityServiceInformationHandler {

    private static GravityMethodService gravityMethodService;
    private List<Object>     dataModel;
    private double           totalCost;
    private double           gravityX;
    private double           gravityY;

    public GravityMethodService(){
        totalCost           = 0;
        gravityX            = 0;
        gravityY            = 0;
    }
    
    private void calculateSummation() {
        for(Object information : dataModel){
            HashMap<WeatherKeySet, Object> data    = (HashMap<WeatherKeySet, Object>) information;
            totalCost                       += ((Double)data.get(WeatherKeySet.COST));  
        }
    }

    private void calculateGravityY() {
        for(Object information : dataModel){
            HashMap<WeatherKeySet, Object> data    = (HashMap<WeatherKeySet, Object>) information;
            gravityY                        += ((Double)data.get(WeatherKeySet.LENGTH)) * ((Double)data.get(WeatherKeySet.COST));
        }
    }

    private void calculateGravityX() {
        for(Object information : dataModel){
            HashMap<WeatherKeySet, Object> data    = (HashMap<WeatherKeySet, Object>) information;
            gravityX                                += ((Double)data.get(WeatherKeySet.LATITUDE)) * ((Double)data.get(WeatherKeySet.COST));
        }
    }

    @Override
    public void solveNodes(List<Object> dataModel) {
        this.dataModel = dataModel;
        calculateGravityX();
        calculateGravityY();
        calculateSummation();
    }

    @Override
    public HashMap<SOLUTIONS, Object> getSolution() {
        HashMap<SOLUTIONS, Object> data = new HashMap<SOLUTIONS, Object>();
        data.put(SOLUTIONS.X, gravityX/totalCost );
        data.put(SOLUTIONS.Y, gravityY/totalCost );
        return data;
    }
}
