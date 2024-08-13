package pageobjects;

import helpers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends pageobjects.BasePage {
    @FindBy(css = "[name=add-to-cart]")
    private WebElement addToCart;
    @FindBy(css = ".woocommerce-message>.button")
    private WebElement goToCart;
    @FindBy(css = "a.add_to_wishlist")
    private WebElement addToWishlist;
    @FindBy(css =".blockUI")
    private WebElement loadingIcon;

    @FindBy(css =".a.add_to_wishlist")
    private WebElement addToWishList;


    public final pageobjects.StoreHeaderComponent storeHeader;

    public ProductPage(Browser browser) {
        super(browser);
        storeHeader = new pageobjects.StoreHeaderComponent(browser);
    }

    public ProductPage go(String productSlug) {
        driver.get(baseURL + "/product/" + productSlug);
        return this;
    }

    public ProductPage addToCart() {
        addToCart.click();
        return this;
    }

    public pageobjects.CartPage goToCart() {
        goToCart.click();
        return new pageobjects.CartPage(browser);
    }

    public ProductPage addToWishlist() {
        addToWishlist.click();
        waitForLoadingIconDisappear();
        return this;
    }

    public Object goToWishlist() {
        driver.findElement((By) addToWishlist).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe((By) loadingIcon,0));
        return this;
    }
}