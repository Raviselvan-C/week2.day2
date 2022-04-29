package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAccount {
	
	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Accounts')]")).click();
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys("Credit Limited Account");
		driver.findElement(By.xpath("//button[contains(text(),'Find Accounts')]")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/viewAccount?partyId=accountlimit100']")).click();
		String accoutnName = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		String description = driver.findElement(By.xpath("(//td[@class='tabletext'])[1]")).getText();
		String title = driver.getTitle();
		String Account_Name = "Credit Limited Account (accountlimit100)";
		String pageTitle = "Account Details | opentaps CRM";
		if(accoutnName.equals(Account_Name)) {
			System.out.println("Account Name is correct");
		}
		System.out.println("Description is "+description);
		if(title.equals(pageTitle)) {
			System.out.println("Page Title is correct");
		}
	}

}
