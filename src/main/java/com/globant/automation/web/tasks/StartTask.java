package com.globant.automation.web.tasks;

import com.globant.automation.web.pages.LoginPage;

public class StartTask extends LoginPage {

  public void openSaucedemoWebPage() {
    openPage("https://www.saucedemo.com/");
  }
}
