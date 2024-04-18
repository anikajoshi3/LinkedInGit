package StepDefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import DriverSetup.SetupDriver;
import PageFactory.UserPageFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserStepDefinition {
	
	static WebDriver driver;
	UserPageFactory pf;
	
	@Given("User is logged in and on View Profile page")
	public void user_is_logged_in_and_on_view_profile_page(DataTable dataTable) throws InterruptedException, AWTException 
	{
		driver = SetupDriver.chromedriver();
		pf=new UserPageFactory(driver);
		List<List<String>> cells = dataTable.cells();
		pf.login(cells.get(0).get(0),cells.get(0).get(1)); 
	}
		
//-------------------------------------Scenario1-Edit Intro----------------------------------------
		
	@When("User clicks on Edit Intro button")
	public void user_clicks_on_edit_intro_button() throws InterruptedException, AWTException 
	{	
		pf.clickEditIntro();
	}
	
	@And("enters Industry and City")
	public void enters_industry_and_city(DataTable dataTable) throws AWTException, InterruptedException 
	{  
		List<List<String>> cells = dataTable.cells();
		pf.editIntroDetails(cells.get(0).get(0),cells.get(0).get(1)); 
	}
	
	@And("clicks on Save")
	public void clicks_on_save() throws InterruptedException, AWTException 
	{
		pf.editIntroSave();
	}

	@Then("changes should get saved")
	public void changes_should_get_saved() 
	{
		String sugExpected=pf.introSug();
	    Assert.assertTrue(sugExpected.contains("Mumbai, Maharashtra, India"));
	}
	
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) 
//	{
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}
	
//-------------------------------Scenario2-Add skill------------------------------------------
	
	@When("User clicks on Add Skill option")
	public void user_clicks_on_add_skill_option() throws InterruptedException, AWTException
	{
		pf.Skill();
	}

	@And("enters the {string}")
	public void enters_the(String skill) throws AWTException, InterruptedException 
	{
	    pf.addSkill(skill);
	}
	
	@And("clicks on the Save button")
	public void clicks_on_the_save_button() throws InterruptedException 
	{
	    pf.skillSave();
	}

	@Then("Skill should be added")
	public void skill_should_be_added()
	{
		String expSkill=pf.sk2();
	    Assert.assertTrue(expSkill.contains("Skills"));
	}
	
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) 
//	{
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}
	
//-------------------------------------------Scenario3-Add work experience--------------------------------
	
	@When("User clicks on Add Experience option")
	public void user_clicks_on_add_experience_option() throws InterruptedException, AWTException 
	{
		pf.addWork();
	}
	
	@And("enters Title, Company Name, Start Month, and Start Year")
	public void enters_title_company_name_start_month_and_start_year(DataTable dataTable) throws AWTException, InterruptedException
	{
		List<List<String>> cells = dataTable.cells();
		pf.addWorkDetails(cells.get(0).get(0),cells.get(0).get(1),cells.get(0).get(2),cells.get(0).get(3)); 
	}

	@And("clicks on Save option")
	public void clicks_on_save_option() throws InterruptedException, AWTException 
	{
	    pf.addWorkSave();
	}
	
	@Then("Experience should be saved and displayed")
	public void experience_should_be_saved_and_displayed()
	{
		String expExpected=pf.exp2();
	    Assert.assertTrue(expExpected.contains("Experience"));
	}
	
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio)
//	{
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}
	
//-------------------------------------Sc4-Create post------------------------------------

	@When("User clicks on Create a Post option")
	public void user_clicks_on_create_a_post_option() throws InterruptedException, AWTException 
	{
		pf.createPost();
	}
	
	@And("enters Details of their Post")
	public void enters_details_of_their_post(DataTable dataTable) throws InterruptedException 
	{
	    List<List<String>> cells = dataTable.cells();
		pf.writePost(cells.get(0).get(0));  
	}
	
	@And("clicks on Post option")
	public void clicks_on_post_option() throws InterruptedException 
	{
	    pf.submitPost();
	}
	
	@Then("that Post should be displayed")
	public void that_post_should_be_displayed() 
	{
	    String postExpected=pf.act();
	    Assert.assertTrue(postExpected.contains("Hello Connections"));
	}
	
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) 
//	{
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}
	
//------------------------------------Scenario5-Edit Contact Info-----------------------------------------
	
	@When("User clicks on Contact Info and clicks on Edit button")
	public void user_clicks_on_contact_info_and_clicks_on_edit_button() throws InterruptedException, AWTException 
	{
		pf.clickEditContact();
	}

	@And("enters Phone Number, Phone Type, Address, Birth Month, and Birth Date")
	public void enters_phone_number_phone_type_address_birth_month_and_birth_date(DataTable dataTable) throws InterruptedException 
	{
	    List<List<String>> cells = dataTable.cells();
		pf.editContact(cells.get(0).get(0),cells.get(0).get(1),cells.get(0).get(2),cells.get(0).get(3),cells.get(0).get(4));
	}

	@And("clicks on Save button")
	public void clicks_on_save_button() throws InterruptedException
	{
		pf.editContactSave();
	}
	
	@Then("changes should not get saved")
	public void changes_should_not_get_saved()
	{
		String so=pf.in();
		Assert.assertTrue(so.contains("Intermediate"));
	}
	
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) 
//	{
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}

}
