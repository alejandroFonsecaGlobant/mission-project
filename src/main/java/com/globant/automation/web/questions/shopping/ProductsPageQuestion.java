package com.globant.automation.web.questions.shopping;

import static com.globant.automation.assertions.SoftAssertManager.getSoftAssert;

import com.globant.automation.web.pages.shopping.ProductsPage;

public class ProductsPageQuestion extends ProductsPage {

  public void verifyPageIsDisplayed() {
    getSoftAssert().assertTrue(getLblProductsTitle().isDisplayed(),
      "Products page is displayed");
  }
}
