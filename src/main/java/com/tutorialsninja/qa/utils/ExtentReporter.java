package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtendReport() {
		
		
		ExtentReports extentReports = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")
				+"\\test-output\\Extent Reports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Automation Testing Report");
		sparkReporter.config().setDocumentTitle("TESTNINJA AUTOMATION TEST");
		sparkReporter.config().setTimeStampFormat("dd/mm/yyyy HH:MM:SS");
		
		extentReports.attachReporter(sparkReporter);
		
		Properties prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		extentReports.setSystemInfo("APPLICATION URL", prop.getProperty("url"));
		extentReports.setSystemInfo("BROWSER", prop.getProperty("browser"));
		extentReports.setSystemInfo("EMAIL ID", prop.getProperty("validemail"));
		extentReports.setSystemInfo("PASSWORD", prop.getProperty("validpassword"));
		extentReports.setSystemInfo("OS NAME", System.getProperty("os.name"));
		extentReports.setSystemInfo("USERNAME", System.getProperty("user.name"));
		extentReports.setSystemInfo("JAVA VERSION", System.getProperty("java.version"));
		
		return extentReports;
			
	}

}
