package com.globant.automation.web.pages.checkout;

import com.globant.automation.web.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutPersonalDetailsPage extends BasePage {

  @FindBy(id = "first-name")
  private WebElement txtFirstName;

  @FindBy(id = "last-name")
  private WebElement txtLastName;

  @FindBy(id = "postal-code")
  private WebElement txtPostalCode;

  @FindBy(id = "continue")
  private WebElement btnContinue;
}
