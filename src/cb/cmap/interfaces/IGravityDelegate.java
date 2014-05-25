package cb.cmap.interfaces;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Carlos on 11/05/2014.
 */
public interface IGravityDelegate {

    public void userWantsSolved(List<Object> countries);
    public HashMap<String, Object> getBestPosition();
}
