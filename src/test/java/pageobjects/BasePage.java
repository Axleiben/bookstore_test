package pageobjects;

import helpers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    @FindBy(css = ".blockUI")
    private List<WebElement> loadingIcons;

    protected final WebDriver driver;
    protected final Browser browser;
    protected final String baseURL;
    protected BasePage(Browser browser) {
        this.browser = browser;
        this.driver = browser.driver;
        baseURL = browser.baseURL;
        PageFactory.initElements(driver, this);
    }

    protected void waitForLoadingIconDisappear() {
        browser.wait.until(driver -> loadingIcons.size()==0);
    }

    protected void waitForLoadingToEnd(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe((By) loadingIcons,0));
    }
}