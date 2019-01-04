package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static

    {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form > input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_ELEMENT = "css:ul.page > li.page-summary";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikipedia-discription')][contains(@text(), '{SUBSTRINGS}')]";
        EMPTY_RESULT_LABEL = "css:p.without-results";
    }



    public MWSearchPageObject(RemoteWebDriver driver) {

        super(driver);
    }

}
