package com.globant.automation.assertions;

import lombok.experimental.UtilityClass;
import org.testng.asserts.SoftAssert;

@UtilityClass
public class SoftAssertManager {

  private static final ThreadLocal<SoftAssert> softAssertThreadLocal = new ThreadLocal<>();

  public static SoftAssert getSoftAssert() {
    SoftAssert softAssert = softAssertThreadLocal.get();
    if (softAssert == null) {
      softAssert = new SoftAssert();
      softAssertThreadLocal.set(softAssert);
    }
    return softAssert;
  }

  public static void clearSoftAssert() {
    softAssertThreadLocal.remove();
  }
}
