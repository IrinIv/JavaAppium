package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {


    protected static String

        FOLDER_BY_NAME_TEMPLATE ,
        ARTICLE_BY_TITLE_TEMPLATE,
        BUTTON_EDIT ,
        SAVED_ARTICLE ,
        BUTTON_UNSAVE,
        SAVED_ARTICLES;



    private static String getFolderXpathByName(String name_of_folder) {

        return FOLDER_BY_NAME_TEMPLATE.replace("{FOLDER_NAME}", name_of_folder);
    }


    private static String getSavedArticleXpathByTitle(String article_title) {

        return ARTICLE_BY_TITLE_TEMPLATE.replace("{TITLE}", article_title);
    }



    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openFolderByName(String name_of_folder) {

        String folder_name_xpath = getFolderXpathByName(name_of_folder);

        this.waitForElementAndClick(folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                5);

    }


    public void waitForArticleToDisappearByTitle(String article_title){

        String article_xpath = getSavedArticleXpathByTitle(article_title);

        this.waitForElementNotPresent(article_xpath,
                "Saved article still present with title " + article_title,
                15);

    }

    public void waitForArticleToAppearByTitle(String article_title){

        String article_xpath = getSavedArticleXpathByTitle(article_title);

        this.waitForElementPresent(article_xpath,
                "Cannot find saved article by title " + article_title,
                15);

    }




    public void swipeByArticleToDelete(String article_title){


        String article_xpath = getSavedArticleXpathByTitle(article_title);

        this.waitForArticleToAppearByTitle(article_title);

        this.swipeElementToLeft(article_xpath,
                "Cannot find saved article");

        if(Platform.getInstance().isIOS()) {

             this.clickElementToTheRightUpperCorner(article_xpath,
                     "Can not find saved article");

        }

        this.waitForArticleToDisappearByTitle(article_title);


    }


    public void selectArticleFromIOSReadingList() {

        this.waitForElementAndClick(BUTTON_EDIT,
                "Cannot find and click edit button on iOS",
                5);

        this.waitForElementAndClick(SAVED_ARTICLE,
                "Cannot find and click saved article on iOS",
                5);
    }


    public void deleteArticleFromIOSLIst() {

        this.waitForElementAndClick(BUTTON_UNSAVE,
                "Cannot find and click Unsave button on iOS",
                5);


    }

    public int getAmountOfSavedArticles() {


        this.waitForElementPresent(SAVED_ARTICLES,
                "Cannot find anything by request ",
                15);

        return this.getAmountOfElements(SAVED_ARTICLES);

    }
}
