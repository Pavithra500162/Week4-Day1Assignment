package week4.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateOpportunitywithoutmandatoryfields {
	@Test
	public void createoppman() throws InterruptedException {
		ChromeOptions opt=new ChromeOptions(); 
		opt.addArguments("--disable-notifications"); 
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("(//p[@class='slds-truncate'])[2]")).click();
		WebElement opp=driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		driver.executeScript("arguments[0].click();",opp);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("Salsesforce Automation by Pavithra Shanmugam");
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("8/8/2023");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		String s1=driver.findElement(By.xpath("//h2[@title='We hit a snag.']")).getText();
		System.out.println(s1);
		driver.close();
	}
}
