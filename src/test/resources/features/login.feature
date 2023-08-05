
Feature: Login

  Scenario: Successful login with valid credentials
    Given when user launches chrome browser
    When user navigates to URL "https://admin-demo.nopcommerce.com/login"
    And enters email as "admin@yourstore.com" and password as "admin"
    And click on signin button
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on logout button
    Then page title should be "Your store. Login"
    And close the browser 

Scenario Outline: Successful login with DDT valid credentials
  Given when user launches chrome browser
    When user navigates to URL "https://admin-demo.nopcommerce.com/login"
    And enters email as "<email>" and password as "<password>"
    And click on signin button
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on logout button
    Then page title should be "Your store. Login"
    And close the browser 
    
    Examples:
    |email|password|
    |admin@yourstore.com|admin|
    |test@yourstore.com|admin|