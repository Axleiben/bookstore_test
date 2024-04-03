


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Bookstore_test {

    WebDriver driver;

    @BeforeEach
    public void  setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


@Test
    public void add_to_card_should_minicart_show_product_total_price (){
        driver.get("http://localhost:8080/product/a-popular-history-of-astronomy-during-" +
                "the-nineteenth-century-by-agnes-m-clerke/");
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();
        driver.findElement(By.className("wc-block-mini-cart__button")).click();
        WebElement totalPrice = driver.findElement(By.className("wc-block-components-totals-item__value"));
        Assertions.assertEquals("12,00 €",totalPrice.getText(),
                "The price displayed in minicart is not correct");


    }


    public  void addToCardTest (){
        driver.get("http://localhost:8080/product/a-popular-history-of-astronomy-" +
                "during-the-nineteenth-century-by-agnes-m-clerke/");
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();

        WebElement miniCart = driver.findElement(By.className("wc-block-mini-cart__amount"));
        Assertions.assertEquals("14,00 €",miniCart.getText(),
                "The price displayed in header is not correct");
    }


    @DisplayName("Admin_success_login_should_display_my_account_content")
    public void loginTest() {
        driver.get("http://localhost:8080/my-account/");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.className("woocommerce-MyAccount-content"));
        Assertions.assertDoesNotThrow(() -> driver.findElement(By.className("woocommerce-MyAccount-content")),"Contain is missing");
    }


}
