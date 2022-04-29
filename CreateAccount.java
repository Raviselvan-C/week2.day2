package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Account')]")).click();
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Thara Local");
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Worst Site");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("1000");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		driver.close();
	}

}
