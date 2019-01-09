package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.MyListsPageObject;
import lib.ui.android.AndroidArticlePageObject;
import lib.ui.android.AndroidMyListsPageObject;
import lib.ui.ios.IOSArticlePageObject;
import lib.ui.ios.IOSMyListsPageObject;
import lib.ui.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObjectFactory  {

    public static MyListsPageObject get(RemoteWebDriver driver) {

        if(Platform.getInstance().isAndroid()) {

            return new AndroidMyListsPageObject(driver);

        } else if(Platform.getInstance().isMW()) {

            return new MWMyListsPageObject(driver);
        }

        else

            return new IOSMyListsPageObject(driver);
    }

}
