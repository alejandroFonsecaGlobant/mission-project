package com.globant.automation.utils;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

  private final Map<String, Object> testData = new HashMap<>();

  public void set(String key, Object value) {
    if (value == null) {
      throw new RuntimeException("Value cannot be null");
    }
    testData.put(key, value);
  }

  @SuppressWarnings("unchecked")
  public <T> T get(String key) {
    if (!testData.containsKey(key)) {
      throw new RuntimeException(
        "The specified key '" + key + "' does not exist in the test context");
    }
    return (T) testData.get(key);
  }

  public boolean containsKey(String key) {
    return testData.containsKey(key);
  }
}
