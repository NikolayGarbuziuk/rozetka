package rozetkaTests;

import org.junit.Assert;
import org.junit.Test;
import uaComRozetkaTests.pages.HomePage;
import uaComRozetkaTests.pages.ResultPage;
import utility.Log;


/**
 * Created by ПК on 05.06.2017.
 */
public class TaskTest extends BaseCase {

    @Test
    public void topProdazh3PerPage() throws Exception {



        String sTestCaseName = this.toString();
        Log.startTestCase(sTestCaseName);


        ResultPage page =  new HomePage(driver)                                           // open main page rozetka.com.ua
                .mainMenuItemClick("Смартфоны, ТВ и электроника")                          // go to phones, TV and electtr.
                .subMenuItemClick("Телефоны")                                              // go to Phones
                .subMenuItemClick("Смартфоны");                                            // go to SmartPhones

        // top sells from 1st page

        int page1TopSalesCount = page.searchForTopSells().size();
        Log.info("Page1: " + page1TopSalesCount);

        // top sells from 2nd page


        int page2TopSalesCount = page.goToPage(2).searchForTopSells().size();
        Log.info("Page2: " + page2TopSalesCount);

        int page3TopSalesCount = page.goToPage(3).searchForTopSells().size();
        Log.info("Page3: " + page3TopSalesCount);

        Assert.assertTrue(page1TopSalesCount<=3 && page2TopSalesCount<=3 && page3TopSalesCount <=3);  // not more 3 per page


        Log.endTestCase();

    }


}