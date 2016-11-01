package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuscaCEP {

	// Name Component, xpath
	String xpath[][] = {
			{ "Title",
					"/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/h3" },
			{ "Endereço ou CEP", "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div/div/span[2]/label/input"},
			{ "CEP de",
					"/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div/div/span[3]/label/select" },
			{"Buscar", "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div/div/div[6]/input"}};

	
	public BuscaCEP() {
	
	}

	public void verifyComponent(WebDriver driver) {
		System.out.println("Location: "+driver.findElement(By.xpath(xpath[0][1])).getText());
		for (int i = 0; i < xpath.length; i++) {
			if (!driver.findElement(By.xpath(xpath[i][1])).isEnabled()) {
				System.out.println("Component " + xpath[i][0] + ": FAIL!");

			} else {
				System.out.println("Component " + xpath[i][0] + ": OK!");
			}
		}

	}

	public void setBuscaCEP(WebDriver driver) {
		driver.findElement(By.xpath(xpath[1][1])).sendKeys("51021310");
		driver.findElement(By.xpath(xpath[2][1])).sendKeys("Total");;
	}
	
	public void search(WebDriver driver){
		driver.findElement(By.xpath(xpath[2][1])).submit();
	}
	
	public void verifySearch(WebDriver driver){
	}
}
