package com.globant.automation.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import lombok.experimental.UtilityClass;
import com.globant.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@UtilityClass
public class DriverManager {

  private final ConfigReader config = ConfigReader.getInstance();

  public static WebDriver createWebDriver() {
    WebDriver webDriver = switch (config.getBrowserName()) {
      case "chrome" -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (config.getHeadlessMode())
          chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=" + config.getWindowSize());
        yield new ChromeDriver(chromeOptions);
      }
      case "firefox" -> {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (config.getHeadlessMode())
          firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--width=" + config.getWindowSize().split(",")[0]);
        firefoxOptions.addArguments("--height=" + config.getWindowSize().split(",")[1]);
        yield new FirefoxDriver(firefoxOptions);
      }
      case "edge" -> {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        if (config.getHeadlessMode()) edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--window-size=" + config.getWindowSize());
        yield new EdgeDriver(edgeOptions);
      }
      default ->
        throw new RuntimeException("'browser' parameter provided does not meet expected values:"
          + "Cannot create WebDriver");
    };
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getTimeout()));
    return webDriver;
  }
}
