
Feature: create customer


  Scenario: Add new Customer by creating new customer
    Given when user launches chrome browser
    When user navigates to URL "https://admin-demo.nopcommerce.com/login"
    And enters email as "admin@yourstore.com" and password as "admin"
    And click on signin button
    Then user can see dashboard
    When user clicks on customer menu
    And user clicks on customer
    Then customer menu is visible
    When user clicks on add new customer button
    Then user can see add new customer option
    When user enters all info
    And clicks on save button
    Then user can see confirmation message "The customer has been added successfully"
    And close the browser
    
    
 Scenario: Add new Customer by creating new customer
    Given when user launches chrome browser
    When user navigates to URL "https://admin-demo.nopcommerce.com/login"
    And enters email as "admin@yourstore.com" and password as "admin"
    And click on signin button
    Then user can see dashboard
    When user clicks on customer menu
    And user clicks on customer
    Then customer menu is visible
    When user enters email in search BY email text field
    And clicks on search button
    Then customer details is vissible
    And close the browser