package com.omrbranch.report;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.utility.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {

	public static void generateJvmReport(String jsonFile) {
	    // 1. Create Object For Configuration Class -->Path of jvm report where to
	    // store, Project name
	    Configuration configuration = new Configuration(
	        new File(getProjectPath()+"\\target"),
	        "API Automation Project");

	    // 2. Add key and value -->Design purpose
	    configuration.addClassifications("Browser", "Chrome");
	    configuration.addClassifications("Browser Version", "123");
	    configuration.addClassifications("OS", "WIN 11");
	    configuration.addClassifications("Sprint", "34");

	    // 3. Read the results ,Create Object for Reportbuilder Class -->Pass JSON Files
	    List<String> jsonFiles = new ArrayList<>();
	    jsonFiles.add(jsonFile);
	    ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

	    // 4. Build JVM Report
	    builder.generateReports();

}
}
