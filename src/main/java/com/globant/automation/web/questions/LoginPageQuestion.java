package com.globant.automation.web.questions;

import static com.globant.automation.assertions.SoftAssertManager.getSoftAssert;

import com.globant.automation.web.pages.LoginPage;

public class LoginPageQuestion extends LoginPage {

  public void verifyLoginErrorLabelIsDisplayed() {
    getSoftAssert().assertTrue(getLabelError().isDisplayed(),
      "Login message error is displayed");
  }
}
