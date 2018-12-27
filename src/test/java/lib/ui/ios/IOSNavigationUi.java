package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigationUi extends NavigationUI{


    public IOSNavigationUi(AppiumDriver driver) {
        super(driver);
    }

    static {

        MY_LISTS_LINK = "id:Saved";
    }
}
