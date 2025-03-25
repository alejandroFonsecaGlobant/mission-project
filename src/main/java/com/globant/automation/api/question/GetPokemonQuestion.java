package com.globant.automation.api.question;

import static com.globant.automation.assertions.SoftAssertManager.getSoftAssert;

import static com.globant.automation.utils.Constants.STATUS_CODE_NOT_FOUND;
import static com.globant.automation.utils.Constants.STATUS_CODE_OK;
import static com.globant.automation.utils.TestContextManager.getTestContext;

import com.globant.automation.api.models.Pokemon;
import io.restassured.response.Response;
import org.testng.Assert;

public class GetPokemonQuestion {

  public void verifyGetResponse(String name, String existence) {
    Response pokemon;
    if (getTestContext().containsKey("pokemon_response"))
      pokemon = getTestContext().get("pokemon_response");
    else
      throw new RuntimeException("Response not found on context");

    if (existence.equals("existent")) {
      getSoftAssert().assertEquals(pokemon.getStatusCode() == STATUS_CODE_OK,
        "Actual response status matches expected status " + STATUS_CODE_OK);
      getSoftAssert().assertEquals(pokemon.as(Pokemon.class).getName(), name,
        "Actual pokemon name matches expected name " + name);
    } else {
      getSoftAssert().assertEquals(pokemon.getStatusCode() == STATUS_CODE_NOT_FOUND,
        "Actual response status matches expected status " + STATUS_CODE_NOT_FOUND);
    }
  }

  public void verifyStatusCode(Response response, int status) {
    Assert.assertEquals(response.getStatusCode(), status,
      "Status code of response is equal to expected " + status);
  }
}
