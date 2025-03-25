package com.globant.automation.web.tests;

import com.globant.automation.web.pages.LoginPage;
import com.globant.automation.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.asserts.SoftAssert;

@Getter
public class BaseTest {

  protected SoftAssert softAssert = new SoftAssert();
  protected LoginPage loginPage;
  private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
  private final ConfigReader config = ConfigReader.getInstance();

  public void webDriverSetup() {
    switch (config.getBrowserName()) {
      case "chrome" -> WebDriverManager.chromedriver().setup();
      case "firefox" -> WebDriverManager.firefoxdriver().setup();
      case "edge" -> WebDriverManager.edgedriver().setup();
      default ->
        throw new RuntimeException("'browser' parameter provided does not meet expected values:"
          + "Cannot setup WebDriver");
    }
  }

  public void testSetup(ITestContext testContext) {
    webDriverCreation();
    testContext.setAttribute("driver", webDriver.get());
    webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getTimeout()));
    webDriver.get().get(config.getBaseUrl());
    loginPage = new LoginPage();
  }

  private void webDriverCreation() {
    switch (config.getBrowserName()) {
      case "chrome" -> {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (config.getHeadlessMode())
          chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=" + config.getWindowSize());
        chromeOptions.addArguments("--user-data-dir=/tmp/chrome-profile-"
          + System.currentTimeMillis());
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver.set(new ChromeDriver(chromeOptions));
      }
      case "firefox" -> {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (config.getHeadlessMode())
          firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--width=" + config.getWindowSize().split(",")[0]);
        firefoxOptions.addArguments("--height=" + config.getWindowSize().split(",")[1]);
        webDriver.set(new FirefoxDriver(firefoxOptions));
      }
      case "edge" -> {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (config.getHeadlessMode()) edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--window-size=" + config.getWindowSize());
        webDriver.set(new EdgeDriver(edgeOptions));
      }
      default ->
        throw new RuntimeException("'browser' parameter provided does not meet expected values:"
          + "Cannot create WebDriver");
    }
  }

  public void tearDown() {
    if (webDriver.get() != null) {
      webDriver.get().quit();
      webDriver.remove();
    }
  }
}
