package Runner; 
import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Features",
glue="StepDefinition",
//tags="@Intro")
//tags="@Skill")
//tags="@Experience")
//tags="@Post")
tags="@Contact")

//,plugin= {"pretty", 
//		"html:target/HTMLReports/LinkedInReport.html",	
//		"json:target/JSONReports/LinkedInReport.json",
//		"junit:target/JUNITReports/LinkedInReport.xml",
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//})

public class UserRunner extends AbstractTestNGCucumberTests 
{
 
}