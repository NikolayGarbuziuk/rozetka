package uaComRozetkaTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ПК on 05.06.2017.
 */
public class ResultPage extends BasePage{

        public ResultPage(WebDriver driver) {
            super(driver);
        }
    public   ResultPage subMenuItemClick(String itemName) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//ul//a[.='"+ itemName + "']")).click();
        return new ResultPage(driver);

    }

    public List listOfTopSalesProducts(){

             List< WebElement> topList = driver.findElements(By.xpath(".//div[@name='goods_list']//i[@class='g-tag g-tag-icon-middle-popularity sprite']/../../.."));
             for (WebElement l: topList) {
                 System.out.println( l.getLocation());

             }
        return topList;

    }

}
