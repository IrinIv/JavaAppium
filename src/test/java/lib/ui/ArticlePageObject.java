package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public  class ArticlePageObject extends MainPageObject {

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String
            TITLE,
            TITLE_TMP,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            MY_SAVED_LIST,
            CLOSE_DIALOG_BUTTON,
            TABLE_CONTENT_BUTTON;



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

        else {

            return title_element.getAttribute("name");
        }
    }



    public void swipeToFooter(){

        if(Platform.getInstance().isAndroid()) {
        this.swipeUpTillFindElement(FOOTER_ELEMENT,
                "Cannot find the end of this article",
                40);
             }

             else {

            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
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


        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                   "Cannot find button 'Reading List' on iOS",
                   5);


       }

    public void closeArticle() {

        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON,
                "Cannot find Close button",
                5);

    }



}


