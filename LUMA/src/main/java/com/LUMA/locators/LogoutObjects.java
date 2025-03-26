package com.LUMA.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LUMA.browser.Browser;

public class LogoutObjects extends Browser {

    // Constructor to initialize WebElements using PageFactory
    public LogoutObjects() {
        PageFactory.initElements(driver, this);
    }

    // Locating the account dropdown button in the header panel
    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    public WebElement accountDropdownElement;

    // Locating the "Sign Out" option in the dropdown menu
    @FindBy(xpath = "//a[contains(text(),'Sign Out')]")
    public WebElement logoutElement;
}
