package com.globant.automation.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

  private static final String PROPERTIES_PATH = "src/main/java/com/globant/automation/config/config.properties";

  private Properties properties;
  private static ConfigReader configReader;

  private ConfigReader() {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(PROPERTIES_PATH));
      properties = new Properties();
      properties.load(reader);
      reader.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException("config.properties not found at " + PROPERTIES_PATH);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static ConfigReader getInstance() {
    if (configReader == null) {
      configReader = new ConfigReader();
    }
    return configReader;
  }

  public String getBaseUrl() {
    String baseUrl = properties.getProperty("base.url");
    if (baseUrl != null)
      return baseUrl;
    else
      throw new RuntimeException("base.url not found in the config.properties file");
  }

  public int getTimeout() {
    String timeout = properties.getProperty("timeout.seconds");
    if (timeout != null) {
      return Integer.parseInt(timeout);
    }
    else
      throw new RuntimeException("timeout.seconds not found in the config.properties file");
  }

  public String getBrowserName() {
    String browserName = properties.getProperty("browser.name");
    if (browserName != null)
      return browserName;
    else
      throw new RuntimeException("browser.name not found in the config.properties file");
  }

  public boolean getHeadlessMode() {
    String headlessMode = properties.getProperty("headless.mode");
    if (headlessMode != null)
      return Boolean.parseBoolean(headlessMode);
    else
      throw new RuntimeException("headless.mode not found in the config.properties file");
  }

  public String getWindowSize() {
    String windowSize = properties.getProperty("window.size");
    if (windowSize != null) {
      return windowSize;
    }
    else
      throw new RuntimeException("window.size not found in the config.properties file");
  }

  public String getSeleniumGridUrl() {
    String gridUrl = properties.getProperty("seleniumgrid.url");
    if (gridUrl != null) {
      return gridUrl;
    }
    else
      throw new RuntimeException("seleniumgrid.url not found in the config.properties file");
  }
}
