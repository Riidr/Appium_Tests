
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
public class Discover {
    private static int bookNo = 0;
    
    public void discoverGetSample (AndroidDriver driver) throws Exception{
        //Instanciating classes
        BookDetails detail = new BookDetails();
        //Tap book in list
        List<WebElement> bookList = driver.findElements(By.id("book_view"));
        bookList.get(bookNo).click();
        Thread.sleep(500);
        WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("sample_button")));
        detail.getSample(driver);
        bookNo++;
    }
    
    public void addWishlist (AndroidDriver driver) throws Exception{
        //Instanciating classes
        BookDetails detail = new BookDetails();
        //Tap book in list
        List<WebElement> bookList = driver.findElements(By.id("book_view"));
        bookList.get(bookNo).click();
        Thread.sleep(500);
        WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("sample_button")));
    }
    
}
