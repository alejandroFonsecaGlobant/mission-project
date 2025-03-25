package com.globant.automation.web.pages.shopping;

import com.globant.automation.web.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class YourCartPage extends BasePage {

  @FindBy(id = "checkout")
  private WebElement btnCheckout;
}
