package com.globant.automation.web.pages;

import static com.globant.automation.driver.DriverManager.createWebDriver;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Getter
public abstract class BasePage {

  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  public static WebDriver getDriver() {
    return driverThreadLocal.get();
  }

  public static void setDriver(WebDriver driver) {
    driverThreadLocal.set(driver);
  }

  public static void removeDriver() {
    WebDriver driver = driverThreadLocal.get();
    if (driver != null) {
      driver.quit();
      driverThreadLocal.remove();
    }
  }

  protected BasePage() {
    if (getDriver() == null) {
      setDriver(createWebDriver());
    }
    try {
      PageFactory.initElements(getDriver(), this);
    } catch (Exception e) {
      log.error("Error building elements with PageFactory. Exception: {}", e.getMessage());
    }
  }

  public void scrollToElement(WebDriver webDriver, WebElement webElement) {
    Actions actions = new Actions(webDriver);
    actions.scrollToElement(webElement).perform();
  }

  public void openPage(String url) {
    getDriver().get(url);
  }

  public void refreshPage() {
    getDriver().navigate().refresh();
  }
}
