@HomePageValidation
Feature: Home Page Validation Scenario
  This feature validates the Home Page in Odoo CRM

  Background: User will login using below crendentials
    Given User has already logged into the application
    |username||password|
    |<username>||<Password>|

  Scenario Outline: To Check working of the Home Page Validation in Odoo CRM
    Given User is on the HomePage Login Page
    When Home Page should be opened and title should be title "<title>"
    Then Home Page Lists should be verified as provided Below
      |Discuss|
      |Calendar|
      |Contacts|
      |CRM|
      |Dashboards|
      |Apps|
      |Settings|
    Examples:
    |title|
    |Home|
