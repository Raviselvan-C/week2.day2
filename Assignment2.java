package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//---------------------------EDIT PAGE-----------------------------------------------
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ravi.ulagu@gmail.com");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("text inserted");
		String text = driver.findElement(By.xpath("(//input[@name='username'])[1]")).getAttribute("value");
		System.out.println("Text box value - "+text);
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		boolean webElementEnabled = driver.findElement(By.xpath("(//input[@type='text'])[5]")).isEnabled();
		System.out.println("is textbox enabled? ans - "+webElementEnabled);
		
		//---------------------------BUTTON PAGE-----------------------------------------------
		driver.get("http://leafground.com/pages/Button.html");
		driver.findElement(By.xpath("//button[contains(text(),'Home Page')]")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'Button')]")).click();
		Object Location = driver.findElement(By.xpath("//button[contains(text(),'Get Position')]")).getLocation();
		String Color = driver.findElement(By.xpath("//button[contains(text(),'color')]")).getCssValue("background-color");
		Object size = driver.findElement(By.xpath("//button[contains(text(),'my size')]")).getSize();
		System.out.println("Location of button is "+Location);
		System.out.println("Colour of button is "+Color);
		System.out.println("Size of button is "+ size);
		
		//---------------------------LINK PAGE-----------------------------------------------
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.xpath("(//a[contains(text(),'Home Page')])[1]")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'HyperLink')]")).click();
		String URL = driver.findElement(By.xpath("//a[contains(text(),'where am supposed')]")).getAttribute("href");
		System.out.println("2nd Link in HyperLink page will got to:"+URL);
		driver.findElement(By.xpath("(//a[contains(text(),'Home Page')])[2]")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'HyperLink')]")).click();
		String checkURL = driver.findElement(By.xpath("//a[contains(text(),'broken')]")).getAttribute("href");
		if(checkURL.contains("error")) {
			System.out.println("URL is broken");
		}
		else {
			System.out.println("URL is good");
		}
		
		List<WebElement> link = driver.findElements(By.tagName("a"));
		int noOfLinks = link.size();
		System.out.println("Number of Links : "+noOfLinks );
		
		
		//---------------------------IMAGE PAGE-----------------------------------------------
		driver.get("http://leafground.com/pages/Image.html");
		driver.findElement(By.xpath("(//label[contains(text(),'Click on this')]//following::img)[1]")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'Image')]")).click();
		boolean visible = driver.findElement(By.xpath("(//label[contains(text(),'Click on this')]//following::img)[2]")).isDisplayed();
		System.out.println("is the image broken? ans - "+visible);
		WebElement mouseClickImage = driver.findElement(By.xpath("(//label[contains(text(),'Click on this')]//following::img)[3]"));
		Actions clickImage = new Actions(driver);
		clickImage.clickAndHold(mouseClickImage).build().perform();
		
		//---------------------------Checkboxes PAGE-----------------------------------------------
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		boolean isSelected = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).isSelected();
		System.out.println("CheckBox already checked? ans - "+isSelected);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int size1 = checkBox.size();
		for(int i=8; i<size1; i++) {
			checkBox.get(i).click();
		}
		
	}

}
