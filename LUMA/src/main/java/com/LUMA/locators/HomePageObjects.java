package com.LUMA.locators;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LUMA.browser.Browser;

public class HomePageObjects extends Browser {

	// Constructor to initialize WebElements using PageFactory
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	// Locating the "Sign In" link in the header panel
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	public WebElement signinLink;

	// Locating the "Create New Account" link
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	public WebElement createNewAccountLink;

	// Locating the homepage title or main text element
	@FindBy(xpath = "//span[@class='base']")
	public WebElement homepageText;

	// Locating the cart icon to view cart details
	@FindBy(xpath = "//a[@class='action showcart']")
	public WebElement cartIcon;

	// Locating the total price displayed in the cart
	@FindBy(xpath = "//div[2]/div[2]/div/span/span")
	public WebElement totalPrice;

	// Locating the list of "Remove item" buttons in the cart
	@FindBy(xpath = "//a[@title='Remove item']")
	public List<WebElement> cartList;

	// Locating the confirmation button in a popup (e.g., delete confirmation)
	@FindBy(xpath = "//button[@class='action-primary action-accept']")
	public WebElement popUpAcceptElement;

	// Locating the counter that shows the number of items in the cart
	@FindBy(xpath = "//span[@class='counter qty'] /span[@class='counter-number']")
	public List<WebElement> counterElement;

	// Locating the "Proceed to Checkout" button in the cart
	@FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
	public WebElement proceedToCartElement;

	// Locating the close button for popups or modals
	@FindBy(xpath = "//button[@data-action='close']")
	public WebElement closingButtonElement;
}
