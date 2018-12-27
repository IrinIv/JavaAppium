package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUi extends NavigationUI{


    public IOSNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }

    static {

        MY_LISTS_LINK = "id:Saved";
    }
}
