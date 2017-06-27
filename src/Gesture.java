
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
public class Gesture {
    
    public void scrollDownPage(AndroidDriver driver) throws InterruptedException{
        driver.swipe(500, 1720, 500, 100, 300);
        Thread.sleep(400);  
    }
    
    public void swipeRight(AndroidDriver driver) throws InterruptedException{
        driver.swipe(10,424,300,424,600);
        Thread.sleep(400);
    }

    public void swipeLeft(AndroidDriver driver) throws InterruptedException{
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width-1);
        int endx = (int) (size.width*0.5);
        int y = (int) (size.height*0.5);
        driver.swipe(startx,y,endx,y,500);
        Thread.sleep(400);
    }
    
    public void longPressItem(AndroidDriver driver, WebElement item){
        driver.tap(1, item.getLocation().x,item.getLocation().y, 2000);
    }

    public void wait(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(500);
        if(!driver.findElements(By.id("undeterminedProgressBar")).isEmpty())
            Thread.sleep(300);
    }
    
}
