package com.LUMA.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.browser.Browser;

public class SignInObjects extends Browser {

	public SignInObjects() {
		PageFactory.initElements(driver, this);
	}

//	public By email = By.xpath("//input[@id='email']");
//	public By password = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");
//	public By signin = By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
//	public By error = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailElement;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	public WebElement passwordElement;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	public WebElement signInElement;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	public WebElement errorElement;
}
