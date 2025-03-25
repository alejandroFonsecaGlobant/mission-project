package com.globant.automation.web.tasks.checkout;

import com.globant.automation.web.pages.checkout.CheckoutPersonalDetailsPage;

public class CheckoutPersonalDetailsPageTask extends CheckoutPersonalDetailsPage {

  public CheckoutOverviewPageTask fillCheckoutInformation(String firstName,
                                                                     String lastName, String postalCode) {
    getTxtFirstName().sendKeys(firstName);
    getTxtLastName().sendKeys(lastName);
    getTxtLastName().sendKeys(postalCode);
    return new CheckoutOverviewPageTask();
  }

  public void goToCheckoutOverviewPage() {
    getBtnContinue().click();
  }
}
