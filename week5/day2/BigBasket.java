package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException {

		//create a object for ChromeDriver to launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//load the URL
		driver.get("https://www.bigbasket.com/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//wait for to load the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click Shop By Category option
		driver.findElement(By.xpath("(//span[text()='Shop by'])[2]")).click();
		
		Thread.sleep(4000);
		
		//Locate and Mouse Hover to "Foodgrains, Oil & Masala".
		WebElement findOption = driver.findElement(By.xpath("(//a[contains(text(),'Foodgrains, Oil & Masala')])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(findOption).perform();
		
		//wait for 3 seconds
		Thread.sleep(3000);
		
		//Locate and Mouse Hover To Rice and Rice Products
		WebElement findRiceProducts = driver.findElement(By.xpath("//a[contains(text(),'Rice Products')]"));
		act.moveToElement(findRiceProducts).perform();
		
		//click boiled and steam rice
		driver.findElement(By.xpath("//a[contains(text(),'Boiled')]")).click();
		
		//wait for sometime
		Thread.sleep(5000);
		
		//Scroll and Click The "BB Royal" brand
		WebElement findBBRoyal = driver.findElement(By.id("i-bbRoyal"));
		act.scrollToElement(findBBRoyal).perform();
		Thread.sleep(5000);
		act.doubleClick(findBBRoyal).perform();
		
		Thread.sleep(3000);
		
		//Click on "Tamil Ponni Boiled Rice"
		driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled - Rice']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> allWindows = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(allWindows.get(1));
		
		Thread.sleep(3000);
		
		//Select the 5 Kg bag.
		WebElement findFiveKG = driver.findElement(By.xpath("//div[@class='w-full']//span[text()='5 kg']"));
		act.moveToElement(findFiveKG).perform();
		Thread.sleep(3000);
		act.doubleClick(findFiveKG).perform();
		
		
		WebElement getAmountDetails = driver.findElement(By.xpath("//div[contains(@class,'StickyPdDetail')]"));
		String ricePrice = getAmountDetails.getText();
		ricePrice = ricePrice.replaceAll("[^0-9]", "");
		System.out.println("Rice Price is : "+ricePrice);
		
		//Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		
		//Verify the success message that confirms the item was added to your cart.
		WebElement getMessage = driver.findElement(By.xpath("//p[contains(text(),'successfully')]"));
		if (getMessage.isDisplayed()) {
			String messageContent = getMessage.getText();
			System.out.println(messageContent);
		} else {
			System.out.println("Your Item Is Not Added In The Cart");
		}
		
		//Close the current window
		driver.close();
		
		//Swith to main window
		driver.switchTo().window(allWindows.get(0));
		
		//Close the main window
		driver.close();
		
		
		
	}

}
