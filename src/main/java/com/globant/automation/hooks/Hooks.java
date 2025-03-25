package com.globant.automation.hooks;

import static com.globant.automation.driver.DriverManager.createWebDriver;

import com.globant.automation.listeners.ScreenshotListener;
import com.globant.automation.web.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public class Hooks {
  @Before(value = "web", order = 0)
  public void initializeDriver() {
    BasePage.setDriver(createWebDriver());
  }

  @After(value = "@web", order = 1)
  public void closeDriver() {
    if (BasePage.getDriver() != null) {
      BasePage.getDriver().quit();
      BasePage.removeDriver();
    }
  }
}
