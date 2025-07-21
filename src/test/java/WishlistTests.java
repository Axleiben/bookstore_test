
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WishlistTests {
    WebDriver driver;

    String calculusSlug = "/calculis-made-easy-by-silvanus-p-thompson/";

    @BeforeEach
    public void setup(){driver = new FirefoxDriver();}

    @AfterEach
    public void quitDriver(){driver.quit();}

    //@Test
//    public void product_added_to_wish_list_should_wishlist_have_one_item(){
//        ProductPage productPage = new ProductPage(driver).go(calculusSlug);
//        WishlistPage wishlistPage =  new WishlistPage();
//    }
}
