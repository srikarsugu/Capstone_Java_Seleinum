package com.LUMA.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\com.Luma.Feature",
glue= {"com.LUMA.stepDefinitions","com.LUMA.hooks"},
plugin = {"pretty","html:target/com.Luma.CucumberReports/report1.html"}
		)
public class LumaUserRegestrationTestRunner extends AbstractTestNGCucumberTests {

}
