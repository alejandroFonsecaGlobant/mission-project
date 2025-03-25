package com.globant.automation.api.stepsdefinition;

import static com.globant.automation.utils.Constants.STATUS_CODE_OK;

import com.globant.automation.api.question.GetPokemonQuestion;
import com.globant.automation.api.task.GetPokemonTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ApiStepsDefinition {

  private final GetPokemonTask getPokemonTask = new GetPokemonTask();
  private final GetPokemonQuestion getPokemonQuestion = new GetPokemonQuestion();


  @Given("the pokemon API is available")
  public void pokemonApiAvailable() {
    getPokemonQuestion.verifyStatusCode(getPokemonTask.pingPokemonApi(), STATUS_CODE_OK);
  }

  @When("^I send a GET pokemon call with (.*) pokemon$")
  public void sendGetPokemonCallWithPokemon(String pokemon) {
    getPokemonTask.getPokemonByName(pokemon);
  }

  @Then("^the response should contain expected values for (.*) pokemon (.*)$")
  public void responseShouldContainExpectedValuesFor(String existence, String pokemon) {
    getPokemonQuestion.verifyGetResponse(pokemon, existence);
  }
}
