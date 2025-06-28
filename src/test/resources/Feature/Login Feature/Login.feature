@LoginPageFeature
Feature: Login Page Scenario
  This feature validates the login functionality for Odoo CRM.

  @LoginRunner @Group01
  Scenario Outline: To check the working of the login page in Odoo CRM using Email and Password
    Given I login into the website
    When I enter the username "<username>" and password "<password>"
    Then I should be logged into the website
    And Home Page should be opened and title should be title "<title>"
    Examples:
      |username|password| title|
      |<username>|<password>|Home|