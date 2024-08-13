import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseTests {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final String baseUrl  ="http://localhost:8080" ;
    @BeforeEach
    public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless-new");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    @AfterEach
    public void quitDriver(){driver.quit();}
}