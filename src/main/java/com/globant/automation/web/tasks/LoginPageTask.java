package com.globant.automation.web.tasks;

import com.globant.automation.web.pages.LoginPage;
import io.qameta.allure.Allure;

public class LoginPageTask extends LoginPage {

  public void loginWithCredentials(String username, String password) {
    getFieldUsername().sendKeys(username);
    Allure.step("Sent keys into login: " + username);
    getFieldPassword().sendKeys(password);
    Allure.step("Sent keys into password: " + password);

    getButtonLogin().click();
    Allure.step("Click on login button");
  }
}
