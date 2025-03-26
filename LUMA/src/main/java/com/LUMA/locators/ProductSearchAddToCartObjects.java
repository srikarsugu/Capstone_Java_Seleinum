package com.LUMA.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LUMA.browser.Browser;
import java.util.List;

public class ProductSearchAddToCartObjects extends Browser {
	public ProductSearchAddToCartObjects() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Locating the list of product items displayed after searching for a product
	@FindBy(xpath = "//div[@class='product details product-item-details' ]/strong/a")
	public List<WebElement> productsItem;
	// Locating the "Next" button element to navigate to the next page of search results
	@FindBy(xpath = "//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/div[2]/ul[1]/li[4]/a[1]")
	public WebElement nextElemnet;
}
