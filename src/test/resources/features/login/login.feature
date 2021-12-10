Feature: PayzApp Test

  @PayApp
  Scenario: Login on PayzApp
    Given user is on login page
    And User Click on Login App
#    Then User Enter Registered Email or Phone Number "7357673663" and Click on Login Button
#    And User click on Allow button
#    Then User Enter Secure Pin
#    And User Clicks on Continue and Skip button and Enter DVC code
#    Then User click on BillPay option
#    And Select BillPay utility from Excel
#    And Select Distributor Name  Enter K Number and Click Confirm button
#    Then check match Bill amount of payment page and Excel Sheet
#    And Add payment card
#    Then Enter pin or OTP on payment page
#    And get and print reference code into excel
#    And user delete the saved card


  @loop
  Scenario: Run test case in loop
    And Run test case in loop from excel sheet

  @new
 # Scenario: Add card on PayzApp
 #   Given user is on login page
 #   And User Click on Login App
 #   Then User Enter Registered Email or Phone Number "7357673663" and Click on Login Button
 #   And User click on Allow button
 #   Then User Enter Secure Pin
 #   And User Clicks on Continue and Skip button and Enter DVC code
 #   And click Login button again
 #   Then user add new card on Linked Card page
#    Then User click on BillPay option
#    And Select BillPay utility from Excel

  Scenario: extract OTP
    And extract otp from API