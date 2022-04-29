package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomSession {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//Open a chrome browser
		ChromeDriver driver = new ChromeDriver();
		//Load the URL: http://leaftaps.com/opentaps/control/main
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Enter Username as Demosalesmanager
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'companyName')]")).sendKeys("TestCompany1234");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("TestFN");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName'] ")).sendKeys("TestLN");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String text = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(text);
		driver.close();
	}

}
