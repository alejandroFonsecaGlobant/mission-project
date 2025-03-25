
package com.globant.automation.api.requests;

import static com.globant.automation.utils.Constants.CONTENT_TYPE;
import static com.globant.automation.utils.Constants.VALUE_CONTENT_TYPE;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseRequest {

  @Step("GET request with endpoint: {endpoint}")
  protected Response requestGet(String endpoint) {

    logRequest("GET", endpoint, null);
    Response response = RestAssured.given()
      .log().all()
      .contentType(CONTENT_TYPE)
      .when()
      .get(endpoint)
      .then()
      .extract()
      .response();
    logResponse(response.body().prettyPrint());
    return response;
  }

  private static void logRequest(String method, String url, String body) {
    String request =
      "Method: " + method + "\nURL: " + url + "\nBody: " + (body == null ? "N/A" : body);
    Allure.addAttachment("Request", "text/plain", request);
  }

  private static void logResponse(String response) {
    Allure.addAttachment("Response", VALUE_CONTENT_TYPE, response);
  }
}
