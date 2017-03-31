
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
public class LeftSideMenu {
    public void openLibrary(AndroidDriver driver){
    	try {
            WebElement element = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
                    "android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/" +
                    "android.view.View[1]/android.widget.ImageButton[1]"));
            element.click();
            Thread.sleep(500);
            WebElement library = driver.findElement(By.xpath("//android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]"
                    + "/android.widget.RelativeLayout[1]/android.widget.ListView[1]"
                    + "/android.widget.LinearLayout[1]"));
            library.click();
            WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("appbar")));
    	} catch (Exception e) {
            System.out.println("ERROR: Could not open Library.");
    	}
    }
    
	public void openSearch(AndroidDriver driver){
    	try{
            WebElement element = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
                    "android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/" +
                    "android.view.View[1]/android.widget.ImageButton[1]"));
            element.click();
            Thread.sleep(500);
            WebElement search = driver.findElement(By.xpath("//android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]"
                    + "/android.widget.RelativeLayout[1]/android.widget.ListView[1]"
                    + "/android.widget.LinearLayout[2]"));
            search.click();
            WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("search_autocomplete_textview")));
            
    	}catch (Exception e) {
            System.out.println("ERROR: Could not open Search.");
    	}
    }
    
	public void openDiscover(AndroidDriver driver){
    	try {
            WebElement element = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
                    "android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/" +
                    "android.view.View[1]/android.widget.ImageButton[1]"));
            element.click();
            Thread.sleep(500);
            WebElement discover = driver.findElement(By.xpath("//android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]"
                    + "/android.widget.RelativeLayout[1]/android.widget.ListView[1]"
                    + "/android.widget.LinearLayout[3]"));
            discover.click();
            WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("scrollingBooks")));
    	} catch (Exception e) {
            System.out.println("ERROR: Could not open Discover.");
    	}
    }
    
	public void openCategories(AndroidDriver driver){
    	try{
            WebElement element = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
                    "android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/" +
                    "android.view.View[1]/android.widget.ImageButton[1]"));
            element.click();
            Thread.sleep(500);
            WebElement categories = driver.findElement(By.xpath("//android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]"
                    + "/android.widget.RelativeLayout[1]/android.widget.ListView[1]"
                    + "/android.widget.LinearLayout[4]"));
            categories.click();
            WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("category_image1")));
    	} catch (Exception e) {
            System.out.println("ERROR: Could not open Categories.");
    	}
    }
    
	public void openSettings(AndroidDriver driver){
    	try {
            WebElement element = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
                    "android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/" +
                    "android.view.View[1]/android.widget.ImageButton[1]"));
            element.click();
            Thread.sleep(500);
            WebElement settings = driver.findElement(By.xpath("//android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
                    + "/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]"
                    + "/android.widget.RelativeLayout[1]/android.widget.ListView[1]"
                    + "/android.widget.LinearLayout[5]"));
            settings.click();
            WebElement check = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("sign_out_button")));
    	} catch (Exception e) {
            System.out.println("ERROR: Could not open Settings.");
    	}
    }

    
}
