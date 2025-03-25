package com.globant.automation.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.testng.annotations.DataProvider;

public class JsonDataProvider {

  private static final String USER_JSON_PATH = "src/test/resources/web/test-data/credentials.json";
  private static final String POKEMON_JSON_PATH = "src/test/resources/api/test-data/pokemons.json";


  @Data
  @NoArgsConstructor
  @Getter
  public static class User {
    private String username;
    private String password;
    @JsonProperty("user_type")
    private String userType;
  }

  @Data
  @NoArgsConstructor
  @Getter
  public static class Pokemon {
    private int id;
    private String name;
    private boolean exists;
  }

  @DataProvider(name="login-test-data", parallel = true)
  public Object[][] readUserJsonData() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    User[] users = objectMapper.readValue(new File(USER_JSON_PATH), User[].class);

    Object[][] data = new Object[users.length][3];
    for (int i = 0; i < users.length; i++) {
      data[i][0] = users[i].getUsername();
      data[i][1] = users[i].getPassword();
      data[i][2] = users[i].getUserType();
    }

    return data;
  }

  @DataProvider(name="pokemon-test-data", parallel = true)
  public Object[][] readPokemonJsonData() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Pokemon[] users = objectMapper.readValue(new File(POKEMON_JSON_PATH), Pokemon[].class);

    Object[][] data = new Object[users.length][3];
    for (int i = 0; i < users.length; i++) {
      data[i][1] = users[i].getId();
      data[i][0] = users[i].getName();
      data[i][2] = users[i].isExists();
    }

    return data;
  }
}
