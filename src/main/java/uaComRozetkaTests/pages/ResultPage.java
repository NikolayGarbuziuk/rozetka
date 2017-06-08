package uaComRozetkaTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ПК on 05.06.2017.
 */
public class ResultPage extends BasePage{

    public static final By listName = By.xpath(".//div[@class='g-i-tile-i-title clearfix']/a");
    public static final By listPrice = By.xpath(".//div[@class='g-price-uah']");
    public static final By topList = By.xpath(".//div[@name='goods_list']//i[@class='g-tag g-tag-icon-middle-popularity sprite']/../../..");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    //sub menu navigation
    public   ResultPage subMenuItemClick(String itemName) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 20000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//ul//a[.='"+ itemName + "']")));
        driver.findElement(By.xpath(".//ul//a[.='"+ itemName + "']")).click();
        return new ResultPage(driver);
    }
    //result pages navigation
    public ResultPage goToPage(int pageNumber) throws InterruptedException
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 20000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='page" +pageNumber+ "']")));
        driver.findElement(By.xpath(".//*[@id='page" +pageNumber+ "']")).click();
        wait.until(ExpectedConditions.urlContains("page="+pageNumber));
        return new ResultPage(driver);
    }
    // count of top sales - deprecated
    //public int countOfTopSalesPerPage() {
      //  return driver.findElements(topList).size();
  //  }


    //-------------------------------------------------------
    // top sales list
    public List<TopSells> searchForTopSells()  throws Exception {
        List<TopSells> result = new ArrayList<>();
        for(WebElement e : driver.findElements(topList)){
            result.add(new TopSells(e));
        }
        writteToLogAndConsole(result);
        return  result;
    }
// print name and price
    public void writteToLogAndConsole(List<TopSells> list){
        for (TopSells ts : list){
            System.out.println(ts.getName() + ", " +ts.getPrice());
            Log.info(ts.getName() + ", " +ts.getPrice());
        }
    }

    //product
    class TopSells {
        private String name;
        private String price;

        TopSells(WebElement element){
            this.name = element.findElement(listName).getText();
            this.price = element.findElement(listPrice).getText();;
        }

        public String getName() {
            return name;
        }

        public String getPrice(){
            return price;
        }
    }
}
