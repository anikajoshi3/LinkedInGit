package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

import javax.swing.JOptionPane;

import org.openqa.selenium.JavascriptExecutor;

public class UserPageFactory {
	
	
	WebDriver driver;
	@FindBy(xpath="//input[@id=\"session_key\"]")
    @CacheLookup
    WebElement email;  
    @FindBy(xpath="//input[@id=\"session_password\"]")
    @CacheLookup
    WebElement password;
    @FindBy(xpath="//button[@data-id=\"sign-in-form__submit-btn\"]") 
    WebElement loginBtn;
    
    @FindBy(xpath="//div[@class=\"t-16 t-black t-bold\"]")
    WebElement viewProfile;

    public void ExplicitWait(WebElement webElement,int time)
    {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		 wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
   
    //Login Method
    public void login(String uname,String pwd) throws InterruptedException, AWTException
    {
    	email.sendKeys(uname);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	//Thread.sleep(20000);
    	ExplicitWait(viewProfile,20);
    	viewProfile.click();
    	Thread.sleep(10000);
    }

    public UserPageFactory(WebDriver driver) 
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
	

//----------------------------Scenario1-Edit Intro------------------------------

    @FindBy(xpath="//button[@aria-label=\"Edit intro\"]")
    WebElement editBtn;
    
    @FindBy(xpath="//input[@id='single-typeahead-entity-form-component-profileEditFormElement-TOP-CARD-profile-ACoAADVXX4wB7jHTnwzmznDkn9hvPOoy8-4v-Uw-industryId']")
	WebElement industry; 

    @FindBy(xpath="//input[@id=\"single-typeahead-entity-form-component-profileEditFormElement-TOP-CARD-profile-ACoAADVXX4wB7jHTnwzmznDkn9hvPOoy8-4v-Uw-geoLocation-cityTypeaheadField\"]")
    WebElement city;
    
    @FindBy(xpath="//button[@data-view-name='profile-form-save']")
    WebElement editIndustrySave;
    
    //assert
    @FindBy(xpath="//span[text()=\"Mumbai, Maharashtra, India\"]")
    WebElement mum;

//methods Scenario1-Edit Intro------------------------------------------------------------------------------------
    
    //Click on Edit Intro Button
    public void clickEditIntro() throws InterruptedException, AWTException
    {
    	editBtn.click();
		Thread.sleep(5000);
    }
    
    //Enter details of industry and city
    public void editIntroDetails(String ind, String ct) throws AWTException, InterruptedException
    {
    	ExplicitWait(industry,4);
    	industry.clear();
    	industry.sendKeys(ind);
    	Robot robot = new Robot();  	
        robot.delay(2000);
    	robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    	
    	ExplicitWait(city,2);
    	city.clear();
    	city.sendKeys(ct);
    	Robot robot2 = new Robot();  	
    	robot2.delay(2000);
        robot2.keyPress(KeyEvent.VK_DOWN);
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);
    }

    //Click on Save
    public void editIntroSave() throws InterruptedException, AWTException
    {
    	ExplicitWait(editIndustrySave,5);
    	editIndustrySave.click();
    }
    
    //Assert
    public String introSug()
    {
    	String sugRes=mum.getText();
    	System.out.println(sugRes);
    	return sugRes;
    }

//--------------------------------------Scenario2-Add skills----------------------------------
    
	@FindBy(xpath="//a[@id=\"navigation-add-edit-deeplink-add-skills\"]")
	WebElement skills;
	  
	@FindBy(xpath="//input[@id=\"single-typeahead-entity-form-component-profileEditFormElement-SKILL-AND-ASSOCIATION-skill-ACoAADVXX4wB7jHTnwzmznDkn9hvPOoy8-4v-Uw-1-name\"]")
	WebElement skillName;
	    
	@FindBy(xpath="//button[@data-view-name=\"profile-form-save\"]")
	WebElement skillSave;
	  
	@FindBy(xpath="//span[text()=\"No thanks\"]")
	WebElement not;
	  
	//Assert
	@FindBy(xpath="//span[text()=\"Skills\"][1]")
	WebElement sk;
	  
//methods Scenario2-Add skills---------------------------------------------------------------------
    
	//Click on Add Skill plus icon
    public void Skill() throws InterruptedException
    {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1800);");
    	ExplicitWait(skills,2);

