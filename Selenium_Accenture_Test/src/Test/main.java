package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/periclesfeltrin/Desktop/Accenture/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://correios.com.br");

		// Check the title of the page
		System.out.println("Open Page, title is: " + driver.getTitle());

		System.out.println("Start Verify Page Component");
		VerifyPage vp = new VerifyPage();
		vp.homePage(driver);

		/*
		 * driver.findElement(By.xpath(vp.xpath[2][1])).click(); BuscaCEP bcep =
		 * new BuscaCEP(); bcep.verifyComponent(driver);
		 * 
		 * //Adicionar lista de dados bcep.setBuscaCEP(driver);
		 * bcep.search(driver); bcep.verifySearch(driver);
		 */

		/*
		 * driver.findElement(By.xpath(vp.xpath[0][1])).click(); PrecoPrazosTest
		 * ppt = new PrecoPrazosTest(); ppt.verifyComponent(driver);
		 */
		
		driver.quit();
	}

}
