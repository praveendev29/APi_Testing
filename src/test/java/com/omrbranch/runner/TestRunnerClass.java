package com.omrbranch.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;
import com.omrbranch.utility.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(tags = "@log", dryRun = false, stepNotifications = false, publish = true,  plugin = {
		"pretty", "json:target\\output.json" }, name = { //scenario name comes here 
				"" }, glue = "com.omrbranch.stepdefinition", features = "src\\test\\resources\\features")
public class TestRunnerClass extends BaseClass {

	 @AfterClass
		public static void afterClass() throws FileNotFoundException, IOException {
		

	    Reporting.generateJvmReport(getProjectPath()+ "//target//output.json");
	  }
}

