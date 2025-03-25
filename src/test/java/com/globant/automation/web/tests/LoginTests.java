package com.globant.automation.web.tests; /**
 * package com.globant.automation.web.tests;
 * <p>
 * import com.globant.automation.web.pages.shopping.ProductsPage;
 * import com.globant.automation.utils.JsonDataProvider;
 * import io.qameta.allure.Allure;
 * import io.qameta.allure.Description;
 * import io.qameta.allure.Feature;
 * import io.qameta.allure.Story;
 * import org.testng.annotations.Test;
 * import org.testng.Assert;
 *
 * @Feature("Login")
 * @Story("Saucedemo") public class LoginTests extends BaseTest {
 * @Description("Verifies positive and negative login scenarios")
 * @Test(dataProvider = "login-test-data", dataProviderClass = JsonDataProvider.class)
 * public void loginUser(String username, String password, String user_type) {
 * ProductsPage productsPage =
 * loginPage.loginWithCredentials(username, password);
 * if (user_type.equals("valid")) {
 * Allure.step("Valid user verification");
 * Assert.assertTrue(productsPage.getLblProductsTitle().isDisplayed(),
 * "Products page is loaded after successful login");
 * } else {
 * Allure.step("Invalid user verification");
 * Assert.assertTrue(loginPage.getLabelError().isDisplayed(), "Error is displayed after"
 * + " unsuccessful login");
 * }
 * }
 * }
 */