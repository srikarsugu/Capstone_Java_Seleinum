package com.LUMA.locators;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LUMA.browser.Browser;

public class MyAccountObject extends Browser {

    // Constructor to initialize WebElements using PageFactory
    public MyAccountObject() {
        PageFactory.initElements(driver, this);
    }

    // Locating the "My Account" text element to verify account page navigation
    @FindBy(xpath = "//span[@class='base']")
    public WebElement myAccountTextElement;

    // Locating the search box element on the page
    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBoxElement;

    // Locating the list of search suggestions that appear in the dropdown
    @FindBy(xpath = "//ul[@role='listbox']/li/span[1]")
    public List<WebElement> searchList;

    // Locating the registration confirmation message on the page
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement RegistrationTextElement;
}
