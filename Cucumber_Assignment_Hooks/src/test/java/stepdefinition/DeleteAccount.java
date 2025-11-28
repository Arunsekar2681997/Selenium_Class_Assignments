package stepdefinition;

import org.openqa.selenium.By;

import stepdefinition.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeleteAccount extends BaseClass{

	@And("Click the first record and store the ID")
	public void clickRecordAndStore() throws InterruptedException
	{
		Thread.sleep(2000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	
	@And("Click the delete button")
	public void clickDeleteButton()
	{
		driver.findElement(By.linkText("Delete")).click();
	}
	
	@And("Enter the value using ID and Search")
	public void enterValueAndSearch()
	{
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
//	driver.findElement(By.linkText("Find Leads")).click();
	
	@Then("Verify the message content")
	public void verifyTheSuccess()
	{
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
	
}
