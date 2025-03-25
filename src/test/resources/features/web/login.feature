  @web
  Feature: Login

    Scenario Outline: Login with <status> user <username>
      Given I open saucedemo web page
      When I perform login with <username> credentials
      Then I verify the login status for <status> account
      Examples:
        | username                | status  |
        | standard_user           | valid   |
        | locked_out_user         | invalid |
        | problem_user            | valid   |
        | performance_glitch_user | valid   |
        | error_user              | valid   |
        | visual_user             | valid   |