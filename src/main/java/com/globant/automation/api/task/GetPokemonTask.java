package com.globant.automation.api.task;

import static com.globant.automation.utils.TestContextManager.getTestContext;

import com.globant.automation.api.requests.PokemonRequest;
import io.restassured.response.Response;


public class GetPokemonTask extends PokemonRequest {

  public void getPokemonByName(String name) {
    Response response = getPokemon(name);
    getTestContext().set("pokemon_response", response);
  }
}
