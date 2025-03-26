package com.LUMA.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.LUMA.browser.Browser;
import com.LUMA.locators.LogoutObjects;

public class LogoutPage extends Browser {

	public static LogoutObjects obj;

	public static void logout() throws Exception {
		
		
		
		try {
			obj = new LogoutObjects();
			Actions actions = new Actions(driver);

			wait.until(ExpectedConditions.visibilityOf(obj.accountDropdownElement));
			actions.moveToElement(obj.accountDropdownElement).click().perform();
			System.out.println("Clicked on account dropdown");

			wait.until(ExpectedConditions.visibilityOf(obj.logoutElement));
			actions.moveToElement(obj.logoutElement).click().perform();
			System.out.println("Clicked on logout");

		} catch (Exception e) {
			System.out.println("Exception in logout method: " + e);
		}
	}
}
