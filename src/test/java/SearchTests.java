import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchTests extends BaseTests {


    @Test
    public void chceck_placeholder_is_visible(){
        driver.get(baseUrl);
        WebElement searchinput =  driver.findElement(By.id("wc-block-search__input-1"));
        Assertions.assertEquals("Search products…", searchinput.getDomAttribute("placeholderd"),
                "Placeholder is diffrent than expected");

    }

}
