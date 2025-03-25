package com.globant.automation.web.pages.shopping;

import com.globant.automation.web.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductsPage extends BasePage {

  @FindBy(css = "[data-test=title]")
  private WebElement lblProductsTitle;

  private static final String PRODUCT_ADD_CART_BUTTON =
    "//div[@data-test='inventory-item-name' and text()='%s']"
      + "/../../following-sibling::div/button[contains(@name,'add-to-cart')]";

  @FindBy(css = "[data-test=shopping-cart-link]")
  private WebElement btnShoppingCart;

  @FindBy(css = "[data-test=shopping-cart-badge]")
  private WebElement lblShoppingCartBadge;

  public static WebElement getProductAddCartButtonByName(String productName) {
    return getDriver().findElement(
      By.xpath(String.format(PRODUCT_ADD_CART_BUTTON, productName)));
  }
}
