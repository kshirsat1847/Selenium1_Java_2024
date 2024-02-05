Feature: User Login

  Background:
    Given the user is on the login page

  Scenario Outline: Successful Login with DataTable
    When the user enters valid credentials from the <email> and <password>
    
    |email             |password       |
    |santur@gmail.com  |santur@1234    |
   #|dove@gmail.com    |dove@1234      |                      
    
    And clicks the log in button
    Then the user should be redirected to the home page
    And see a welcome message
    
