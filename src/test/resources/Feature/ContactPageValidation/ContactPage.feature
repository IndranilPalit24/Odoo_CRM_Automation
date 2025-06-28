#Under this Feature file we will create a Contact either using Person or Company to create Cases
Feature: Contacts Creation
  This Page Creates Contacts for either a Person or Company for future uses

  Background: User will login using below crendentials
    Given User has already logged into the application
      |username||password|
      |<username>||<password>|

  @ContactPageRunner @Group03
  Scenario Outline: User is on Contacts Page and is creating a new Account for Person
    Given User is on HomePage and clicks on Contacts
    When User clicks on New Button to create a New Contact
    Then User selects Contact Type as "<ContactType>" to select and starts to create a Account for Person as "<Person>"
    And New Account is created for a person
    Examples:
    |ContactType|Person|
    |Person     | John Doe  |


  @ContactPageRunner @Group04
  Scenario Outline: User is on Contacts Page and is creating a new Account for Company
    Given User is on HomePage and clicks on Contacts
    When User clicks on New Button to create a New Contact
    Then User selects Contact Type as "<ContactType>" to select and starts to create a Account for Person as "<Company>"
    And New Account is created for the newly established Company
    Examples:
    |ContactType||Company|
    |Company    ||Lumber Inc|
