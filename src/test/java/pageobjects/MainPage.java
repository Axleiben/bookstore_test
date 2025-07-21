package pageobjects;

import helpers.Browser;

public class MainPage extends pageobjects.BasePage {
    public final pageobjects.StoreHeaderComponent storeHeader;

    public MainPage(Browser browser) {
        super(browser);
        storeHeader = new pageobjects.StoreHeaderComponent(browser);
    }

    public MainPage go() {
        driver.get(baseURL);
        return this;

    }
}