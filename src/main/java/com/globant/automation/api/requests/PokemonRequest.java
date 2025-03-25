package com.globant.automation.api.requests;

import static com.globant.automation.utils.Constants.BASE_URL;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PokemonRequest extends BaseRequest {

  @Step("GET Pokemon request with name: {name}")
  public Response getPokemon(String name) {
    String endpoint = BASE_URL + name;
    return requestGet(endpoint);
  }

  public Response pingPokemonApi() {
    return requestGet(BASE_URL);
  }
}
