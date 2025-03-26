package com.LUMA.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LUMA.browser.Browser;

public class RegistrationPageObjects extends Browser {

	// Constructor to initialize WebElements using PageFactory
	public RegistrationPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// Locating the First Name input field
	@FindBy(xpath = "//input[@id='firstname']")
	public WebElement firstNameElement;

	// Locating the Last Name input field
	@FindBy(xpath = "//input[@id='lastname']")
	public WebElement lastNameElement;

	// Locating the Email Address input field
	@FindBy(xpath = "//input[@id='email_address']")
	public WebElement emailElement;

	// Locating the Password input field
	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordElement;

	// Locating the Confirm Password input field
	@FindBy(xpath = "//input[@id='password-confirmation']")
	public WebElement confirmPasswordElement;

	// Locating the 'Create an Account' button
	@FindBy(xpath = "//button[@title='Create an Account']")
	public WebElement createAnAccountElement;

	// Locating the error message element for invalid email input
	@FindBy(xpath = "//div[@id='email_address-error']")
	public WebElement emailErrorElement;
}
