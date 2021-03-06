package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUiFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTest extends CoreTestCase{

    private static final String name_of_folder = "Learning programming";
    private static final String login = "Myuser2019";
    private static final String password = "learnqa";

    @Test
    public void testSaveArticleToMyList() throws InterruptedException {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);;

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        //ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();


        if(Platform.getInstance().isAndroid()) {

            ArticlePageObject.addFirstArticleToMyList(name_of_folder);
        }

        else if(Platform.getInstance().isIOS()) {

            ArticlePageObject.addFirstArticleToMyIOSList();

        }

        if (Platform.getInstance().isMW()) {

            ArticlePageObject.addFirstArticleToMySavedList();

        }

        ArticlePageObject.closeArticle();

        //add second article
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Pyton");
        SearchPageObject.clickByArticleWithSubstring("eneral-purpose, high-level programming language");

        //ArticlePageObject.waitForTitleElement();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addNextArticleToMyList(name_of_folder);

        } else {

            ArticlePageObject.addNextArticleToMyIOSList();

        }


        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUiFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);



        if(Platform.getInstance().isAndroid()) {

            MyListPageObject.openFolderByName(name_of_folder);
        }



        MyListPageObject.swipeByArticleToDelete(article_title);

        int amount_of_search_results = MyListPageObject.getAmountOfSavedArticles();

        assertTrue(
                "We found a few results",
                amount_of_search_results == 1);


    }



}
