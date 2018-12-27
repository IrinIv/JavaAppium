package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.NavigationUI;
import lib.ui.android.AndroidNavigationUi;
import lib.ui.ios.IOSNavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUiFactory {

    public static NavigationUI get(RemoteWebDriver driver) {

        if(Platform.getInstance().isAndroid()) {

            return new AndroidNavigationUi(driver);

        } else

            return new IOSNavigationUi(driver);
    }
}