package com.LUMA.browser;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Browser {
	// Declaring WebDriver and utility objects
	public static WebDriver driver;
	public static WebElement element;
	public static WebDriverWait wait;
	public static Actions act;
	public static Select select;
	public static JavascriptExecutor js;

	// Extent Reports objects for logging test execution details
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest logger1;

	// Method to open the browser based on configuration
	public static void openBrowser() {
		logger1.log(Status.INFO, "opening the browser");
		try {
			// Fetching browser type from properties file
			String choice = Utility.properties("browser");

			// Initializing WebDriver based on user choice from the properties file
			if (choice.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (choice.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else {
				throw new IllegalArgumentException("Invalid browser type in properties file");// throw an exception if the browser is not specified in the properties file
			}

			logger1.log(Status.PASS, "The browser has been opened successfully");

			// Setting timeouts and maximizing window
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			// Initializing Actions class for user interactions
			act = new Actions(driver);

			System.out.println(choice + " Browser launched successfully");

		} catch (Exception e) {
			logger1.log(Status.FAIL, "The browser has not been opened :" + e);
			System.out.println("Browser - openBrowser: " + e.getMessage());
		}
	}

	// Method to navigate to the specified URL
	public static void navigateToUrl(String string) {
		logger1.log(Status.INFO, "Navigating the url");
		try {
			// Fetching URL from properties file
			String url = Utility.properties("url");
			driver.get(url);
			System.out.println("Navigated to: " + url);
		} catch (Exception e) {
			System.out.println("Browser - navigateToUrl: " + e.getMessage());
		}
	}

	// Method to close the browser
	public static void closeBrowser() {
		logger1.log(Status.INFO, "Closing the browser");
		try {
			if (driver != null) {
				driver.quit();
				driver = null; // Resetting driver instance
				System.out.println("Browser closed successfully");
			}
		} catch (Exception e) {
			System.out.println("Browser - closeBrowser: " + e.getMessage());
		}
	}

	// Method to initialize Extent Reports for logging test execution
	public static void init(String reportName) {
		extent = new ExtentReports();
		reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//target//ExtentReports//" + reportName + ".html");
		extent.attachReporter(reporter);
	}
}
