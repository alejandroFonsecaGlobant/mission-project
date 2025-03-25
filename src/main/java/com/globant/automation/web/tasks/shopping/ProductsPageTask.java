package com.globant.automation.web.tasks.shopping;

import com.globant.automation.web.pages.shopping.ProductsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ProductsPageTask extends ProductsPage {

  public ProductsPageTask addProductByName(String productName) {
    try {
      WebElement buttonAddCart = getProductAddCartButtonByName(productName);
      if (!buttonAddCart.isDisplayed()) {
        scrollToElement(getDriver(), buttonAddCart);
      }
      buttonAddCart.click();
    } catch (NoSuchElementException e) {
      throw new RuntimeException("Element not found");
    }
    return this;
  }

  public YourCartPageTask goToYourCartPage() {
    getBtnShoppingCart().click();
    return new YourCartPageTask();
  }
}
