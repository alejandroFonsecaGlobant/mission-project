package com.globant.automation.web.pages.checkout;

import com.globant.automation.web.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutOverviewPage extends BasePage {

  @FindBy(id = "finish")
  private WebElement btnFinish;
}
