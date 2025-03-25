package com.globant.automation.web.tasks.shopping;

import com.globant.automation.web.pages.shopping.YourCartPage;
import com.globant.automation.web.tasks.checkout.CheckoutPersonalDetailsPageTask;

public class YourCartPageTask extends YourCartPage {

  public CheckoutPersonalDetailsPageTask goToCheckoutPage() {
    getBtnCheckout().click();
    return new CheckoutPersonalDetailsPageTask();
  }
}
