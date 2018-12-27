package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUiFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test

    public void testPassThroughtWelcome() {


        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);

        if (Platform.getInstance().isAndroid()) {

            return;
        }


        /*WelcomePageObject.waitForLearnMoreLink();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForNewWayToExploreText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForAddOrEditPreferLanguagesLink();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitLearnMoreAboutDataCollectedLink();
        WelcomePageObject.clickGetStartedButton();*/


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        ArticlePageObject.addFirstArticleToMyIOSList();
        ArticlePageObject.closeArticle();

        //add second article
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Pyton");
        SearchPageObject.clickByArticleWithSubstring("General-purpose, high-level programming language");

        ArticlePageObject.addNextArticleToMyIOSList();
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUiFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        MyListPageObject.selectArticleFromIOSReadingList();
        MyListPageObject.deleteArticleFromIOSLIst();



        int amount_of_search_results = MyListPageObject.getAmountOfSavedArticles();

        assertTrue(
                "We found a few results",
                amount_of_search_results == 1);





    }


}
