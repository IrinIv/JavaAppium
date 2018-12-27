package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {
    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static final String
        STEP_LEARN_MORE_LINK = "xpath://XCUIElementTypeButton[@name=\"Learn more about Wikipedia\"]",
        STEP_NEW_WAYS_TO_EXPLORE_TEXT = "xpath://XCUIElementTypeStaticText[@name=\"New ways to explore\"]",
        STEP_ADD_OR_EDIT_PREFER_LANGUAGES_LINK = "xpath://XCUIElementTypeButton[@name=\"Add or edit preferred languages\"]",
        STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "xpath://XCUIElementTypeButton[@name=\"Learn more about data collected\"]",
        STEP_NEXT_LINK = "xpath://XCUIElementTypeButton[@name=\"Next\"]",
        STEP_GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name=\"Get started\"]",
        SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";



    public void waitForLearnMoreLink() {

        this.waitForElementPresent(STEP_LEARN_MORE_LINK,
                "Cannot find 'Learn more about Wikipedia' link",
                10);

    }


    public void waitForNewWayToExploreText() {

        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'New ways to explore' text",
                10);

    }


    public void waitForAddOrEditPreferLanguagesLink() {

        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFER_LANGUAGES_LINK,
                "Cannot find 'Add or edit preferred languages' link",
                10);

    }

    public void waitLearnMoreAboutDataCollectedLink() {

        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find 'Learn more about data collected' link",
                10);

    }

    public void clickNextButton() {

        this.waitForElementAndClick(STEP_NEXT_LINK,
                "Cannot find and click 'Next' link",
                10);

    }

    public void clickGetStartedButton() {

        this.waitForElementAndClick(STEP_GET_STARTED_BUTTON,
                "Cannot find and click 'Get started' button",
                10);

    }

    public void clickSkip() {

        this.waitForElementAndClick(SKIP_BUTTON,
                "Can not find and click Skip Button",
                10);
    }
}
