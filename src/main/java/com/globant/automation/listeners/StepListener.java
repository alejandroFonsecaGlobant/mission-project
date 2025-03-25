package com.globant.automation.listeners;

import com.globant.automation.web.pages.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import java.io.ByteArrayInputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@Slf4j
public class StepListener implements StepLifecycleListener {

  @Override
  @SneakyThrows
  public void beforeStepStop(final StepResult result) {
    if ((result.getStatus().value().equals(Status.FAILED.value())
      || result.getStatus().value().equals(Status.BROKEN.value())))
      attachScreenshot("ScreenShot");
  }

  public void attachScreenshot(String name) {
    try {
      byte[] ss = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
      Allure.addAttachment(name, new ByteArrayInputStream(ss));
    } catch (Exception e) {
      log.error("Error taking screenshot: {}", e.getMessage());
    }
  }
}
