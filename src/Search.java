
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**  
 *
 * @author max
 */
public class Search {
    public void searchBook (AndroidDriver driver, String term, Integer bookNo) throws InterruptedException {
        //Instanciating classes
        BookDetails detail = new BookDetails();
        //
        driver.findElement(By.id("search_button")).click();
        Thread.sleep(300);
        WebElement search = driver.findElement(By.id("search_src_text"));
        search.sendKeys(term);
        driver.pressKeyCode(66);
        WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("book_view")));
        List<WebElement> bookList = driver.findElements(By.id("book_view"));
        bookList.get(bookNo).click();
        WebElement check2 = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("sample_button")));       
    }
    
    public void searchNoResult(AndroidDriver driver, String term) throws InterruptedException{
        WebElement search_btn = driver.findElement(By.id("search_button"));
        search_btn.click();
        Thread.sleep(300);
        WebElement search = driver.findElement(By.id("search_src_text"));
        search.sendKeys(term);
        driver.pressKeyCode(66);
    }
}
