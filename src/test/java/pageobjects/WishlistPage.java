package pageobjects;

import helpers.Browser;


public class WishlistPage extends pageobjects.BasePage {

    //WebElements  productItems = By.ByCssSelector(".wishlist-items-wrapper tr td.product-remove");

    protected WishlistPage(Browser browser) {
        super(browser);
    }

//    public int getNumberOfProducts(){
//        return productItems.size();
//    }
}
