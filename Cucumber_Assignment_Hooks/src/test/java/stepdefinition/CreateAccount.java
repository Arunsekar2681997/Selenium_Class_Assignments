package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import stepdefinition.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccount extends BaseClass{
	
	@Given("Launch the browser and load the URL")
	public void loadTheURL()
	{
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
		
	@When("Enter the username as {string}")
	public void enterUsername(String userName)
	{
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	
	@And("Enter the password as {string}")
	public void enterPassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@And("Click login button")
	public void loginButton() throws InterruptedException
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
	}
	
	@And("Click CRMSFA button")
	public void clickCRMSFA()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("Click lead button")
	public void clickLeadsOption()
	{
		driver.findElement(By.linkText("Leads")).click();
	}
		
	@And("Click create lead option")
	public void clickCreateLeadOption()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@And("Enter company name as {string}")
	public void enterCompanyName(String companyName)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	
	@And("Enter first name as {string}")
	public void enterFirstName(String firstName)
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
		
	@And("Enter last name as {string}")
	public void enterLastName(String lastName)
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}
		
	
	@And("Click submit button")
	public void clickSubmitButton()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("Verify the page")
	public void verifyPage()
	{
		String getPageTitle = driver.getTitle();
		System.out.println("Page Title Is : "+getPageTitle);
	}
		
		

	
	
	
}
