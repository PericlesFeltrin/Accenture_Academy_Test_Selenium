package Test;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class main {
	public static void main(String[] args) {		
		// Chrome
		System.setProperty("webdriver.chrome.driver", "/Users/periclesfeltrin/Desktop/Accenture/drivers/chromedriver");
		WebDriver driver;

		// Firefox
		//System.setProperty("webdriver.gecko.driver", "/Users/periclesfeltrin/Desktop/Accenture/drivers/geckodriver");
		//WebDriver driver = new FirefoxDriver();

		// Opera
		//System.setProperty("webdriver.opera.driver", "/Users/periclesfeltrin/Desktop/Accenture/drivers/operadriver");
		//WebDriver driver = new OperaDriver();
		
		Test test = new Test();

		//Keywords list to search products
		ArrayList<String> keywordsProduct = new ArrayList<String>();
		keywordsProduct.addAll(Arrays.asList("Xiaomi", "Iphone"));
		
		driver = new ChromeDriver();
		test.cart(driver, keywordsProduct);

		keywordsProduct.addAll(Arrays.asList("Motorola", "Arduino"));
		driver = new ChromeDriver();
		test.wishList(driver, keywordsProduct);
			
	}
}