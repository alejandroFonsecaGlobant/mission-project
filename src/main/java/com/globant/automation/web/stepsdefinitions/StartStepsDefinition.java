package com.globant.automation.web.stepsdefinitions;

import com.globant.automation.web.tasks.StartTask;
import io.cucumber.java.en.Given;

public class StartStepsDefinition {

  private final StartTask startTask = new StartTask();

  @Given("I open saucedemo web page")
  public void openSaucedemoPage() {
    startTask.openSaucedemoWebPage();
  }
}
