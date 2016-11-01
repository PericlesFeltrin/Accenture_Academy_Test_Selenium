package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class VerifyPage {

	//Name Component, xpath
	String xpath[][] = {
			{ "Preços e Prazos", "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/ul/li[3]/a/img" },
			{ "Envio", "/html/body/div[2]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/ul/li[1]/div[1]/a" }
			};
	
	public VerifyPage() {

	}

	public void homePage(WebDriver driver){		
		for (int i = 0; i < xpath.length; i++) {
			if (!driver.findElement(By.xpath(xpath[i][1])).isEnabled()) {
				System.out.println("Component "+xpath[i][0]+": FAIL!");

			}else{
				System.out.println("Component "+xpath[i][0]+": OK!");
			}
		}

	}
}
