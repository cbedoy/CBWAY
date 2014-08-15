package cbedoy.cbway.unittest;

import cbedoy.cbway.services.DecoratorService;

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
 * 2/06/2014 - 01:05:42 AM
 */

public class UnitTestDecoratorService {
    public static void main(String[]cbedoy)
    {
        DecoratorService decorator = DecoratorService.getInstance();
        String dateFormated = decorator.getDateFormated(123456789);
        System.out.println(dateFormated);
    }
}
