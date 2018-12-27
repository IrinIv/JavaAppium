package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;

public class CoreTestCase extends TestCase {


    protected AppiumDriver driver;


    @Override
    protected void setUp() throws Exception {

        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomeScreenForIosApp();

    }


    @Override
    protected void tearDown() throws Exception {

        driver.quit();

        super.tearDown();
    }

    public void rotateScreenPortrait(){

        driver.rotate(ScreenOrientation.PORTRAIT);
    }


    public void rotateScreenLandscape(){

        driver.rotate(ScreenOrientation.LANDSCAPE);
    }


    protected void backgroundApp(int seconds) {

        driver.runAppInBackground(seconds);
    }

    private void skipWelcomeScreenForIosApp() {

        if(Platform.getInstance().isIOS()) {

            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();

        }

    }

}
