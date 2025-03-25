package com.globant.automation.api.tests;

import com.globant.automation.api.requests.PokemonRequest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

  protected final SoftAssert softAssert = new SoftAssert();
  protected final PokemonRequest pokemonRequest = new PokemonRequest();
}
