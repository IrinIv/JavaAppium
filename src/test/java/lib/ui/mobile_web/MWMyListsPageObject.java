package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {

        ARTICLE_BY_TITLE_TEMPLATE = "xpath://XCUIElementTypeLink[contains(@name, '{TITLE}')]";
        BUTTON_EDIT = "id:Edit";
        SAVED_ARTICLE = "id:Saved";
        BUTTON_UNSAVE = "id:Unsave";
        SAVED_ARTICLES = "xpath://XCUIElementTypeApplication[@name=\"Wikipedia\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell";

    }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

