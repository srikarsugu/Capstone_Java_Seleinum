package com.LUMA.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import com.LUMA.browser.Browser;
import com.LUMA.locators.SignInObjects;
import com.LUMA.screenShot.Capture;
import com.aventstack.extentreports.Status;

public class SignInPage extends Browser {

    static SignInObjects obj;

    public static void enterInvalidEmail(String email) throws Exception {
    	
    	obj = new SignInObjects();
        try {
        	
            wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
            obj.emailElement.clear();
            obj.emailElement.sendKeys(email);
            logger1.log(Status.PASS, "Invalid email is given");
            logger1.addScreenCaptureFromPath(Capture.screenShot("SignIn"));
        } catch (Exception e) {
            System.out.println("Exception in enterInvalidEmail method: " + e);
        }
    }

 
    public static void enterInvalidPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
            obj.passwordElement.clear();
            obj.passwordElement.sendKeys(password);
            logger1.log(Status.PASS, "Invalid password is given");
        } catch (Exception e) {
            System.out.println("Exception in enterInvalidPassword method: " + e);
        }
    }

 
    public static void enterValidCredentials(String email, String password) {
    	obj = new SignInObjects();
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
            obj.emailElement.clear();
            obj.emailElement.sendKeys(email); // ✅ Email from Excel
            wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
            obj.passwordElement.clear();
            obj.passwordElement.sendKeys(password); // ✅ Password from Excel
            logger1.log(Status.PASS, "Valid Credentials are given");
        } catch (Exception e) {
            System.out.println("Exception in enterValidCredentials method: " + e);
        }
    }

 
    public static void clickSignIn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(obj.signInElement));
            obj.signInElement.click();
            logger1.log(Status.PASS, "Signin button is clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickSignIn method: " + e);
            logger1.log(Status.FAIL, "Couldnot click signin button");
        }
    }

 
    public static String getErrorMessage() {
        String errorMessage = null;
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.errorElement));
            errorMessage = obj.errorElement.getText();
            logger1.log(Status.PASS, "Error message is given");
        } catch (Exception e) {
            System.out.println("Exception in getErrorMessage method: " + e);
            logger1.log(Status.FAIL, "Couldnot see any error messege");
        }
        return errorMessage;
    }
}
