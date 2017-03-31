
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

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
    
    public void longPressItem(AndroidDriver driver, WebElement item){
        driver.tap(1, item.getLocation().x,item.getLocation().y, 2000);
    }
    
}
