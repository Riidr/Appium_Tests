
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 * These Tests require the app to start in onboarding (no user is logged in)
 */

public class Tests_1OnBoarding {
    private static AndroidDriver driver;
    public String aut = "Politiken"; //Politken, Ebok, Pubfront
    
    @BeforeClass
    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Test_LG");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(10000);
    }
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Ignore
    @Test
    /*
    This test checks whether the app detects an invalid email input
    in the sign_up process
    */
    public void invalidMail() throws Exception {
        //Instanciating classes
        SignUp signUp = new SignUp();
        //Type in invalid mail and try to sign up
        signUp.InvalidMail(driver, aut);
        assertTrue(driver.findElement(By.id("Login_btn")).isDisplayed());
    }

    @Ignore
    @Test
    /*
    This test checks whether the app recognises an email that is already in use
    */
    public void mailInUse() throws Exception {
        //Instanciating classes
        SignUp signUp = new SignUp();
        //Type in a mail that is already in use
        signUp.MailInUse(driver, aut);
        assertTrue(driver.findElement(By.id("Login_btn")).isDisplayed());
    }

    @Test
    /*
    This test checks whether the user can log in and log out
    */
    public void logInOutTest() throws Exception {
        //Declase variables
        String EXTENSION = "pb4";
        //Instanciating classes
        LogIn logIn = new LogIn();
        LeftSideMenu lsm = new LeftSideMenu();
        //Log In
        logIn.logIn(driver, EXTENSION);
        assertTrue(!driver.findElements(By.id("library_header_user_name")).isEmpty());
        //Log out       
        lsm.openSettings(driver, aut);
        logIn.logOut(driver);
        assertTrue(driver.findElement(By.id("Login_btn")).isDisplayed());
    }
    
}
