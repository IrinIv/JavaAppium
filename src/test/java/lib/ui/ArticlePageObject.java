package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.assertEquals;

abstract public  class ArticlePageObject extends MainPageObject {

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            MY_SAVED_LIST,
            CLOSE_DIALOG_BUTTON,
            TABLE_CONTENT_BUTTON;

    private static final String login = "Myuser2019";
    private static final String password = "learnqa";



    public WebElement waitForTitleElement() {


            return this.waitForElementPresent(TITLE,
                    "Cannot find article title on page",
                    15);

    }



    public String getArticleTitle() {

        WebElement title_element = waitForTitleElement();

        if(Platform.getInstance().isAndroid()) {

            return title_element.getAttribute("text");
        }

        else if (Platform.getInstance().isIOS()){

            return title_element.getAttribute("name");
        }

        else

            return title_element.getText();
    }



    public void swipeToFooter(){

        if(Platform.getInstance().isAndroid()) {
        this.swipeUpTillFindElement(FOOTER_ELEMENT,
                "Cannot find the end of this article",
                40);
             }

             else if (Platform.getInstance().isIOS()){

            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                "Cannot find the end of this article",
                40);

        }

        else {
            this.scrollWebPageUntilElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of this article",
                    40);
        }

    }

    public void addFirstArticleToMyList(String name_of_folder) {


        this.waitForElementAndClick(OPTIONS_BUTTON,
                "Cannot find button 'More options'",
                5);


        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find 'Add to reading list' button",
                5);

        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY,
                "Cannot find button 'Got it'",
                5);

        this.waitForElementAndClear(MY_LIST_NAME_INPUT,
                "Cannot find input to set name of my reading list",
                5);



        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text to set name of my reading list",
                5);


        this.waitForElementAndClick(MY_LIST_OK_BUTTON,
                "Cannot find button Ok",
                5);

    }

        public void addFirstArticleToMyIOSList() {


        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button 'Reading List' on iOS",
                10);

        this.waitForElementAndClick(CLOSE_DIALOG_BUTTON,
                    "Cannot find button 'Close dialog' on iOS",
                    5);


        }

    public void addNextArticleToMyList(String name_of_folder) {


        this.waitForElementAndClick(OPTIONS_BUTTON,
                "Cannot find button 'More options'",
                5);


        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find 'Add to reading list' button",
                5);


        this.waitForElementAndClick(MY_SAVED_LIST,
                "Cannot find created folder",
                5);


    }

    public void addNextArticleToMyIOSList() {

        if(Platform.getInstance().isMW()) {

            this.removeArticleFromSavedIfItAdded();
        }

            this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button 'Reading List' on iOS/MW",
                    10);

          }

    public void closeArticle() {

        if(Platform.getInstance().isIOS() || (Platform.getInstance().isAndroid())) {

            this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON,
                    "Cannot find Close button",
                    5);

        }

        else System.out.println("Method closeArticle() does nothing for Platform: " + Platform.getInstance().getPlatformVar());


    }

    public void removeArticleFromSavedIfItAdded () {

        if(this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {

            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Can not click button to remove an article from saved",
                    10);

            this.waitForElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Can not find button to add an article to saved list after removing",
                    10);


        }
    }


    public void addFirstArticleToMySavedList() {

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to save to list",
                5);

        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
        Auth.clickAuthButton();
        Auth.enterLoginData(login, password);
        Auth.submitForm();


        this.removeArticleFromSavedIfItAdded();

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to save to list",
                10);

        this.waitForTitleElement();

        String article_title = this.getArticleTitle();

        assertEquals("We are not on the same page after login",
                article_title,
                this.getArticleTitle());


    }
}


