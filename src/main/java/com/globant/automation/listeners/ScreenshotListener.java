package com.globant.automation.listeners;

import static java.lang.String.format;

import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.testng.Reporter;

public class ScreenshotListener extends Reporter implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    log(format("Test: %s - [STARTING...]", result.getName()));
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log(format("Test: %s - [PASSED]", result.getName()));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    log(format("Test: %s - [FAIL]", result.getName()));
    ITestContext context = result.getTestContext();

    String methodName = result.getMethod().getMethodName().trim();
    String date = context.getStartDate().toString().replace(':','_');
    String scrName = methodName + " " + date;

    WebDriver driver = (WebDriver) context.getAttribute("driver"); // Retrieve the driver
    attachScreenshotToAllure(driver, scrName);
    log("Screenshot stored in screenshot folder with name: " + scrName);
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    log(format("Test: %s - [SKIPPED]", result.getName()));
  }

  private void attachScreenshotToAllure(WebDriver driver, String screenshotName) {
    byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Screenshot - " + screenshotName, new ByteArrayInputStream(screenshotBytes));
  }
}