package com.LUMA.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LUMA.browser.Browser;
import java.util.List;

public class AddToCartObjects extends Browser {

	// Constructor to initialize WebElements
	public AddToCartObjects() {
		PageFactory.initElements(driver, this);
	}

	// Locating all available size options for the product
	@FindBy(xpath = "//div[@attribute-code='size']/div/div")
	public List<WebElement> sizeOptions;

	// Locating all available color options for the product
	@FindBy(xpath = "//div[contains(@class, 'swatch-option color')]")
	public List<WebElement> colorOptions;

	// Locating the quantity input box for the product
	@FindBy(id = "qty")
	public WebElement quantityBox;

	// Locating the "Add to Cart" button
	@FindBy(id = "product-addtocart-button")
	public WebElement addToCartButton;

	// Locating the success message displayed after adding a product to the cart
	@FindBy(css = ".message-success")
	public WebElement cartMessage;

	// Locating the total cart amount displayed after adding a product
	@FindBy(xpath = "//span[@class='price']")
	public WebElement cartAmountElement;

	// Locating the cart icon/symbol in the UI
	@FindBy(xpath = "//a[@class='action showcart']")
	public WebElement cartSymbolElement;
}
