Feature: Home Page validation Scenario

  Background:
  Given User has already logged into the application
  |username|password|
  |<username>|<password>|

Scenario Outline:
  Given User is on the HomePage Login Page
  When  Home Page should be opened and title should be title "<title>"
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
