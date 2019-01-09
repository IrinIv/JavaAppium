package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {

    private static final String

            LOGIN_BUTTON ="xpath://html/body/div[3]/a[text()='Log in']",
            LOGIN_INPUT = "css:input[name='wpName']",
            PASSWORD_INPUT = "css:input[name='wpPassword']",
            SUBMIT_BUTTON = "css:button#wpLoginAttempt";



    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton(){

        this.waitForElementPresent(LOGIN_BUTTON,
                "Can not find auth Button",
                5);

        this.waitForElementAndClick(LOGIN_BUTTON,
                "Can not find and click auth Button",
                5);

    }

    public void enterLoginData(String login, String password) {

        this.waitForElementAndSendKeys(LOGIN_INPUT,
                login,
                "Can not find and enter data to login input",
                5);

        this.waitForElementAndSendKeys(PASSWORD_INPUT,
                password,
                "Can not find and enter data to password input",
                5);
    }

    public void submitForm() {

        this.waitForElementAndClick(SUBMIT_BUTTON,
                "Can not find and click Submit Button",
                5);



    }

}