    	skills.click();
    }
    
    //Enter the skill name
    public void addSkill(String skill) throws AWTException, InterruptedException
    {
    	ExplicitWait(skillName,10);
    	skillName.sendKeys(skill);
    	Robot robot = new Robot();  	
    	robot.delay(2000);
    	ExplicitWait(skillName,2);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    //Click on save
    public void skillSave() throws InterruptedException
    {
    	skillSave.click();
    	ExplicitWait(not,5);
    	not.click();
    }
    
    //Assert
    public String sk2()
    {
    	String skillRes=sk.getText();
    	System.out.println(skillRes);
    	return skillRes;
    }

//-------------------------Scenario3-Add work exp----------------------
	  
	  @FindBy(xpath="//button[@id=\"overflow-Add-new-experience\"]")  
	  WebElement addWorkIcon;
	  
	  @FindBy(xpath="//input[@id=\"single-typeahead-entity-form-component-profileEditFormElement-POSITION-profilePosition-ACoAADVXX4wB7jHTnwzmznDkn9hvPOoy8-4v-Uw-1-title\"]")
	  WebElement workTitle;
	  
	  @FindBy(xpath="//input[@id=\"single-typeahead-entity-form-component-profileEditFormElement-POSITION-profilePosition-ACoAADVXX4wB7jHTnwzmznDkn9hvPOoy8-4v-Uw-1-requiredCompany\"]")
	  WebElement company;
	
	  @FindBy(xpath="//select[@id=\"date-range-form-component-profileEditFormElement-POSITION-profilePosition-ACoAADVXX4wB7jHTnwzmznDkn9hvPOoy8-4v-Uw-1-dateRange-start-date\"]")
	  WebElement workMonth;
	  
	  @FindBy(xpath="//select[@id=\"date-range-form-component-profileEditFormElement-POSITION-profilePosition-ACoAADVXX4wB7jHTnwzmznDkn9hvPOoy8-4v-Uw-1-dateRange-start-date-year-select\"]")
	  WebElement workYear;
	  
	  @FindBy(xpath="//input[@id=\"single-typeahead-entity-form-component-profileEditFormElement-POSITION-profilePosition-ACoAADVXX4wB7jHTnwzmznDkn9hvPOoy8-4v-Uw-1-industryId\"]")
	  WebElement workIndustry;
	  
	  @FindBy(xpath="//button[@data-view-name=\"profile-form-save\"]")
	  WebElement workSave;
	  
	  //Assert
	  @FindBy(xpath="//span[text()=\"Experience\"][1]")
	  WebElement exp;

//methods Scenario3-Add work---------------------------------

	  //Click on Add Experience plus icon and Add Position
	  public void addWork() throws InterruptedException, AWTException
	  {
		  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1500);");
		  ExplicitWait(addWorkIcon,2);
		  addWorkIcon.click();
		  ExplicitWait(addWorkIcon,2);
	      Robot robot = new Robot();  	
	      robot.delay(2000);
	      robot.keyPress(KeyEvent.VK_DOWN);
	      robot.keyPress(KeyEvent.VK_ENTER);
	      robot.keyRelease(KeyEvent.VK_ENTER);
	      robot.delay(5000);
	  }
	  
	  //Add details of your work ie Title, Company Name, Work Month, Work Year
    public void addWorkDetails(String title, String comp,String wkMonth, String wkYear) throws AWTException, InterruptedException
    {
    	ExplicitWait(workTitle,2);
    	workTitle.sendKeys(title);
    	Robot robot = new Robot();  	
    	robot.delay(4000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 50);");
        ExplicitWait(company,2);
        company.sendKeys(comp);
        Robot robot2 = new Robot();  	
        robot2.delay(4000);
        robot2.keyPress(KeyEvent.VK_DOWN);
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);

        ExplicitWait(workMonth,4);
        Select workMonth2=new Select(workMonth);
        workMonth2.selectByVisibleText(wkMonth);
        
        ExplicitWait(workYear,4);
		Select workYear2=new Select(workYear);
		ExplicitWait(workYear,4);
		workYear2.selectByVisibleText(wkYear);
    }

    //Click on Save
    public void addWorkSave() throws InterruptedException, AWTException
    {
    	workSave.click();
		Robot robot3 = new Robot();  	
        robot3.delay(2000);
		robot3.keyPress(KeyEvent.VK_TAB);
        robot3.keyPress(KeyEvent.VK_ENTER);
    }
    
    //Assert
    public String exp2()
    {
    	String expRes=exp.getText();
    	System.out.println(expRes);
    	return expRes;
    }
    
