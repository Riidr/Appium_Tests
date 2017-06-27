/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import io.appium.java_client.android.AndroidDriver;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author rjany
 */
public class LogIn {
    
    public LogIn() {  
    }
    public void logIn(AndroidDriver driver, String user)throws Exception{
        try {
            WebElement element;
            //Input of email address
            element = driver.findElement(By.id("username"));
            element.sendKeys("rj+"+user+"@pubfront.com");
            //Input of password
            element = driver.findElement(By.id("password"));
            element.sendKeys("password123");
            //Press Log In button
            WebElement button = driver.findElement(By.id("Login_btn"));
            button.click();
            //Wait and check if user name is loaded
            WebElement username = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("library_header_user_name")));
            
        } catch (Exception e) {
            System.out.println("ERROR: Could not log in.");
            System.out.println(e.getMessage());
        }
    }
    
    public void logOut(AndroidDriver driver)throws Exception{
        try{
            //Press Sign Out Button
            WebElement element = driver.findElement(By.id("sign_out_button"));
            element.click();
            
        } catch (Exception e) {
            System.out.println("ERROR: Could not log out.");
            System.out.println(e.getMessage());
        }
    }
}
