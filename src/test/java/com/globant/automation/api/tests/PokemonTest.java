package com.globant.automation.api.tests; /**
 * package com.globant.automation.api.tests;
 * <p>
 * import static com.globant.automation.utils.Constants.STATUS_CODE_NOT_FOUND;
 * import static com.globant.automation.utils.Constants.STATUS_CODE_OK;
 * <p>
 * import com.globant.automation.api.models.Pokemon;
 * import com.globant.automation.utils.JsonDataProvider;
 * import io.qameta.allure.Feature;
 * import io.qameta.allure.Step;
 * import io.restassured.response.Response;
 * import org.testng.Assert;
 * import org.testng.annotations.Test;
 *
 * @Feature("Pokemon") public class PokemonTest extends BaseTest {
 * @Test(dataProvider = "pokemon-test-data", dataProviderClass = JsonDataProvider.class)
 * @Step("GET pokemon name test")
 * public void getPokemonName(String name, int id, boolean exists) {
 * Response response = pokemonRequest.getPokemon(name);
 * if (exists) {
 * Assert.assertEquals(response.getStatusCode(), STATUS_CODE_OK,
 * "Status code is 200 for existing Pokemon");
 * Pokemon pokemon = response.as(Pokemon.class);
 * softAssert.assertTrue(pokemon.getName().equalsIgnoreCase(name),
 * "Expected name matches with actual name for existing Pokemon");
 * softAssert.assertEquals(pokemon.getId(), id,
 * "Expected ID matches with actual id for existing Pokemon");
 * } else {
 * Assert.assertEquals(response.getStatusCode(), STATUS_CODE_NOT_FOUND,
 * "Status code is 404 for non existent Pokemon");
 * }
 * }
 * }
 */
