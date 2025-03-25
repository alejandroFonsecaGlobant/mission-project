package com.globant.automation.utils;

public class TestContextManager {

  private static final ThreadLocal<TestContext> testContext = new ThreadLocal<>();

  public static TestContext getTestContext() {
    if (testContext.get() == null) {
      testContext.set(new TestContext());
    }
    return testContext.get();
  }
}
