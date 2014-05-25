package cb.map.services;


import cb.cmap.interfaces.IGravityDelegate;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Carlos on 11/05/2014.
 */
public class GravityMethodService implements IGravityDelegate{

    private List<Object>     dataModel;
    private double           totalCost;
    private double           gravityX;
    private double           gravityY;

    public GravityMethodService(){
        totalCost           = 0;
        gravityX            = 0;
        gravityY            = 0;
    }

    @Override
    public void userWantsSolved(List<Object> countries) {
        this.dataModel = countries;
        calculateGravityX();
        calculateGravityY();
        calculateSummation();
    }

    private void calculateSummation() {
        for(Object information : dataModel){
            HashMap<String, Object> data = (HashMap<String, Object>) information;
            totalCost += ((Double)data.get("cost"));
        }
    }

    private void calculateGravityY() {
        for(Object information : dataModel){
            HashMap<String, Object> data = (HashMap<String, Object>) information;
            gravityY += ((Double)data.get("length")) * ((Double)data.get("cost"));
        }
    }

    private void calculateGravityX() {
        for(Object information : dataModel){
            HashMap<String, Object> data = (HashMap<String, Object>) information;
            gravityX += ((Double)data.get("latitude")) * ((Double)data.get("cost"));
        }
    }

    @Override
    public HashMap<String, Object> getBestPosition() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("position_x", gravityX/totalCost );
        data.put("position_y", gravityY/totalCost );
        return data;
    }
}
