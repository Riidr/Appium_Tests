
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
 * @author rjany
 */
public class SignUp {
    public SignUp(){
        
    }
    
    public void InvalidMail(WebDriver driver)throws Exception{
        try {
            //Open sign up form
            WebElement newUser = driver.findElement(By.id("notSignedUpTv"));
            newUser.click();
            //enter email and password
            WebElement eMail = driver.findElement(By.id("email"));
            eMail.sendKeys("rjpubfrontcom");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("password");
            //Press button to sign up
            WebElement register = driver.findElement(By.id("SignUp_btn"));
            register.click();
            //Wait until button_yes is present
            WebElement button_yes = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("button_yes")));
            //Press ok, empty fields and navigate back
            button_yes.click();
            eMail.clear();
            password.clear();
            driver.navigate().back();
            Thread.sleep(500);
            driver.navigate().back();
            WebElement username = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        } catch (Exception e) {
            System.out.println("ERROR: InvalidMail Test failed.");
            System.out.println(e.getMessage());
            driver.navigate().back();
        }
    }
    
    public void  MailInUse(WebDriver driver)throws Exception{
        try {
            System.out.println("Starting InvalidMail test...");
            WebElement present;
            WebElement newUser = driver.findElement(By.id("notSignedUpTv"));
            newUser.click();
            WebElement eMail = driver.findElement(By.id("email"));
            eMail.sendKeys("rj@pubfront.com");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("password");
            WebElement register = driver.findElement(By.id("SignUp_btn"));
            register.click();
            WebElement button_yes = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("button_yes")));
            WebElement mailInUse_btn = driver.findElement(By.id("button_yes"));
            mailInUse_btn.click();
            driver.navigate().back();
            Thread.sleep(500);
            driver.navigate().back();
            WebElement username = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        } catch (Exception e) {
            System.out.println("ERROR: InvalidMail Test failed.");
            System.out.println(e.getMessage());
            driver.navigate().back();
            Thread.sleep(500);
            driver.navigate().back();
        }
    }
}
