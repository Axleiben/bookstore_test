import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPanelTests {
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
    @DisplayName("Admin_success_login_should_display_my_account_content")
    public void loginTest() {
        driver.get("http://localhost:8080/my-account/");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.className("woocommerce-MyAccount-content"));
        Assertions.assertDoesNotThrow(() -> driver.findElement(By.className("woocommerce-MyAccount-content")), "Contain is missing");
    }
    @Test
    public void product_virtual_should_not_show_shiping() {
        driver.get("http://localhost:8080/my-account/");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost:8080/wp-admin/post-new.php?post_type=product");
        driver.findElement(By.id("_virtual")).click();
        WebElement shippingTab = driver.findElement(By.className("shipping_tab"));
        Assertions.assertFalse(shippingTab.isDisplayed(),"Shipping tab should't be displayed");


    }

    @Test

    public void select_all_products_should_select_each_of_them(){
        driver.get("http://localhost:8080/my-account/");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost:8080/wp-admin/edit.php?post_type=product");
        driver.findElement(By.id("cb-select-all-1")).click();
        List<WebElement> productChecboxes = driver.findElements(By.name("post[]"));

        long numberOfSelectedChecboxes =  productChecboxes.stream()
                .filter(WebElement::isSelected).count();
        Assertions.assertEquals(6,numberOfSelectedChecboxes, "Number of selected checkboxes uncorrect");

    }
}
