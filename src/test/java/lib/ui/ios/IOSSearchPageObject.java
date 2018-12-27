package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject  extends SearchPageObject{


    static

    {       SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
            SEARCH_INPUT = "xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSearchField";
            SEARCH_CANCEL_BUTTON = "id:Close";
            SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{SUBSTRING}')]";
            EMPTY_RESULT_LABEL = "xpath://XCUIElementTypeStaticText[@name='No results found']";
    }



    public IOSSearchPageObject(RemoteWebDriver driver) {

        super(driver);
    }
}
