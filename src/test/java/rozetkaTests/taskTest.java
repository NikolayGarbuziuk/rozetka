package rozetkaTests;

import org.junit.Assert;
import org.junit.Test;
import uaComRozetkaTests.pages.HomePage;
import uaComRozetkaTests.pages.ResultPage;

/**
 * Created by ПК on 05.06.2017.
 */
public class taskTest extends BaseCase {

    @Test
    public void topProdazh3PerPage() throws Exception {

        ResultPage page =  new HomePage(driver)                                           // open main page rozetka.com.ua
                .mainMenuItemClick("Смартфоны, ТВ и электроника")                          // go to phones, TV and electtr.
                .subMenuItemClick("Телефоны")                                              // go to Phones
                .subMenuItemClick("Смартфоны");                                            // go to SmartPhones

        page.searchForTopSells();                                                          // top sells from 1st page

        int page1TopSalesCount = page.countOfTopSalesPerPage();
       // System.out.println("Page1: " + page1TopSalesCount);  // for debug

        ResultPage page2 = page.goToPage(2);
        page2.searchForTopSells();                                                         // top sells from 2nd page
        int page2TopSalesCount = page2.countOfTopSalesPerPage();
       // System.out.println("Page2: " + page2TopSalesCount); // for debug

        ResultPage page3 = page2.goToPage(3);                                              // top sells from 3d page
        page3.searchForTopSells();
        int page3TopSalesCount = page3.countOfTopSalesPerPage();
       // System.out.println("Page3: " + page3TopSalesCount); for debug

        Assert.assertTrue(page1TopSalesCount<=3 && page2TopSalesCount<=3 && page3TopSalesCount <=3);  // not more 3 per page



       // ResultPage page12 = page3.goToPage(12);

    }
}