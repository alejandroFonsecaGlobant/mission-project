package com.globant.automation.web.stepsdefinitions;

import com.globant.automation.web.questions.checkout.CheckoutCompletePageQuestion;
import com.globant.automation.web.tasks.checkout.CheckoutOverviewPageTask;
import com.globant.automation.web.tasks.checkout.CheckoutPersonalDetailsPageTask;
import com.globant.automation.web.tasks.shopping.ProductsPageTask;
import com.globant.automation.web.tasks.shopping.YourCartPageTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseStepDefinition {

  private final ProductsPageTask productsPageTask = new ProductsPageTask();
  private final YourCartPageTask yourCartPageTask = new YourCartPageTask();
  private final CheckoutPersonalDetailsPageTask checkoutPersonalDetailsPageTask =
    new CheckoutPersonalDetailsPageTask();
  private final CheckoutOverviewPageTask checkoutOverviewPageTask =
    new CheckoutOverviewPageTask();
  private final CheckoutCompletePageQuestion checkoutCompletePageQuestion =
    new CheckoutCompletePageQuestion();


  @And("I add the cheapest item to my shopping cart")
  public void addCheapestItemToCart() {
    productsPageTask.addProductByName("Sauce Labs Onesie");
  }

  @And("I go to my shopping cart")
  public void goToShoppingCart() {
    productsPageTask.goToYourCartPage();
  }

  @And("I verify that the contents in my cart matches my selections")
  public void verifyCartContents() {
    // Implementation here
  }

  @And("I proceed to checkout")
  public void proceedToCheckout() {
    yourCartPageTask.goToCheckoutPage();
  }

  @And("I type in my billing information")
  public void enterBillingInformation() {
    checkoutPersonalDetailsPageTask.fillCheckoutInformation("Alejandro",
      "Fonseca", "12345");
  }

  @And("I continue to the checkout overview page")
  public void continueToCheckoutOverview() {
    checkoutPersonalDetailsPageTask.goToCheckoutOverviewPage();
  }

  @And("I verify that the overview displays my order correctly")
  public void verifyOrderOverview() {
    // Implementation here
  }

  @When("I finish the checkout")
  public void finishCheckout() {
    checkoutOverviewPageTask.finishPurchase();
  }

  @Then("I should see the checkout finish page")
  public void verifyCheckoutFinishPage() {
    checkoutCompletePageQuestion.verifyPageIsDisplayed();
  }
}
