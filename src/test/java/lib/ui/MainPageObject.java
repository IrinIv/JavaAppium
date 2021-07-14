package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lib.Platform;

import java.util.List;
import java.util.regex.Pattern;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver){

        this.driver = driver;
    };

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds) {

        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds) {


        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");


        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();

        return element;

    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds) {


        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");


        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);

        return element;

    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds) {


        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");


        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();

        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {

        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void swipeUp(int timeOfSwipe) {

        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver)driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int)(size.height * 0.8);
            int end_y = (int)(size.height * 0.2);

            action.
                    press(point(x, start_y)).
                    waitAction(waitOptions(ofSeconds(timeOfSwipe))).
                    moveTo(point(x, end_y)).
                    release().
                    perform();

        }

        else System.out.println("Method swipeUp() does nothing for Platform: " + Platform.getInstance().getPlatformVar());
    }

    public void scrollWebPageUp() {
        if(Platform.getInstance().isMW()) {

            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0, 250)");
        }

        else System.out.println("Method scrollWebPageUp() does nothing for Platform: " + Platform.getInstance().getPlatformVar());

    }


    public void scrollWebPageUntilElementNotVisible(String locator, String error_message, int max_swipes) {

        int already_swiped = 0;

        WebElement element = waitForElementPresent(locator, error_message, 5);

        while (!this.isElementLocatedInTheScreen(locator)) {

            scrollWebPageUp();
            ++already_swiped;

            if(already_swiped > max_swipes){
                Assert.assertTrue(error_message, element.isDisplayed());
            }

        }

    }


    public void swipeUpQuick(){
        swipeUp(200);

    }

    public void swipeUpTillFindElement(String locator, String error_message, int max_swipes) {

        By by = this.getLocatorByString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swiped > max_swipes) {
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;

            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void swipeElementToLeft(String locator, String error_message) {

        if (driver instanceof AppiumDriver) {

            WebElement element = waitForElementPresent(locator, error_message, 15);


            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();

            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;


            TouchAction action = new TouchAction((AppiumDriver)driver);

            action.press(point(right_x, middle_y));
            action.waitAction(waitOptions(ofSeconds(300)));

            if (Platform.getInstance().isAndroid()) {
                action.moveTo(point(left_x, middle_y));
            } else {
                int offset_x = (-1 * element.getSize().getWidth());
                action.moveTo(point(offset_x, 0));

            }

            action.release();
            action.perform();

        }

        else System.out.println("Method swipeElementToLeft() does nothing for Platform: " + Platform.getInstance().getPlatformVar());
    }

    public int getAmountOfElements(String locator) {

        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);

        return elements.size();


    }

    public void assertElementNotPresent(String locator, String error_message) {


        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + locator + "' supposed to be present";

            throw new AssertionError(default_message + " " + error_message);
        }

    }

    public void assertElementPresent(String locator, String error_message){

        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements == 0) {
            String default_message = "An element '" + locator + "' not supposed to be present";

            throw new AssertionError(default_message + " " + error_message);

        }


    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeOutInSeconds) {

        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);

        return element.getAttribute(attribute);

    }

    private By getLocatorByString(String locator_with_type) {

        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")){
            return By.xpath(locator);

        } else if (by_type.equals("id")) {
            return By.id(locator);

        } else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        }

        else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator is " + locator_with_type);
        }

        }


        public void swipeUpTillElementAppear(String locator, String error_message, int max_swipes) {

            int already_swiped = 0;

            while(!this.isElementLocatedInTheScreen(locator)) {

                if(already_swiped > max_swipes) {

                    Assert.assertTrue(error_message, this.isElementLocatedInTheScreen(locator));

                }

                swipeUpQuick();
                ++already_swiped;
            }

        }

        public boolean isElementLocatedInTheScreen(String locator) {

            int element_location_by_y = this.waitForElementPresent(locator,
                    "Cannot find element by locator",
                    3).getLocation().getY();

            if(Platform.getInstance().isMW()) {
                JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;

                Object js_result = JSExecutor.executeScript("return window.pageYOffset");
                element_location_by_y -= Integer.parseInt(js_result.toString());

            }

            int screen_size_by_y = driver.manage().window().getSize().getHeight();

            return element_location_by_y < screen_size_by_y;

        }

        public void clickElementToTheRightUpperCorner(String locator, String error_message) {

            if (driver instanceof AppiumDriver) {


                WebElement element = this.waitForElementPresent(locator + "/..", error_message, 5);
                int right_x = element.getLocation().getX();
                int upper_y = element.getLocation().getY();
                int lower_y = upper_y + element.getSize().getHeight();
                int middle_y = (upper_y + lower_y) / 2;
                int width = element.getSize().getWidth();

                int point_to_click_x = (right_x + width) - 3;
                int point_to_click_y = middle_y;

                TouchAction action = new TouchAction((AppiumDriver)driver);
                action.tap(point(point_to_click_x, point_to_click_y)).perform();

            }

            else System.out.println("Method clickElementToTheRightUpperCorner() does nothing for Platform: " + Platform.getInstance().getPlatformVar());
        }

        public boolean isElementPresent(String locator) {

        return getAmountOfElements(locator) > 0;

        }

        public void tryClickElementWithFewAttempts(String locator, String error_message, int amount_of_attempts) {

            int current_attempts = 0;
            boolean need_more_attempts = true;

            while(need_more_attempts) {

                try{
                        this.waitForElementAndClick(locator, error_message, 1);
                        need_more_attempts = false;
                    }

                    catch(Exception e) {

                    if(current_attempts > amount_of_attempts) {
                        this.waitForElementAndClick(locator, error_message, 1);
                        }
                    }

                    ++current_attempts;

                }
            }

        }



