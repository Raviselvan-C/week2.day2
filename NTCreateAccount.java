package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NTCreateAccount {
	
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
		Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='currencyUomId']")));
		dropDown.selectByValue("INR");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("NRI Account");
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Thara Local");
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Worst Site");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("1000");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String error = driver.findElement(By.xpath("//li[@class='errorMessage']")).getText();
		System.out.println("The error message is :"+error);
	}

}
