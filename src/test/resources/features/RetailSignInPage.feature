Feature: Retail SignIn feature

  Background: 
    Given User is on retail website
    When User click on Sign in option

  @smoke @regression @signin
  Scenario: Verify user can sign in into retail Apllication
    And User enter email 'tiger-k@hotmail.com' and password '1234567@Sdet'
    And User click on login button
    Then User should be logged in into Account

  @smoke @regression @registerAccount
  Scenario: Verify user can creat an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name   | email                        | password    | confirmPassword |
      | khalid | khalid3.capstone@tekschool.us | Tek@1234567 | Tek@1234567     |
    And Use click on SignUp button
    Then User should be logged into account page
 