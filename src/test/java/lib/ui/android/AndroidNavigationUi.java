package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUi extends NavigationUI {

    public AndroidNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }

    static {

        MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }
}
