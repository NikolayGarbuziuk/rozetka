package rozetkaTests;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ПК on 05.06.2017.
 */
public class BaseCase {

    static {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver.chrome\\chromedriver.exe");
    }

    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.Jdk14Logger");
       // BasicConfigurator.configure();

        // if (driver == null)
        //    driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://rozetka.com.ua");
    }


    @After
    public void tearDown() {
        driver.close();
    }
}
