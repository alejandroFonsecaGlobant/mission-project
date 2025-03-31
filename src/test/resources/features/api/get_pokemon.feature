@api
Feature: PokeApi - GET Pokemon

  Scenario Outline: GET Pokemon using name <pokemon>
    Given the pokemon API is available
    When I send a GET pokemon call with <pokemon> pokemon
    Then the response should contain expected values for <existence> pokemon <pokemon>
    Examples:
      | pokemon    | existence   |
      | pikachu    | existent    |
      | CharmandeR | existent    |
      | pIkAcHu    | existent    |
      | CHARMANDER | existent    |
      | diego      | nonexistent |