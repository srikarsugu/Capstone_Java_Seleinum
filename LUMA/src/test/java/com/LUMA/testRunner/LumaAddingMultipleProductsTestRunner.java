package com.LUMA.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\com.Luma.Feature\\5s_AddMultipleProducts.feature",
glue= {"com.LUMA.stepDefinitions","com.LUMA.hooks"},
plugin = {"pretty","html:target/com.Luma.CucumberReports/report5.html"})

public class LumaAddingMultipleProductsTestRunner extends AbstractTestNGCucumberTests  {

}
