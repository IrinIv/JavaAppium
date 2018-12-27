package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject{

    static {

                ARTICLE_BY_TITLE_TEMPLATE = "xpath://XCUIElementTypeLink[contains(@name, '{TITLE}')]";
                BUTTON_EDIT = "id:Edit";
                SAVED_ARTICLE = "id:Saved";
                BUTTON_UNSAVE = "id:Unsave";
                SAVED_ARTICLES = "xpath://XCUIElementTypeApplication[@name=\"Wikipedia\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell";

    }

    public IOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
