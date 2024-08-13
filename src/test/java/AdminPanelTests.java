import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPanelTests extends BaseTests{

    @BeforeEach
    public void adminLogin(){
        driver.get(baseUrl +"/my-account/");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
    @Test
    @DisplayName("Admin_success_login_should_display_my_account_content")
    public void loginTest() {

        driver.findElement(By.className("woocommerce-MyAccount-content"));
        Assertions.assertDoesNotThrow(() -> driver.findElement(By.className("woocommerce-MyAccount-content")), "Contain is missing");
    }
    @Test
    public void product_virtual_should_not_show_shiping() {

        driver.get(baseUrl + "/wp-admin/post-new.php?post_type=product");
        driver.findElement(By.id("_virtual")).click();
        WebElement shippingTab = driver.findElement(By.className("shipping_tab"));
        Assertions.assertFalse(shippingTab.isDisplayed(),"Shipping tab should't be displayed");


    }

    @Test

    public void select_all_products_should_select_each_of_them(){

        driver.get(baseUrl + "/wp-admin/edit.php?post_type=product");
        driver.findElement(By.id("cb-select-all-1")).click();
        List<WebElement> productChecboxes = driver.findElements(By.name("post[]"));

        long numberOfSelectedChecboxes =  productChecboxes.stream()
                .filter(WebElement::isSelected).count();
        Assertions.assertEquals(7,numberOfSelectedChecboxes, "Number of selected checkboxes uncorrect");

    }
}
