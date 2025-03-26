Feature: Checking Logout Functionality  

  Scenario Outline: To check the Logout functionality  
    Given User opens the browser  
    And User navigates to the application URL "https://magento.softwaretestingboard.com/"  
    When User clicks the link "Sign In"  
    And User enters valid email '<ValidEmail>' and password '<Password>'  
    And User clicks the "Sign In" button  
    When User clicks "Logout" from "My Account"  page
    Then User verifies that the session ends and the user is redirected to the homepage  
    And User verifies the "Home Page" is displayed

   Examples:  
      | ValidEmail               | Password    |  
      | srikarsugu3@gmail.com    | Pass@1234   | 
