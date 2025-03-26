package com.LUMA.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\com.Luma.Feature\\4s_login_valid_invalid.feature",
glue= {"com.LUMA.stepDefinitions","com.LUMA.hooks"},
plugin = {"pretty","html:target/com.Luma.CucumberReports/report4.html"})


public class LumaLoginTestRunner extends AbstractTestNGCucumberTests {

}
