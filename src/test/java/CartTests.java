import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    @AfterEach
    public void quitDriver(){driver.quit();}

    @Test
    public void add_to_card_should_minicart_show_product_total_price() {
        driver.get("http://localhost:8080/product/a-popular-history-of-astronomy-during-" +
                "the-nineteenth-century-by-agnes-m-clerke/");
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();
        driver.findElement(By.className("wc-block-mini-cart__button")).click();
        //WebElement totalPrice = driver.findElement(By.className("wc-block-components-totals-item__value"));
        WebElement totalPrice = wait.until(driver ->
                driver.findElement(By.className("wc-block-mini-cart__button")));
        Assertions.assertEquals("12,00 €", totalPrice.getText(),
                "The price displayed in minicart is not correct");


    }

    @Test
    public void addToCardTest() {
        driver.get("http://localhost:8080/product/a-popular-history-of-astronomy-" +
                "during-the-nineteenth-century-by-agnes-m-clerke/");
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();

        WebElement miniCart = driver.findElement(By.className("wc-block-mini-cart__amount"));
        Assertions.assertEquals("14,00 €", miniCart.getText(),
                "The price displayed in header is not correct");
    }
    @Test
    public void update_quantity_in_cart_should_update_total_proice() {
        driver.get("http://localhost:8080/product/a-popular-history-of-astronomy-" +
                "during-the-nineteenth-century-by-agnes-m-clerke/");
        driver.findElement(By.name("add-to-cart")).click();

        driver.get("http://localhost:8080/cart/");
        WebElement quantityFields = driver.findElement(By.className("qty"));
        quantityFields.clear();
        quantityFields.sendKeys("3");
        driver.findElement(By.name("update_cart")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("blockOverlay"), 0));

        WebElement total = driver.findElement(By.className("order-total")).findElement(By.className("amount"));
        Assertions.assertEquals("36,00 €", total.getText(), "Total price is not correct");
        driver.close();
    }

    @Test
    public void cart_not_changed_should_update_button_disbled() {
        driver.get("http://localhost:8080/product/a-popular-history-of-astronomy-" +
                "during-the-nineteenth-century-by-agnes-m-clerke/");
        driver.findElement(By.name("add-to-cart")).click();
        driver.get("http://localhost:8080/cart/");
        WebElement quantityFields = driver.findElement(By.className("qty"));
        quantityFields.clear();
        quantityFields.sendKeys("3");
        WebElement updateButton = driver.findElement(By.name("update_cart"));
        Assertions.assertFalse(updateButton.isEnabled(), "update button is nad enabled ");
    }
    @Test
    public void chceck_placeholder_is_visible(){
        driver.get("http://localhost:8080/");
        WebElement searchinput =  driver.findElement(By.id("wc-block-search__input-1"));
        Assertions.assertEquals("Search products…", searchinput.getDomAttribute("placeholderd"),
                "Placeholder is diffrent than expected");

    }

}
