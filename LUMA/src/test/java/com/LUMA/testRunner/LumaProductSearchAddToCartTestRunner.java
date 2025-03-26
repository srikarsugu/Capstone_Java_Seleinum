package com.LUMA.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\com.Luma.Feature\\2s_login_and_product_search.feature",
glue= {"com.LUMA.stepDefinitions","com.LUMA.hooks"},
plugin = {"pretty","html:target/com.Luma.CucumberReports/report2.html"})

public class LumaProductSearchAddToCartTestRunner extends AbstractTestNGCucumberTests{

}
 	