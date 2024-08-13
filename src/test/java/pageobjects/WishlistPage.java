package pageobjects;

import helpers.Browser;
import org.openqa.selenium.By;

public class WishlistPage extends pageobjects.BasePage {

    private By productItems = By.ByCssSelector(".wishlist-items-wrapper tr td.product-remove");

    protected WishlistPage(Browser browser) {
        super(browser);
    }

    public int getNumberOfProducts(){
        return driver.findElement(productItems).size();
    }
}
