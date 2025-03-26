Feature: Checking Login, proceeds to Check out and placing Order

Scenario Outline: To Check Login, proceeding to Check out and placing Order

Given User opens the Browser
And User navigates to the "https://magento.softwaretestingboard.com/" Webpage
When User clicks Sign In button
And User enters the Login Credentials
|ProjectExcelData.xlsx|
And User clicks on the Sign In button
And User clicks the Cart icon on the Homepage
And User clicks Proceed to Checkout button
And User enters valid shipping address with valid data except for Zip/Postal Code textbox
|ProjectExcelData.xlsx|
Then User verifies the '<Error>' message displayed under Zip/Postal Code textbox
When User re-enters the valid data in Zip/Postal Code textbox
|ProjectExcelData.xlsx|
And User clicks the Next button 
And User clicks Place Order button
Then User verifies the Order Placed '<Message>'

Examples:
|Error|Message|
|Provided Zip/Postal Code seems to be invalid. Example: 123456. If you believe it is the right one you can ignore this notice.|Thank you for your purchase!|