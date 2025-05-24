🧪 Odoo CRM Automation
This is a Cucumber-based Selenium automation framework for testing the Odoo CRM application. It uses the Page Object Model (POM) and supports configuration through property files.

📁 Folder Structure Overview:
src/main/java

DataProvider: Contains the DriverFactory class for managing WebDriver instances.

Pages: Page Object classes like Loginpage that encapsulate web elements and actions.

Utility: Includes helpers like ConfigReader for reading config files.

src/test/java

Hooks: Manages pre/post scenario steps (e.g., launching browser, taking screenshots).

Runner: Contains the test runner class for executing feature files.

StepDefinition: Houses step definitions that link Gherkin steps to Java code.

src/test/resources

Config: Contains configuration properties (config.properties).

Feature: Holds Cucumber .feature files like Login.feature.
