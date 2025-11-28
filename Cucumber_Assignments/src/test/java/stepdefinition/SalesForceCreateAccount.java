package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesForceCreateAccount extends BaseClass {

		@Given("launch browser and load the URL")
		public void launchandLoadURL()
		{
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--user-data-dir=C:\\Users\\arunsekar.CLAYFIN\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Selenium");
		    driver = new ChromeDriver(options);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    driver.get("https://login.salesforce.com/");
		}
		
		@When("enter the valid username")
		public void enterUsername()
		{
			driver.findElement(By.id("username")).sendKeys("arunsekar2681997118@agentforce.com");
		}
		
		@And("enter the valid password")
		public void enterPassword()
		{
			driver.findElement(By.id("password")).sendKeys("Arunsekar@012");
		}
		
		@And("click Login button")
		public void clickLoginButton() throws InterruptedException
		{
			driver.findElement(By.id("Login")).click();
			
		}
		
		@And("click the App launcher")
		public void clickAppLauncher() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			WebElement appLauncher = wait.until(
			        ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))
			);
			appLauncher.click();

			
			
			
		}
		@And("click view All option")
		public void viewAllOption() throws InterruptedException
		{
			Thread.sleep(5000);

			driver.findElement(By.xpath("//button[text()='View All']")).click();
			Thread.sleep(5000);
		}
		@And("click Account option")
		public void clickAccountOption()
		{
			 act = new Actions(driver);
			WebElement findAccounts = driver.findElement(By.xpath("//p[text()='Accounts']"));
			act.scrollToElement(findAccounts).perform();
			findAccounts.click();
		}
		@When("click on New button")
		public void clickNewButton() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a/div[text()='New']")).click();
		}
		@And("enter Account Name as (.*)$")
		public void enterAccountName(String accountName) throws InterruptedException
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);
		}
		@When("select ownership as Public")
		public void selectOwnerShipValue() throws InterruptedException
		{
			Thread.sleep(3000);
			WebElement findOwnershipField = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
			act.scrollToElement(findOwnershipField).perform();
			driver.executeScript("arguments[0].click();", findOwnershipField);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='Public']")).click();
		}
		@And("click Save")
		public void clickSaveButton()
		{
			driver.findElement(By.xpath("//button[text()='Save']")).click();
		}
		@Then("verify the Account Name") 
		public void verifyAccountName() throws InterruptedException
		{
			Thread.sleep(2000);
			WebElement findAccountName = driver.findElement(By.xpath("(//a[@class='forceActionLink']/div)[4]"));
			String accountName = findAccountName.getText();
			System.out.println("Created Account Name Is : "+accountName);
			driver.quit();
		}
		

		
		
	
}
