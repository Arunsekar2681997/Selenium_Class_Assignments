package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		
		//create a object for chromedriver to launch the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//load the URL
		driver.get("https://www.snapdeal.com/");
		
		WebElement findMensFashion = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions act = new Actions(driver);
		act.moveToElement(findMensFashion).perform();
		
		//click sports shoe option
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
		//get and print the count of sport shoes
		WebElement getCount = driver.findElement(By.xpath("//div[contains(text(),'Sports Shoes for Men')]/following-sibling::div[contains(@class,'child-cat-count')]"));
		String getShoesCount = getCount.getText();
		System.out.println("Sports Shoes Counts Are : "+getShoesCount);
		
		//click the sports shoes option
		driver.findElement(By.xpath("//div[contains(@class,'child-cat-count')]/preceding-sibling::div[contains(text(),'Training Shoes')]")).click();
		
		
		//sort the products by "Low to High"
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li)[2]")).click();
		
		Thread.sleep(3000);
		
		//Get the all the amounts from the list of products
		List<WebElement> getAmount = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> amountDetails = new ArrayList();
		
		//Covert the value into integer and store into the list<integer> amount Details
		for (WebElement arrayList : getAmount) {
			String value = arrayList.getText();
			value = value.replaceAll("[^0-9]", "");
			amountDetails.add(Integer.parseInt(value));
		}
		
		System.out.println(amountDetails);
		
		//Check the displayed items are sorted correctly. 
		for (int i = 0; i < amountDetails.size()-1; i++) {
			int a = amountDetails.get(i);
			int b = amountDetails.get(i+1);
			if (a>b) {
				System.out.println("Sorting Is Wrong In The Index "+i+" "+"& The Values Between "+a+" "+"and"+" "+b);
			}
			else if(a==b)
			{
				System.out.println("Sorting Is Correct Between "+a+" "+"and"+" "+b);
			}
			else
			{
				System.out.println("Sorting Is Correct Between "+a+" "+"and"+" "+b);
			}
			
			
		}
		
		
		//Select any price range ex:(593-795).
		WebElement dragRightSide = driver.findElement(By.xpath("//a[contains(@class,'left-handle')]"));
		Thread.sleep(3000);
		act.scrollToElement(dragRightSide).perform();
		Thread.sleep(3000);
		act.dragAndDropBy(dragRightSide, 35, 0).perform();
		Thread.sleep(3000);
		WebElement toValue = driver.findElement(By.xpath("//input[@name='toVal']"));
		act.scrollToElement(toValue).perform();
		toValue.clear();
		toValue.sendKeys("1450");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
		
		//Filter by color
		Thread.sleep(3000);
		WebElement findFilterColor = driver.findElement(By.xpath("//label[contains(@for,'Color')]"));
		act.scrollToElement(findFilterColor).perform();
		Thread.sleep(3000);
		findFilterColor.click();
		
		//verify all the filter
		
		//Mouse hover on the first resulting "Training Shoes"
		WebElement productMouseHover = driver.findElement(By.xpath("//section[contains(@class,'js-section')]/div"));
		act.moveToElement(productMouseHover).perform();
		Thread.sleep(2000);
		
		//Click the "Quick View" button
		driver.findElement(By.xpath("//div[contains(@class,'row-disc')]")).click();
		
		Thread.sleep(2000);
		
		//Print the cost and the discount percentage
		WebElement priceDetails = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String priceAmount = priceDetails.getText();
		System.out.println("Product Amount Is : "+priceAmount);
		WebElement percentDetails = driver.findElement(By.xpath("//span[contains(@class,'percent')]"));
		String percentValue = percentDetails.getText();
		System.out.println("Product Percentage Is : "+percentValue);
		
		//close the current window
		driver.findElement(By.xpath("//div[contains(@class,'close1')]/i")).click();
		
		//close the main window
		driver.quit();
		
		

		
		
	}

}
