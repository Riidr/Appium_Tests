
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
    
    public void InvalidMail(WebDriver driver, String aut)throws Exception{
        try {
            //Open sign up form
            if (aut == "Politiken") {
                WebElement newUser = driver.findElement(By.id("notSignedUpTv"));
                newUser.click();
                //enter email and password and username
                WebElement fname = driver.findElement(By.id("first_name"));
                fname.sendKeys("Test1");
                WebElement lname = driver.findElement(By.id("last_name"));
                lname.sendKeys("Test2");
                WebElement eMail = driver.findElement(By.id("email"));
                eMail.sendKeys("rjpubfrontcom");
                WebElement password = driver.findElement(By.id("password"));
                password.sendKeys("password");
                WebElement check = driver.findElement(By.id("terms_and_conditionsCheck"));
                check.click();
                //Press button to sign up
                WebElement register = driver.findElement(By.id("SignUp_btn"));
                register.click();
                driver.navigate().back();
                driver.wait(300);
                driver.navigate().back();
                WebElement username = (new WebDriverWait(driver, 60))
                        .until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            } else if (aut == "Ebok"){
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
            }
        } catch (Exception e) {
            System.out.println("ERROR: InvalidMail Test failed.");
            System.out.println(e.getMessage());
            driver.navigate().back();
        }
    }
    
    public void  MailInUse(WebDriver driver, String aut)throws Exception{
        try {
            if (aut == "Politiken") {
                System.out.println("Starting InvalidMail test...");
                WebElement present;
                WebElement newUser = driver.findElement(By.id("notSignedUpTv"));
                newUser.click();
                //Type in user data
                WebElement fname = driver.findElement(By.id("first_name"));
                fname.sendKeys("Test1");
                WebElement lname = driver.findElement(By.id("last_name"));
                lname.sendKeys("Test2");
                WebElement eMail = driver.findElement(By.id("username"));
                eMail.sendKeys("rj@pubfront.com");
                WebElement password = driver.findElement(By.id("password"));
                password.sendKeys("password");
                WebElement check = driver.findElement(By.id("terms_and_conditionsCheck"));
                check.click();
                WebElement register = driver.findElement(By.id("SignUp_btn"));
                register.click();
                driver.navigate().back();
                driver.wait(300);
                driver.navigate().back();
                WebElement username = (new WebDriverWait(driver, 60))
                        .until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            } else if (aut == "Ebok"){
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
            }
        } catch (Exception e) {
            System.out.println("ERROR: InvalidMail Test failed.");
            System.out.println(e.getMessage());
            driver.navigate().back();
            Thread.sleep(500);
            driver.navigate().back();
        }
    }
}
