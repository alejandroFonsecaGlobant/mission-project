package com.globant.automation.web.pages.checkout;

import com.globant.automation.web.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutCompletePage extends BasePage {

  @FindBy(css = "[data-test='pony-express']")
  private WebElement imgCheckmark;

  @FindBy(css = "[data-test='complete-header']")
  private WebElement lblCompleteHeader;

  @FindBy(css = "[data-test='complete-text']")
  private WebElement lblCompleteDescription;
}
