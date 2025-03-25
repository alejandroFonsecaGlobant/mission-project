package com.globant.automation.web.questions.checkout;

import static com.globant.automation.assertions.SoftAssertManager.getSoftAssert;

import com.globant.automation.web.pages.checkout.CheckoutCompletePage;

public class CheckoutCompletePageQuestion extends CheckoutCompletePage {

  public void verifyPageIsDisplayed() {
    getSoftAssert().assertTrue(getImgCheckmark().isDisplayed(),
      "Checkmark image is displayed");
    getSoftAssert().assertTrue(getLblCompleteHeader().isDisplayed(),
      "Complete checkout title is displayed");
    getSoftAssert().assertTrue(getLblCompleteDescription().isDisplayed(),
      "Complete checkout description is displayed");
  }
}
