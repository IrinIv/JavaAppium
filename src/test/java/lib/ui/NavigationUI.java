package lib.ui;


import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String

            MY_LISTS_LINK ,
            OPEN_NAVIGATION ;


    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickMyLists() {

        {
            if (Platform.getInstance().isMW()) {
                this.tryClickElementWithFewAttempts(
                        MY_LISTS_LINK,
                        "Cannot find navigation button to My list",
                        5);
            } else {
                this.waitForElementAndClick(
                        MY_LISTS_LINK,
                        "Cannot find navigation button to My list",
                        5);
            }
        }
    }

    public void openNavigation() {

        if(Platform.getInstance().isMW()) {

            waitForElementAndClick(OPEN_NAVIGATION,
                    "Can not find and click Open navigation button",
                    5);
        }
        else System.out.println("Method openNavigation() does nothing for Platform: " + Platform.getInstance().getPlatformVar());


    }


}
