
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import jdk.nashorn.internal.runtime.ECMAErrors;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Robert
 */
public class Tests_2EmptyAccount {
    private static AndroidDriver driver;
    public String aut = "Politiken"; //Politken, Ebok, Pubfront
    @Before
    public void setUp() throws Exception { //Device might vary


        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName","HTC R");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebElement check = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("appbar")));
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    

    //@Ignore
    @Test
    /*
    This test checks whether the app reacts correct if there is no results
    for a search
    */
    public void searchNoResult() throws InterruptedException {
        //Instanciating classes
        LeftSideMenu lsm = new LeftSideMenu();
        Search search = new Search();
        //Opens search
        lsm.openSearch(driver, aut);
        //Searches for a term that won't return a result
        search.searchNoResult(driver, "uygieoaghuoiegboifu");
        WebElement check = (new WebDriverWait(driver, 60))
               .until(ExpectedConditions.presenceOfElementLocated(By.id("no_filter_result_message")));
        //Check if the text for no results is shown
        assertTrue(driver.findElement(By.id("no_filter_result_message")).isDisplayed());
    }

    //@Ignore
    @Test
    /*
    This test checks whether a sample can be added from the discover section
    */
    public void discoverGetSample() throws InterruptedException, Exception { //Req. first item in discover to have sample
        //Instanciating classes
        LeftSideMenu lsm = new LeftSideMenu();
        Discover discover = new Discover();
        Gesture gesture = new Gesture();
        //Get current amount of visible items on screen (books/audiobooks)
        List<WebElement> list = driver.findElements(By.id("library_book_author"));
        //Open Discover
        lsm.openDiscover(driver, aut);
        //Get sample of item shown
        discover.discoverGetSample(driver, aut);
        //Check if amount of visible items has increased by 1
        assertTrue(driver.findElements(By.id("library_book_author")).size()==list.size()+1);
        //Delete the book from account
        list = driver.findElements(By.id("library_book_author"));
        gesture.longPressItem(driver, list.get(0));
        WebElement element = driver.findElement(By.id("book_options_delete_from_account"));
        element.click();
        Thread.sleep(300);
        driver.findElement(By.id("button_yes")).click();
    }
    //@Ignore
    @Test
    /*
    This test checks whether a collection can be created and then deleted
    */
    public void deleteCollection() throws Exception {
        //Decleration of variables
        String COLLECTION = "DeleteAuto";
        //Instanciating classes
        Library library = new Library();
        //Create collection which will be deleted
        library.createCollection(driver, COLLECTION);
        //Check if collection is created
        assertTrue(library.isCollectionPresent(driver, COLLECTION)); 
        //Delete the collection
        library.deleteCollection(driver, COLLECTION);
        Integer c = 0;
        if(library.isCollectionPresent(driver,COLLECTION) == true && c < 5){
            Thread.sleep(300);
            c++;
        }
        //Check if collection is still present (should not be)
        assertFalse(library.isCollectionPresent(driver, COLLECTION));
    }

    @Test
    /*
    This test checks whether the search in filter for collections work
     */
    public void filterCollection() throws Exception {
        //Decleration of variables
        String BOOK = null;
        String AUTHOR = null;
        String COLLECTION = null;
        if (Objects.equals(aut, "Politiken")) {
            BOOK = "Camilla and the Horse";
            AUTHOR = "Christina";
            COLLECTION = "Filter";
        } else if (Objects.equals(aut, "Ebok")){
            BOOK = "Det hun visste";
            AUTHOR = "Lydia";
            COLLECTION = "Filter";
        }
        //Instanciate classes
        LeftSideMenu lsm = new LeftSideMenu();
        Search search = new Search();
        BookDetails details = new BookDetails();
        Gesture gesture = new Gesture();
        Library library = new Library();
        //Open Search
        lsm.openSearch(driver, aut);
        //Search for book and add sample
        search.searchBook(driver, BOOK, 0);
        //Get sample
        details.getSample(driver, aut);
        //Verification that item is in library!
        List<WebElement> list = driver.findElements(By.id("library_book_author"));
        assertTrue(searchList(list, AUTHOR));
        //Create collection which will be deleted
        library.createCollection(driver, COLLECTION);
        //Check if collection is created
        assertTrue(library.isCollectionPresent(driver, COLLECTION));
        //Longpress the book
        WebElement item = searchItem(list,AUTHOR);
        gesture.longPressItem(driver, item);
        //Add to collection
        WebElement element = driver.findElement(By.id("book_options_add_to_collection"));
        element.click();
        Thread.sleep(300);
        list = driver.findElements(By.id("title"));
        //Change to unique object to click on...
        list.get(2).click();
        Thread.sleep(1000);
        //Open collection
        library.openCollection(driver, COLLECTION); //Requires the wishlist to be named like that
        //Check if book is in the collection
        assertTrue(searchList(driver.findElements(By.id("library_book_author")), AUTHOR));
        //Swipe right side menu open --error here
        gesture.swipeLeft(driver);
        //Search for non-existing item
        element = driver.findElement(By.id("searchField"));
        element.sendKeys("ugwiheauif");
        //Verify no results are shown
        assertTrue(driver.findElement(By.id("no_filter_result_message")).isDisplayed());
        //Search for existing item
        element.clear();
        element.sendKeys(AUTHOR);
        //Verify item is shown
        driver.navigate().back();
        Thread.sleep(300);
        driver.navigate().back();
        assertTrue(searchList(driver.findElements(By.id("library_book_author")), AUTHOR));
        //Return to library
        Thread.sleep(300);
        driver.navigate().back();
        //Delete the book from account --error here
        list = driver.findElements(By.id("library_book_author"));
        gesture.longPressItem(driver, list.get(0));
        element = driver.findElement(By.id("book_options_delete_from_account"));
        element.click();
        Thread.sleep(300);
        driver.findElement(By.id("button_yes")).click();
        //Delete the collection
        library.deleteCollection(driver, COLLECTION);
        Integer c = 0;
        if(library.isCollectionPresent(driver,COLLECTION) == true && c < 5){
            Thread.sleep(300);
            c++;
        }
    }

    //@Ignore
    @Test
    /*
    This test checks whether an item can be added to the wishlist using the star
    and also if the item can be removed again using the star
    */
    public void wishlist() throws Exception { //Need to change book
        //Declare variables depending on AUT
        String BOOKNAME = null;
        String AUTHOR = null;
        String WISHLIST = null;

        if (aut == "Politiken") {
            BOOKNAME = "Maj";
            AUTHOR = "Viveca";
            WISHLIST = "Ønskeliste";
        } else if (aut =="Ebok"){
            BOOKNAME = "Mammasjokket";
            AUTHOR = "Helena";
            WISHLIST = "Ønskeliste";
        }

        //Instanciate classes
        LeftSideMenu lsm = new LeftSideMenu();
        Search search = new Search();
        BookDetails details = new BookDetails();
        Library library = new Library();
        Gesture gesture = new Gesture();
        //Open Search
        lsm.openSearch(driver, aut);
        //Search for book
        search.searchBook(driver, BOOKNAME, 0);
        //Add to wishlist
        details.addWishlist(driver, aut);
        Thread.sleep(1000); //Time for sync
        //Open collection
        library.openCollection(driver, WISHLIST); //Requires the wishlist to be named like that
        //Check if book is in the collection
        assertTrue(searchList(driver.findElements(By.id("library_book_author")), AUTHOR));
        //Remove book from collection via book details
        List<WebElement> list = driver.findElements(By.id("library_book_author"));
        WebElement item = searchItem(list,AUTHOR);
        gesture.longPressItem(driver, item);
        WebElement element = driver.findElement(By.id("book_options_see_book_details"));
        element.click();
        Thread.sleep(1000);
        //Press Star
        element = driver.findElement(By.id("wish_menu"));
        element.click();
        //Press return button and navigate back to library
        driver.navigate().back();
        Thread.sleep(2000); //Time for sync
        assertFalse(searchList(driver.findElements(By.id("library_book_author")), AUTHOR));
        
    }

    //@Ignore
    @Test
    /*
    This test adds a sample to the library (from search). The sample will be 
    added to a new collection using the longpress menu of the book. 
    Then the book will be removed from the collection.
    */
    public void removeFromNewCollection() throws Exception{
        String BOOK = null;
        String AUTHOR = null;
        String COLLECTION = null;

        if (aut == "Politiken") {
            BOOK = "Camilla and the Horse";
            AUTHOR = "Christina";
            COLLECTION = "Longpress";
        } else if (aut =="Ebok"){
            BOOK = "Det hun visste";
            AUTHOR = "Lydia";
            COLLECTION = "Longpress";
        }
        //Instanciate classes
        LeftSideMenu lsm = new LeftSideMenu();
        Search search = new Search();
        BookDetails details = new BookDetails();
        Gesture gesture = new Gesture();
        Library library = new Library();
        //Open Search
        lsm.openSearch(driver, aut);
        //Search for book and add sample
        search.searchBook(driver, BOOK, 0);
        //Get sample
        details.getSample(driver, aut);
        //Verification that item is in library!
        List<WebElement> list = driver.findElements(By.id("library_book_author"));
        assertTrue(searchList(list, AUTHOR));
        //Longpress the book
        WebElement item = searchItem(list,AUTHOR);
        gesture.longPressItem(driver, item);
        //Create collection
        WebElement element = driver.findElement(By.id("book_options_add_to_collection"));
        element.click();
        Thread.sleep(300);
        list = driver.findElements(By.id("title"));
        list.get(0).click();
        Thread.sleep(300);
        element = driver.findElement(By.id("new_collection_edittext"));
        element.sendKeys(COLLECTION);
        element = driver.findElement(By.id("button_yes"));
        element.click();
        //Open collection
        library.openCollection(driver, COLLECTION);
        //Longpress the book
        list = driver.findElements(By.id("library_book_author"));
        item = searchItem(list,AUTHOR);
        gesture.longPressItem(driver, item);
        Thread.sleep(500);
        //Delete book
        element = driver.findElement(By.id("book_options_delete_from_collection"));
        element.click();
        Thread.sleep(400);
        //Verify book is not in collection anymore
        assertFalse(searchList(driver.findElements(By.id("library_book_author")), AUTHOR));
        //Return to library
        driver.navigate().back();
        Thread.sleep(300);
        //Delete the book from account
        list = driver.findElements(By.id("library_book_author"));
        item = searchItem(list,AUTHOR);
        gesture.longPressItem(driver, item);
        element = driver.findElement(By.id("book_options_delete_from_account"));
        element.click();
        Thread.sleep(300);
        driver.findElement(By.id("button_yes")).click();
        //Delete the collection
        library.deleteCollection(driver, COLLECTION);
    }

    /*TODO 

        Get Sample ebook
            Download the sample
            Open sample
            Close sample
            Delete locally
            Delete from account
        Get Sample ebook
            Download the sample
            cancel the download
            Delete from account
        Open book after purchase
            Test reader functionalities
            Delete book
        Open audiobook after purchase
            Test audio functionalities
    */

    public boolean searchList(List<WebElement> list, String term){
        for (int i = 0; i<list.size();i++){
            if (list.get(i).getText().contains(term)){
                return true;
            }
        }
        return false;
    }
    
    public WebElement searchItem(List<WebElement> list, String term){
        for (int i = 0; i<list.size();i++){
            if (list.get(i).getText().contains(term)){
                return list.get(i);
            }
        }
        return null;
    }
    
    
}
