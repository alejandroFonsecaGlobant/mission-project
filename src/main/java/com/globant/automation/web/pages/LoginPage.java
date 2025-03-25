package com.globant.automation.web.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

  @FindBy(id = "user-name")
  private WebElement fieldUsername;

  @FindBy(id = "password")
  private WebElement fieldPassword;

  @FindBy(id = "login-button")
  private WebElement buttonLogin;

  @FindBy(css = "[data-test='error']")
  private WebElement labelError;
}