package com.globant.automation.web.tests; /**
 * package com.globant.automation.web.tests;
 * <p>
 * import com.globant.automation.web.pages.checkout.CheckoutCompletePage;
 * import com.globant.automation.web.pages.shopping.ProductsPage;
 * import io.qameta.allure.Description;
 * import io.qameta.allure.Story;
 * import org.testng.annotations.Test;
 *
 * @Story("Purchase") public class PurchaseTests extends BaseTest {
 * @Description("Purchases the cheapest item in store by complete checkout")
 * @Test public void purchaseCheapestItem() {
 * ProductsPage productsPage =
 * loginPage.loginWithCredentials("standard_user","secret_sauce");
 * productsPage.addProductByName("Sauce Labs Onesie");
 * softAssert.assertEquals(
 * Integer.parseInt(productsPage.getLblShoppingCartBadge().getText()), 1);
 * CheckoutCompletePage checkoutCompletePage =
 * productsPage.goToYourCartPage()
 * .goToCheckoutPage()
 * .fillCheckoutInformationAndContinue("Alejandro", "Fonseca", "90001")
 * .finishPurchase();
 * softAssert.assertTrue(checkoutCompletePage.getImgCheckmark().isDisplayed(),
 * "Checkmark image is displayed");
 * softAssert.assertTrue(checkoutCompletePage.getLblCompleteHeader().isDisplayed(),
 * "Complete checkout title is displayed");
 * softAssert.assertTrue(checkoutCompletePage.getLblCompleteDescription().isDisplayed(),
 * "Complete checkout description is displayed");
 * }
 * }
 */
