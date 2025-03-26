package com.LUMA.stepDefinitions;



import org.testng.Assert;

import com.LUMA.browser.Browser;
import com.LUMA.pages.HomePage;
import com.LUMA.pages.MyAccount;
import com.LUMA.pages.RegistrationPage;
import com.LUMA.screenShot.Capture;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegestritionStepDefination extends Browser{
	@Given("User opens the browser")
	public void user_opens_the_browser() {
		try {
		Browser.openBrowser();
		logger1.log(Status.PASS, "Browser is opened");
		}catch(Exception e) {
			logger1.log(Status.FAIL, "Browser is not opened");
		}
	}

	@And("User navigates to the application URL {string}")
	public void user_navigates_to_the_application_url(String string) {
		try {
		Browser.navigateToUrl(string);
		logger1.log(Status.PASS, "Navigated to the URL");
		}catch(Exception e) {
			logger1.log(Status.FAIL, "Did not navigate to the URL");
		}
	}

	@When("User clicks the link Create an account")
	public void user_clicks_the_link_create_an_account() {
		logger1.log(Status.INFO, "Clicks on create an account");
		try {
			HomePage.clickOnCreateNewAccount();
			logger1.log(Status.PASS, "Clicked on create account");
		}catch(Exception e) {
			logger1.log(Status.FAIL, "Did not click on create account");
		}
			
	}

	@And("User enters the valid {string} in firstname textbox")
	public void user_enters_the_valid_in_firstname_textbox(String string) {
		try {
		RegistrationPage.enterFirstName(string);
		logger1.log(Status.PASS, "firstname is entered");
		} catch(Exception e) {
			logger1.log(Status.FAIL, "firstname is not entered");
		}
	}

	@And("User enters the valid {string} in lastname textbox")
	public void user_enters_the_valid_in_lastname_textbox(String string) {
		try {
      RegistrationPage.enterLastName(string);
      logger1.log(Status.PASS, "last name is entered");
		} catch(Exception e) {
			logger1.log(Status.FAIL, "lastname is not entered");
		}
	}

	@And("User enters the invalid {string} in email textbox")
	public void user_enters_the_invalid_in_email_textbox(String string) {
		try {
			
		RegistrationPage.enterEmail(string);
		
		logger1.log(Status.PASS, "invalid Email is enterd");
		} catch(Exception e) {
			 logger1.log(Status.FAIL, "invalid Email is not entered");
		}
	}

	@And("User enters the valid {string} in password textbox")
	public void user_enters_the_valid_in_password_textbox(String string) {
		try {
		RegistrationPage.enterPassword(string);
		logger1.log(Status.PASS, "Password is entered");
		} catch(Exception e) {
			 logger1.log(Status.FAIL, "Password is not entered");
		}
	}

	@And("User enters the valid {string} in confirm password textbox")
	public void user_enters_the_valid_in_confirm_password_textbox(String string) {
		try {
		RegistrationPage.enterConfirmPassword(string);
		logger1.log(Status.PASS, "Confirm password is entered");
		} catch(Exception e) {
			 logger1.log(Status.FAIL, "Confirm password is not entered");
		}
	}

	@And("User clicks the Create an account button")
	public void user_clicks_the_create_an_account_button() {
		logger1.log(Status.INFO, "Create account button is clicked");
		try {
				RegistrationPage.clickCreateAnAccount();
				logger1.log(Status.PASS, "Clicks on the Create Account button");
		} catch (Exception e) {
			 logger1.log(Status.FAIL, "Create Account button is not clicked");
			
		}
	}

	@Then("User verifies the {string} message displayed under the email textbox")
	public void user_verifies_the_message_displayed_under_the_email_textbox(String string) {
	   try {
		Assert.assertEquals(RegistrationPage.emailErrorMessage(),string );
		logger1.addScreenCaptureFromPath(Capture.screenShot("Invaid email error"));
		logger1.log(Status.PASS, "Viewed error message");
	} catch (Exception e) {
		System.out.println("mail is "+e.getMessage());
		logger1.log(Status.FAIL,"error message is not visible");
	}
	}

	@When("User re-enters the email with valid data {string}")
	public void user_re_enters_the_email_with_valid_data(String string) {
		try {
		RegistrationPage.enterEmail(string);
		logger1.log(Status.PASS, "Enters the valid  email");
		} catch(Exception e){
			 logger1.log(Status.FAIL, "valid Email is not enterd");
		}
	}

	@Then("User verifies thank you {string} in the next page")
	public void user_verifies_thank_you_in_the_next_page(String string) {
		logger1.log(Status.INFO, "Thankyou page is verified");
		try {
			Assert.assertEquals(MyAccount.getRegistrationText(), string);
			logger1.addScreenCaptureFromPath(Capture.screenShot("Thankyou message"));
			logger1.log(Status.PASS, "Thankyou message is shown");
		} catch (Exception e) {
			System.out.println("message is not visible"+e.getMessage());
			 logger1.log(Status.FAIL, "Thankyou message is not shown");
		}
	}

}
