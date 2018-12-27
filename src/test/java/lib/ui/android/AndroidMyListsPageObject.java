package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {

        FOLDER_BY_NAME_TEMPLATE = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TEMPLATE = "xpath://*[@text='{TITLE}']";
    }

    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
