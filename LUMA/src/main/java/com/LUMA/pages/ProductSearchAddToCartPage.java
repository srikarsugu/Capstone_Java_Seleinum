package com.LUMA.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import com.LUMA.browser.Browser;
import com.LUMA.locators.ProductSearchAddToCartObjects;
import com.LUMA.screenShot.Capture;

public class ProductSearchAddToCartPage extends Browser {

    static ProductSearchAddToCartObjects obj;

    public static void selectingSearchData(String str) throws Exception {
    	logger1.addScreenCaptureFromPath(Capture.screenShot("Product to cart"));
        obj = new ProductSearchAddToCartObjects();
        try {
            boolean found = false;

            // Wait for products to be visible
            wait.until(ExpectedConditions.visibilityOfAllElements(obj.productsItem));

            for (WebElement suggestion : obj.productsItem) {
                String productText = suggestion.getText().trim();
                System.out.println("Found suggestion: " + productText);

                if (productText.equalsIgnoreCase(str)) {
                    if (suggestion.isDisplayed() && suggestion.isEnabled()) {
                        try {
                            // Scroll into view using JSExecutor
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", suggestion);
                            Thread.sleep(500); // Allow time for element to stabilize

                            // Move to element using Actions
                            Actions actions = new Actions(driver);
                            actions.moveToElement(suggestion).perform();

                            // Try clicking using Actions
                            suggestion.click();

                            System.out.println("Product found and clicked: " + productText);
                            found = true;
                            break;
                        } catch (Exception e) {
                            System.out.println("Actions click failed, trying JSExecutor...");
                            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", suggestion);
                            found = true;
                            break;
                        }
                    }
                }
            }

            // If product not found, try navigating to the next page
            if (!found) {
                System.out.println("Product not found on the current page. Checking next page...");

                // Ensure next button is visible and clickable before trying to click
                if (obj.nextElemnet.isDisplayed() && obj.nextElemnet.isEnabled()) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", obj.nextElemnet);
                        Thread.sleep(500);
                        obj.nextElemnet.click(); // Click next page button
                        Thread.sleep(2000); // Allow time for the next page to load
                        selectingSearchData(str); // Recursive call to search again
                    } catch (Exception e) {
                        System.out.println("Failed to navigate to next page: " + e.getMessage());
                    }
                } else {
                    System.out.println("No more pages to search.");
                }
            }
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for product suggestions: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception in selectingSearchData method: " + e.getMessage());
        }
    }
}
