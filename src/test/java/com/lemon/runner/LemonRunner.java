package com.lemon.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = "classpath:features/",glue = "com.lemon.steps",monochrome = true)
public class LemonRunner extends AbstractTestNGCucumberTests {
}
