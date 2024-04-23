import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTests {
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
    public void chceck_placeholder_is_visible(){
        driver.get("http://localhost:8080/");
        WebElement searchinput =  driver.findElement(By.id("wc-block-search__input-1"));
        Assertions.assertEquals("Search products…", searchinput.getDomAttribute("placeholderd"),
                "Placeholder is diffrent than expected");

    }

}
