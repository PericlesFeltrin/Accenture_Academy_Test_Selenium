package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {

	public static void main(String[] args) {

		// Optional, if not specified, WebDriver will search your path for
		// chromedriver.
		System.setProperty("webdriver.chrome.driver", "/Users/periclesfeltrin/Desktop/Accenture/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://correios.com.br");

		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());

		VerifyPage vp = new VerifyPage();
		vp.homePage(driver);
		
		driver.findElement(By.xpath(vp.xpath[0][1])).click();
		
		PrecoPrazosTest ppt = new PrecoPrazosTest();
		ppt.verifyComponent(driver);
		
		/*
		 * WebElement searchBox = driver.findElement(By.name("q"));
		 * searchBox.sendKeys("ChromeDriver"); searchBox.submit();
		 */
		driver.quit();
	}

}
