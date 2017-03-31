
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.util.ArrayList;
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
public class Library {
    
    public void createCollection(AndroidDriver driver, String name) throws Exception {
        WebElement collection_btn = driver.findElement(By.id("add_new_collection"));
        collection_btn.click();
        WebElement dialog = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("new_collection_edittext")));
        WebElement name_et = driver.findElement(By.id("new_collection_edittext"));
        name_et.sendKeys(name);
        collection_btn = driver.findElement(By.id("button_yes"));
        collection_btn.click();
    }
    
    public List<String> getCollectionNames(AndroidDriver driver) throws Exception {
        List<WebElement> elements = driver.findElements(By.id("collection_name"));
        List<String> collections = new ArrayList();
        for (int i = 0; i<elements.size();i++)
            collections.add(elements.get(i).getText());
        return collections;
    }
    
    public boolean isCollectionPresent(AndroidDriver driver, String name) throws Exception {
        //Instanciating classes
        Gesture gesture = new Gesture();
        //
        gesture.scrollDownPage(driver);
        List<String> collections = getCollectionNames(driver);
        for (int i = 0; i<collections.size(); i++) {
            if (collections.get(i).contains(name)){
                return true;
            }
        }
        return false;
    }
    
    public void openCollection(AndroidDriver driver, String collection) throws Exception {
        //Instanciating classes
        Gesture gesture = new Gesture();
        //
        gesture.scrollDownPage(driver);
        List<String> collections = getCollectionNames(driver);
        for (int i = 0; i<collections.size(); i++) {
            if (collections.get(i).contains(collection)){
                driver.tap(1, (WebElement) driver.findElements(By.id("collection_name")).get(i), 100);
                WebElement container = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("collectionRecyclerView")));
                Thread.sleep(300);
                return;
            }
        }
    }
    
    public void deleteCollection(AndroidDriver driver, String collection) throws Exception {
        if (isCollectionPresent(driver, collection) == true){
            List<WebElement> elements = driver.findElements(By.id("collection_name"));
            for (int i = 0; i<elements.size();i++)
                if (elements.get(i).getText().contains(collection)){
                    driver.tap(1, elements.get(i).getLocation().x,
                            elements.get(i).getLocation().y, 1000);
                    WebElement collection_btn = driver.findElement(By.id("colection_options_delete"));
                    collection_btn.click();
                    Thread.sleep(300);
                    WebElement dialog_btn = driver.findElement(By.id("button_yes"));
                    dialog_btn.click();
                    return;
                }
        }
            
    }
    
}
