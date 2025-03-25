package com.globant.automation.web.stepsdefinitions;

import com.globant.automation.web.questions.LoginPageQuestion;
import com.globant.automation.web.questions.shopping.ProductsPageQuestion;
import com.globant.automation.web.tasks.LoginPageTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition {
  private final LoginPageTask loginPageTask =  new LoginPageTask();
  private final ProductsPageQuestion productsPageQuestion = new ProductsPageQuestion();
  private final LoginPageQuestion loginPageQuestion = new LoginPageQuestion();

  @When("^I perform login with (.*) credentials$")
  public void performLoginWithCredentials(String username) {
    loginPageTask.loginWithCredentials(username, "secret_sauce");
  }

  @Then("^I verify the login status for (.*) account$")
  public void verifyLoginStatusForAccount(String status) {
    if (status.equals("valid")) {
      productsPageQuestion.verifyPageIsDisplayed();
    } else if (status.equals("invalid"))
      loginPageQuestion.verifyLoginErrorLabelIsDisplayed();
  }
}
