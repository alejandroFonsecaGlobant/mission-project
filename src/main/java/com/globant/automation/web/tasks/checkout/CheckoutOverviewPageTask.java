package com.globant.automation.web.tasks.checkout;

import com.globant.automation.web.pages.checkout.CheckoutOverviewPage;

public class CheckoutOverviewPageTask extends CheckoutOverviewPage {

  public void finishPurchase() {
    getBtnFinish().click();
  }
}
