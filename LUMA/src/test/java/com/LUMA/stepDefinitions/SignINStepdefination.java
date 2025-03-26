package com.LUMA.stepDefinitions;

import java.util.List;
import com.LUMA.browser.Browser;
import com.LUMA.excel.Excel;
import com.LUMA.pages.HomePage;
import com.LUMA.pages.SignInPage;
import com.LUMA.screenShot.Capture;
import com.aventstack.extentreports.Status;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignINStepdefination extends Browser {

    @When("User clicks the link {string}")
    public void user_clicks_the_link(String string) {
        try {
            HomePage.clickOnSignIn();
            logger1.log(Status.PASS, "User clicked on the sign-in link successfully.");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to click on the sign-in link: " + e.getMessage());
            System.out.println("Exception in clicking the sign-in link: " + e.getMessage());
        }
    }

    @And("User enters invalid email {string} and password {string}")
    public void user_enters_invalid_email_and_password(String string, String string2) {
        try {
            SignInPage.enterInvalidEmail(string);
            SignInPage.enterInvalidPassword(string2);
            logger1.log(Status.PASS, "Invalid email and password entered successfully.");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to enter invalid credentials: " + e.getMessage());
            System.out.println("Exception in entering invalid credentials: " + e.getMessage());
        }
    }

    @And("User clicks the {string} button")
    public void user_clicks_the_button(String string) {
        try {
            SignInPage.clickSignIn();
            logger1.log(Status.PASS, "Sign-in button clicked successfully.");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to click the sign-in button: " + e.getMessage());
            System.out.println("Exception in clicking the sign-in button: " + e.getMessage());
        }
    }

    @Then("User verifies the error message {string}")
    public void user_verifies_the_error_message(String string) {
        try {
            String actualMessage = SignInPage.getErrorMessage();
            if (actualMessage.equals(string)) {
                logger1.log(Status.PASS, "Error message verified successfully.");
                System.out.println("Error message verified successfully.");
            } else {
                logger1.log(Status.FAIL, "Error message verification failed. Expected: " + string + ", but found: " + actualMessage);
                System.out.println("Expected: " + string + ", but found: " + actualMessage);
            }
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Exception in verifying error message: " + e.getMessage());
            System.out.println("Exception in verifying error message: " + e.getMessage());
        }
    }

    @When("User enters valid credentials from")
    public void user_enters_valid_credentials_from(DataTable dataTable) {
        try {
            List<List<String>> credentials = Excel.dataFromExcel(System.getProperty("user.dir") + 
                    "\\src\\test\\resources\\excel\\ExcelData.xlsx", 0);
            dataTable = DataTable.create(credentials);
            SignInPage.enterValidCredentials(dataTable.cell(0, 0), dataTable.cell(0, 1));
            logger1.log(Status.PASS, "Valid credentials entered successfully from Excel.");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to enter valid credentials from Excel: " + e.getMessage());
            System.out.println("Exception in entering valid credentials from Excel: " + e.getMessage());
        }
    }

    @Then("User verifies that {string} is displayed after login")
    public void user_verifies_that_is_displayed_after_login(String string) {
        try {
            String actualTitle = HomePage.getHomePageText();
            if (actualTitle.equalsIgnoreCase(string)) {
                logger1.log(Status.PASS, "Login successful, and 'My Account' page is displayed.");
                System.out.println("Login successful and 'My Account' page is displayed.");
                Capture.screenShot("HomePage");
            } else {
                logger1.log(Status.FAIL, "Login failed. Expected: " + string + ", but found: " + actualTitle);
                System.out.println("Expected: " + string + ", but found: " + actualTitle);
            }
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Exception in verifying login success: " + e.getMessage());
            System.out.println("Exception in verifying login success: " + e.getMessage());
        }
    }
}
