
import io.appium.java_client.android.AndroidDriver;
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
public class BookDetails{
    public void getSample(AndroidDriver driver, String aut){
        //Instanciating classes
        LeftSideMenu lsm = new LeftSideMenu();
        //Click sample button
        WebElement element = driver.findElement(By.id("sample_button"));
        element.click();
        //Check if cancel button in dialog appears
        if (aut == "Politiken") {
            WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                            "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/"
                                    + "android.widget.LinearLayout[1]/"
                                    + "android.widget.FrameLayout[1]/"
                                    + "android.widget.FrameLayout[1]/"
                                    + "android.widget.LinearLayout[1]/"
                                    + "android.widget.RelativeLayout[1]/"
                                    + "android.widget.LinearLayout[1]/"
                                    + "android.widget.Button[2]")));
            //Press cancel button
            WebElement element2 = driver.findElement(By.xpath(
                    "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/"
                            + "android.widget.LinearLayout[1]/"
                            + "android.widget.FrameLayout[1]/"
                            + "android.widget.FrameLayout[1]/"
                            + "android.widget.LinearLayout[1]/"
                            + "android.widget.RelativeLayout[1]/"
                            + "android.widget.LinearLayout[1]/"
                            + "android.widget.Button[2]"));
            element2.click();
        } else if (aut == "Ebok"){
            WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                            "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/"
                                    + "android.widget.LinearLayout[1]/"
                                    + "android.widget.FrameLayout[1]/"
                                    + "android.widget.FrameLayout[1]/"
                                    + "android.widget.LinearLayout[1]/"
                                    + "android.widget.RelativeLayout[1]/"
                                    + "android.widget.LinearLayout[1]/"
                                    + "android.widget.Button[2]")));
            //Press cancel button
            WebElement element2 = driver.findElement(By.xpath(
                    "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/"
                            + "android.widget.LinearLayout[1]/"
                            + "android.widget.FrameLayout[1]/"
                            + "android.widget.FrameLayout[1]/"
                            + "android.widget.LinearLayout[1]/"
                            + "android.widget.RelativeLayout[1]/"
                            + "android.widget.LinearLayout[1]/"
                            + "android.widget.Button[2]"));
            element2.click();
        }
        //Press return button and navigate back to library
        driver.navigate().back();
        lsm.openLibrary(driver, aut);
        WebElement check2 = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(
                            "library_header_user_name")));            
    }
    
    public void addWishlist(AndroidDriver driver, String aut){
        //Instanciating classes
        LeftSideMenu lsm = new LeftSideMenu();
        //Press Star
        WebElement element = driver.findElement(By.id("wish_menu"));
        element.click();
        //Press return button and navigate back to library
        driver.navigate().back();
        lsm.openLibrary(driver, aut);
        WebElement check2 = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(
                            "library_header_user_name"))); 
    }
    
}
