Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'tiger-k@hotmail.com' and password '1234567@Sdet'
    And User click on login button
    And User should be logged in into Account
    When User click on account option

  @updateProfileInformation @smoke @regression
  Scenario: Verify User can update Profile information
    And User update Name 'khalid' and Phone '571-489-3707'
    And User click on Update button
    Then User Profile information should be updated

  @updatePassword @smoke @regression
  Scenario: Verify User can Update password
    And User enter below information
      | previousPassword | newPassword  | confirmPassword |
      | 12345@Sdet       | 1234567@Sdet | 1234567@Sdet    |
    And User click on Change Password button
    Then a message should be displayed 'Password Updated Successfully'

  @addingPaymentMethod @smoke @regression
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1234567897773456 | khalid QA  |               7 |           2027 |          787 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added successfully'

  @editingPaymentMethod @smoke @regression
  Scenario: Verify User can edit Debit or Credit card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard     | expirationMonth | expirationYear | securityCode |
      | 1234567897773457 | khalid Guerziz |              11 |           2027 |          577 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

  @removingPaymentMethod @smoke @regression
  Scenario: Verify User can remove Debit or Credit card
    And User click on remove option of card section
    Then payment details should be removed

  @addingAddress @smoke @regression
  Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
      | country | fullName     | phoneNumber | streetAddress         | apt | city   | state  | zipCode |
      | Algeria | Wawa Guerziz |  5714877707 | 4831 West Braddock Ct | 107 | Guelma | Guelma |   24000 |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  @removingAddress @smoke @regression
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
