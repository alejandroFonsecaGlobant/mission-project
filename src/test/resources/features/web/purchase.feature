@web
Feature: Product Purchase

  Scenario: Successful purchase of cheapest item on the store
    Given I open saucedemo web page
    And I perform login with standard_user credentials
    And I add the cheapest item to my shopping cart
    And I go to my shopping cart
    And I verify that the contents in my cart matches my selections
    And I proceed to checkout
    And I type in my billing information
    And I continue to the checkout overview page
    And I verify that the overview displays my order correctly
    When I finish the checkout
    Then I should see the checkout finish page
