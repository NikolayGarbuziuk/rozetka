package uaComRozetkaTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by ПК on 05.06.2017.
 */
public class ResultPage extends BasePage{

        public ResultPage(WebDriver driver) {
            super(driver);
        }

    //sub menu navigation
    public   ResultPage subMenuItemClick(String itemName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//ul//a[.='"+ itemName + "']")).click();
        return new ResultPage(driver);
    }
    //result pages navigation
    public ResultPage goToPage(int pageNumber) throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        driver.findElement(By.xpath(".//*[@id='page" +pageNumber+ "']")).click();

//        WebElement oldHtml = driver.findElement(By.tagName("html"));
//        WebDriverWait wait = new WebDriverWait(driver, 45);
//        wait.until(ExpectedConditions.stalenessOf(oldHtml));

        Thread.sleep(10000);
        return new ResultPage(driver);
    }

    public List listOfTopSalesProducts(){

             List< WebElement> topList = driver.findElements(By.xpath(".//div[@name='goods_list']//i[@class='g-tag g-tag-icon-middle-popularity sprite']/../../.."));
             for (WebElement l: topList) {
                 System.out.println( l.getLocation());

             }
        return topList;

    }
    public int countOfTopSalesPerPage() {

       // driver.navigate().refresh();

//        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
//        wait.until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver wdriver) {
//                return ((JavascriptExecutor) driver).executeScript(
//                        "return document.readyState"
//                ).equals("complete");
//            }
//        });

        List<WebElement> topList = driver.findElements(By.xpath(".//div[@name='goods_list']//i[@class='g-tag g-tag-icon-middle-popularity sprite']/../../.."));
        int count = topList.size();
        return count;
    }

    //-------------------------------------------------------
    public Map<String, String> searchForTopSells()  throws Exception {
        List<WebElement> list_name;
        List<WebElement> list_price;
        Map<String, String> map = new HashMap<String, String>();
        try {
            Thread.sleep(2000);
            list_name = driver.findElements(
                    By.xpath(".//div[@name='goods_list']//i[@class='g-tag g-tag-icon-middle-popularity sprite']/../../../div[@class='g-i-tile-i-title clearfix']/a"));
            list_price = driver.findElements(
                    By.xpath(".//div[@name='goods_list']//i[@class='g-tag g-tag-icon-middle-popularity sprite']/../../..//div[@class='g-price-uah']"));
            // Log.info("There are " + list_desc.size() + " topsells products, and " + list_price.size() + " prices on the " + driver.getCurrentUrl());

            for (int i = 0; i < list_name.size(); i++) {
                map.put(list_name.get(i).getText(), list_price.get(i).getText());
            }
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + ", " + entry.getValue());
                Log.info(entry.getKey() + ", " + entry.getValue());
            }
            return map;

        } catch (Exception e) {
            throw(e);

        }


    }
}
