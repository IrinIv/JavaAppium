package lib.ui.mobile_web;

import lib.Platform;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {


    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    static {

        MY_LISTS_LINK = "css:[data-event-name='watchlist']";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
    }


}
