/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author rjany
 */

public class Tests_3PopulatedLibrary {
    private static AndroidDriver driver;
    
    public Tests_3PopulatedLibrary() {
    }
    
    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","HTC R");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(10000);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    
    /* TODO
        Reader functionality
        Audioplayer functionality
        Download book
        Download audiobook
        Add book to collection (existing
        Add book to collection (create
        Delete collection
        Search collection with results
        Search collection without results
        Cancel download
        
    */
    
    
}