//--------------------------------Scenario4-Create post---------------------------------

    @FindBy(xpath="//a[@id=\"navigation-create-post-Create-a-post\"]")
	WebElement post;
	
	@FindBy(xpath="//div[@class=\"ql-editor ql-blank\"]")
	WebElement postWrite;
  
	@FindBy(xpath="//button[@class=\"share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view\"]")
	WebElement submitPost;
	
	@FindBy(xpath="//a[text()=\"View post\"]")
	WebElement viewPost;
	
	//Assert
	@FindBy(xpath="//span[text()=\"Hello Connections\"]")
	WebElement activity;

//methods Sc4-Create Post------------------------------------------------------------------------------------
    
	//Click on create a post
	public void createPost() throws InterruptedException
    {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1200);");
    	ExplicitWait(post,4);

    	post.click();
    }
	
	//Write the post details
    public void writePost(String postDetail) throws InterruptedException
    {
    	ExplicitWait(postWrite,4);
    	postWrite.sendKeys(postDetail);
    }
    
    //Click on submit post
    public void submitPost() throws InterruptedException
    {
    	ExplicitWait(submitPost,4);
    	submitPost.click();
    	ExplicitWait(viewPost,4);
    	viewPost.click();
    }
    
    //Assert
    public String act()
    {
    	String postRes=activity.getText();
    	System.out.println(postRes);
    	return postRes;
    }
    
//----------------------------------Scenario5-Edit Contact Info--------------------

      @FindBy(xpath="//a[@id=\"top-card-text-details-contact-info\"]")
	  WebElement contact;
	  
	  @FindBy(xpath="//a[@class=\"ember-view pv-contact-info-section__edit-action pv-profile-section__edit-action artdeco-button artdeco-button--tertiary artdeco-button--circle artdeco-button--muted\"]")
	  WebElement editContact;
	  
	  @FindBy(xpath="//input[@id=\"single-line-text-form-component-urn-li-fsu-profileContactInfoEditFormElement-PHONE-NUMBER-1\"]")
	  WebElement phoneNo;
	  
	  @FindBy(xpath="//select[@id='text-entity-list-form-component-urn-li-fsu-profileContactInfoEditFormElement-PHONE-TYPE-1']")
	  WebElement phoneType;
	  
	  @FindBy(xpath="//textarea[@id=\"multiline-text-form-component-urn-li-fsu-profileContactInfoEditFormElement-ADDRESS-1\"]")
	  WebElement address;
	  
	  @FindBy(xpath="//select[@name=\"month\"]")
	  WebElement month;
	  
	  @FindBy(xpath="//select[@name=\"day\"]")
	  WebElement day;
	  
	  @FindBy(xpath="//button[@class=\"artdeco-button artdeco-button--2 artdeco-button--primary ember-view\"]")
	  WebElement editContactSaveBtn;
    
	  //Assert
	  @FindBy(xpath="//span[text()=\"Intermediate\"][1]")
	  WebElement inter;
	  
//methods Scenario5-Edit Contact Info------------------------------------------------------------------------
	  
	//Click on contact info  and edit contact icon
	public void clickEditContact() throws InterruptedException
    {
    	contact.click();
    	ExplicitWait(editContact,5);
    	editContact.click();
    	Thread.sleep(5000);
    	    	
    }
	
	//Enter details ie Phone Number, Phone Type, Birth Month, Birth Date
    public void editContact(String phn, String phty, String addr, String mon, String dt) throws InterruptedException
    {
    	//ExplicitWait(phoneNo,5);
    	phoneNo.clear();
    	phoneNo.sendKeys(phn);
    	System.out.println(phn);
    	
    	Select phoneType2=new Select(phoneType);
		phoneType2.selectByVisibleText(phty);
		
		address.clear();
		address.sendKeys(addr);
		Thread.sleep(2000);
		
		Select month2=new Select(month);
		month2.selectByVisibleText(mon);
		
		Select day2=new Select(day);
		day2.selectByVisibleText(dt);
    }
    
    //Click on Save
    public void editContactSave() throws InterruptedException
    {
		editContactSaveBtn.click();
		//Thread.sleep(4000);
    }
    //Assert
    public String in()
    {
    	String s=inter.getText();
    	System.out.println(s);
    	return s;
    }

}
