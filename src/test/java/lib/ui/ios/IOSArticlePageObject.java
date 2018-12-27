package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject{

    static {


        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        TABLE_CONTENT_BUTTON = "id:Table of contents";
        MY_SAVED_LIST = "";
        CLOSE_DIALOG_BUTTON = "id:places auth close";


    }




    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
