package cbedoy.cbway.services;

import java.sql.Date;
import java.text.SimpleDateFormat;

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
 * 2/06/2014 - 01:03:24 AM
 */

public class DecoratorService {
    
    private static DecoratorService decoratorService;
    
    public static DecoratorService getInstance(){
        if(decoratorService == null)
            decoratorService = new DecoratorService();
        return decoratorService;
    }
    
    public String getDateFormated(long time){
        Date date = new Date(time);
        System.out.println(date.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
