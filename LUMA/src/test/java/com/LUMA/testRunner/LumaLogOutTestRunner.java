package com.LUMA.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\com.Luma.Feature\\6s_logout.feature",
glue= {"com.LUMA.stepDefinitions","com.LUMA.hooks"},
plugin = {"pretty","html:target/com.Luma.CucumberReports/report6.html"})


public class LumaLogOutTestRunner extends AbstractTestNGCucumberTests {

}
