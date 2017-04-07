
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        Thread.sleep(10000);
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
        Thread.sleep(500);
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
        //Get current amount of visible items on screen (books/audiobooks)
        List<WebElement> list = driver.findElements(By.id("library_book_author"));
        //Open Discover
        lsm.openDiscover(driver, aut);
        //Get sample of item shown
        discover.discoverGetSample(driver, aut);
        //Check if amount of visible items has increased by 1
        assertTrue(driver.findElements(By.id("library_book_author")).size()==list.size()+1);
        
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
        Thread.sleep(300);
        //Check if collection is still present (should not be)
        assertFalse(library.isCollectionPresent(driver, COLLECTION));
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
        //Press Star
        element = driver.findElement(By.id("wish_menu"));
        element.click();
        //Press return button and navigate back to library
        if (aut == "Politiken") {
            WebElement element3 = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/"
                    + "android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/"
                    + "android.widget.FrameLayout[1]/android.view.ViewGroup[1]/"
                    + "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
                    + "android.view.ViewGroup[1]/android.widget.ImageButton[1]"));
            element3.click();
        } else if (aut == "Ebok") {
            WebElement element3 = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/"
                    + "android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/"
                    + "android.widget.FrameLayout[1]/android.view.ViewGroup[1]/"
                    + "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
                    + "android.view.ViewGroup[1]/android.widget.ImageButton[1]"));
            element3.click();
        }
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
        //Delete book
        element = driver.findElement(By.id("book_options_delete_from_collection"));
        element.click();
        Thread.sleep(400);
        //Verify book is not in collection anymore
        assertFalse(searchList(driver.findElements(By.id("library_book_author")), AUTHOR));
        if (aut == "Politiken") {
            driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
                    "android.view.ViewGroup[1]/android.widget.LinearLayout[1]/" +
                    "android.widget.LinearLayout[1]/android.view.ViewGroup[1]/" +
                    "android.widget.ImageButton[1]")).click();
        } else if (aut == "Ebok"){
            driver.findElement(By.xpath("//android.widget.LinearLayout[1]/"
                    + "android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/"
                    + "android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/"
                    + "android.widget.LinearLayout[1]/android.view.ViewGroup[1]/"
                    + "android.widget.ImageButton[1]")).click();
        }
    }
    
    
    /*TODO 
        Tests of filter in search
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
