import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    @AfterEach
    public void quitDriver(){driver.quit();}
}
