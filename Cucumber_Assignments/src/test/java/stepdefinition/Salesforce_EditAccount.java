package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Salesforce_EditAccount extends BaseClass{
	
	

    @And("Search for the account using unique account name {string}")
    public void searchAccount(String accountName) throws InterruptedException {
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("ArunSekar2681997",Keys.ENTER);
    }

    @And("Click the dropdown icon next to the account and select Edit")
    public void clickDropdownAndEdit() throws InterruptedException {
    	Thread.sleep(3000);
      driver.findElement(By.xpath("(//*[local-name()='svg' and @data-key='down'])[6]")).click();
      Thread.sleep(3000);
      WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
      driver.executeScript("arguments[0].click();", edit);
    }

    @And("Set Type to Technology Partner")
    public void setType() throws InterruptedException {
    	Thread.sleep(3000);
		WebElement findIndustryField = driver.findElement(By.xpath("//button[@aria-label='Type']"));
		act.scrollToElement(findIndustryField).perform();
		driver.executeScript("arguments[0].click();", findIndustryField);
    	Thread.sleep(3000);
		WebElement clickDropdownField = driver.findElement(By.xpath("//div[@aria-label='Type']//span/span[text()='Technology Partner']"));
		act.scrollToElement(clickDropdownField).perform();
		clickDropdownField.click();
    }

    @And("Set Industry to Healthcare")
    public void setIndustry() throws InterruptedException {
        Thread.sleep(3000);
        WebElement findIndustryField = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        act.scrollToElement(findIndustryField).perform();
        driver.executeScript("arguments[0].click();", findIndustryField);
        Thread.sleep(3000);
        WebElement clickDropdownField = driver.findElement(By.xpath("//div[@aria-label='Industry']//span/span[text()='Healthcare']"));
        act.scrollToElement(clickDropdownField).perform();
        clickDropdownField.click();
    }


    //enter the billing address details
    @And("Select the country For Billing Address {string}")
    public void selectCountry(String country) throws InterruptedException {
    	Thread.sleep(3000);
		WebElement findBillingCountry = driver.findElement(By.xpath("//input[@aria-label='Billing Country']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", findBillingCountry);
		findBillingCountry.click();
		Thread.sleep(3000);
		WebElement findCountryValue = driver.findElement(By.xpath("//div[@aria-label='Billing Country']//span/span[text()='"+country+"']"));	
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", findCountryValue);
		findCountryValue.click();
    }
		
	@And("Enter the street name for Billing Address {string}")
	public void billingStreet(String address)
	{
		WebElement findAddress = driver.findElement(By.xpath("//textarea[@name='street']"));
		act.scrollToElement(findAddress).perform();
		findAddress.sendKeys(address);
	}
		
		
	@And("Select the state for Billing Address {string}")
	public void selectState(String state) throws InterruptedException
	{
		WebElement findBillingStateDropdown = driver.findElement(By.xpath("//input[@aria-label='Billing State/Province']"));
		act.scrollToElement(findBillingStateDropdown).perform();
		findBillingStateDropdown.click();
		Thread.sleep(3000);
		WebElement findStateValue = driver.findElement(By.xpath("//div[@aria-label='Billing State/Province']//span/span[text()='"+state+"']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", findStateValue);
		findStateValue.click();
	}
	
	@And("Enter the City for billing address {string}")
	public void enterCity(String city)
	{
		driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(city);
	}
		
	@And("Enter the Pincode for billing address {string}")
	public void enterPIN(String pinNumber)
	{
		driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(pinNumber);		
	}
		
			
    	

    @And("Select the country for Shipping Address {string}")
    public void selectCountryName(String country) throws InterruptedException {
    	WebElement findShippingCountryDropdown = driver.findElement(By.xpath("//input[@aria-label='Shipping Country']"));
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", findShippingCountryDropdown);
		findShippingCountryDropdown.click();
		Thread.sleep(3000);
		WebElement clickShippingCountry = driver.findElement(By.xpath("(//div//span/span[text()='"+country+"'])[2]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", clickShippingCountry);
		clickShippingCountry.click();
		
    }
		//Shipping street
    @And("Enter the street for shippling address {string}")
    public void enterStreet(String street)
    {
    	driver.findElement(By.xpath("(//textarea[@name='street'])[2]")).sendKeys(street);
    }
    
    
    @And("Enter the city for shipping address {string}")
    public void enterCityName(String city)
    {
    	driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(city);
    }
		
		//Shipping City
		
		
	@And("Enter the state for shipping address {string}")
	public void enterStatename(String stateName)
	{
		WebElement findShippingStateDropDown = driver.findElement(By.xpath("(//input[@name='province'])[2]"));
		act.scrollToElement(findShippingStateDropDown).perform();
		findShippingStateDropDown.click();
		WebElement selectStateValue = driver.findElement(By.xpath("//div[@aria-label='Shipping State/Province']//span/span[text()='"+stateName+"']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectStateValue);
		selectStateValue.click();
	}
	
	@And("Enter the Pin code for shipping address {string}")
	public void enterPinCodeValue(String pinCodeNumber)
	{
		//Enter postal code
		driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(pinCodeNumber);
	}
		
    

	@And("Set Customer Priority to Low")
    public void setCustomerPriority() {
    	WebElement findCustomerPrority = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", findCustomerPrority);
		findCustomerPrority.click();
		WebElement selectPriorityValue = driver.findElement(By.xpath("//div//span/span[text()='Low']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectPriorityValue);
		selectPriorityValue.click();
    }
    

	@And("Set SLA to Silver")
    public void setSLA() throws InterruptedException {
    	WebElement findSLA = driver.findElement(By.xpath("//button[@aria-label='SLA']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", findSLA);
		findSLA.click();
		Thread.sleep(2000);
		WebElement selectValue = driver.findElement(By.xpath("//div//span/span[text()='Silver']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectValue);
		selectValue.click();
    }

	@And("Set Active to NO")
    public void setActive() {
    	WebElement findActiveDropDown = driver.findElement(By.xpath("//button[@aria-label='Active']"));
		act.scrollToElement(findActiveDropDown).perform();
		findActiveDropDown.click();
		driver.findElement(By.xpath("//div//span/span[text()='No']")).click();
    }

	@And("Enter a phone number {string}")
    public void enterPhoneNumber(String phoneNumberValue) {
    	WebElement enterPhoneNumber = driver.findElement(By.xpath("//input[@name='Phone']"));
		enterPhoneNumber.sendKeys(phoneNumberValue);
    }

	@And("Set Upsell Opportunity to No")
    public void setUpsellOpportunity() {
    	WebElement findUpsellDropDown = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
    	act.scrollToElement(findUpsellDropDown).click();
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", findUpsellDropDown);
		findUpsellDropDown.click();
		driver.findElement(By.xpath("//div//span/span[text()='No']")).click();
    }

    @Then("Click Save and verify the phone number")
    public void clickSaveAndVerify() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(5000);
		WebElement getPhoneNumber = driver.findElement(By.xpath("(//table//tr/td)[4]"));
		String phoneNumber = getPhoneNumber.getText();
		phoneNumber = phoneNumber.replaceAll("\\D", "");
		System.out.println("Phone Number Value Is : "+phoneNumber);
		driver.quit();
    }

}
