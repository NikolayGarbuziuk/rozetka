package rozetkaTests;

import org.junit.Test;
import uaComRozetkaTests.pages.BasePage;
import uaComRozetkaTests.pages.HomePage;

/**
 * Created by ПК on 05.06.2017.
 */
public class taskTest extends BaseCase {

    @Test
    public void topProdazh3PerPage() {

        new HomePage(driver).mainMenuItemClick("Смартфоны, ТВ и электроника")   // go to phones, TV and electtr.
                .subMenuItemClick("Телефоны")                                             // go to Phones
                .subMenuItemClick("Смартфоны");                                           // go to SmartPhones


    }
}