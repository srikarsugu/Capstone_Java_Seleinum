package com.LUMA.stepDefinitions;

import java.util.List;
import org.testng.Assert;
import com.LUMA.browser.Browser;
import com.LUMA.excel.Excel;
import com.LUMA.pages.AddToCartPage;
import com.LUMA.pages.HomePage;
import com.LUMA.pages.MyAccount;
import com.LUMA.pages.ProductSearchAddToCartPage;
import com.LUMA.pages.SignInPage;
import com.aventstack.extentreports.Status;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchAddToCartStepDefenation extends Browser {

    @When("User clicks the {string} link on the homepage")
    public void user_clicks_the_link_on_the_homepage(String string) {
        logger1.log(Status.INFO, "Attempting to click on Sign-in link");
        try {
            HomePage.clickOnSignIn();
            logger1.log(Status.PASS, "Sign-in link clicked successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Could not click on Sign-in link: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @And("User enters the valid Login Credentials")
    public void user_enters_the_valid_login_credentials(DataTable dataTable) {
        logger1.log(Status.INFO, "Attempting to enter valid credentials");
        try {
            List<List<String>> credentials = Excel
                    .dataFromExcel(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\ExcelData.xlsx", 0);
            dataTable = DataTable.create(credentials);
            SignInPage.enterValidCredentials(dataTable.cell(0, 0), dataTable.cell(0, 1));
            logger1.log(Status.PASS, "Valid credentials entered successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to enter valid credentials: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @And("User enters the data {string} in the search textbox")
    public void user_enters_the_data_in_the_search_textbox(String string) {
        try {
            MyAccount.enterSearchQuery(string);
            logger1.log(Status.PASS, "Search query entered successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to enter search query: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @And("User selects jackets for men from the auto-suggestion list  {string}")
    public void user_selects_jackets_for_men_from_the_auto_suggestion_list(String string) {
        try {
            MyAccount.selectSuggestion(string);
            logger1.log(Status.PASS, "Product selected from auto-suggestion list");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to select product from auto-suggestion list: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
    }

//    @And("User clicks on the {string} from the search results")
//    public void user_clicks_on_the_from_the_search_results(String string) {
//        try {
//            ProductSearchAddToCartPage.selectingSearchData(string);
//            logger1.log(Status.PASS, "Product selected from search results");
//        } catch (Exception e) {
//            logger1.log(Status.FAIL, "Failed to select product from search results: " + e.getMessage());
//            System.out.println("Exception: " + e.getMessage());
//        }
//    }
    @And("User clicks on the {string}  from the search results")
    public void user_clicks_on_the_from_the_search_results(String string) {
    	try {
            ProductSearchAddToCartPage.selectingSearchData(string);
            logger1.log(Status.PASS, "Product selected from search results");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to select product from search results: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
    }


    @And("User selects size, color, and quantity from")
    public void user_selects_size_color_and_quantity_from(DataTable dataTable) {
        try {
            List<List<String>> data = Excel
                    .dataFromExcel(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\ExcelData.xlsx", 0);

            if (data.size() > 1) {
                dataTable = DataTable.create(data);
                AddToCartPage.selectSize(dataTable.cell(1, 0));
                AddToCartPage.selectColor(dataTable.cell(1, 1));
                AddToCartPage.enterQuantity(dataTable.cell(1, 2));
                logger1.log(Status.PASS, "Size, color, and quantity selected successfully");
            } else {
                logger1.log(Status.FAIL, "Insufficient data in Excel for size, color, and quantity selection");
                System.out.println("Insufficient data in Excel");
            }
        } catch (IndexOutOfBoundsException e) {
            logger1.log(Status.FAIL, "Index out of bounds while selecting size, color, and quantity: " + e.getMessage());
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to select size, color, and quantity: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @And("User clicks the Add to Cart button")
    public void user_clicks_the_add_to_cart_button() {
        try {
            AddToCartPage.clickAddToCart();
            logger1.log(Status.PASS, "Add to Cart button clicked successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to click Add to Cart button: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Then("Verify whether the product is added to cart with message {string}")
    public void verify_whether_the_product_is_added_to_cart_with_message(String string) {
        try {
            Assert.assertEquals(AddToCartPage.getCartMessage(), string);
            logger1.log(Status.PASS, "Product successfully added to the cart");
        } catch (AssertionError e) {
            logger1.log(Status.FAIL, "Product not added to cart. Expected: " + string + ", but found: " + AddToCartPage.getCartMessage());
            System.out.println("AssertionError: " + e.getMessage());
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to verify product in cart: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
