import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartTests extends BaseTests {


    @Test
    public void add_to_card_should_minicart_show_product_total_price() {
        driver.get(baseUrl + "/product/a-popular-history-of-astronomy-during-" +
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
        driver.get(baseUrl + "/product/a-popular-history-of-astronomy-" +
                "during-the-nineteenth-century-by-agnes-m-clerke/");
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();

        WebElement miniCart = driver.findElement(By.className("wc-block-mini-cart__amount"));
        Assertions.assertEquals("14,00 €", miniCart.getText(),
                "The price displayed in header is not correct");
    }
    @Test
    public void update_quantity_in_cart_should_update_total_price() {
        driver.get(baseUrl + "/product/a-popular-history-of-astronomy-" +
                "during-the-nineteenth-century-by-agnes-m-clerke/");
        driver.findElement(By.name("add-to-cart")).click();

        driver.get(baseUrl + "/cart/");
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
        driver.get(baseUrl + "/product/a-popular-history-of-astronomy-" +
                "during-the-nineteenth-century-by-agnes-m-clerke/");
        driver.findElement(By.name("add-to-cart")).click();
        driver.get(baseUrl + "/cart/");
//        WebElement quantityFields = driver.findElement(By.className("qty"));
//        quantityFields.clear();
//        quantityFields.sendKeys("3");

        WebElement updateButton = driver.findElement(By.name("update_cart"));
        Assertions.assertFalse(updateButton.isEnabled(), "update button is nad enabled ");
    }
    @Test
    public void chceck_placeholder_is_visible(){
        driver.get(baseUrl);
        WebElement searchinput =  driver.findElement(By.id("wc-block-search__input-1"));
        Assertions.assertEquals("Search products…", searchinput.getDomAttribute("placeholder"),
                "Placeholder is diffrent than expected");

    }
}