package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrecoPrazosTest {

	// Name Component, xpath
	String xpath[][] = {
			{ "Data Postagem", "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div/div/span[1]/label/input[1]"},
			{ "CEP Origem",
					"/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div/div/span[3]/label/input" },
			{ "CEP Destino",
					"/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div/div/span[5]/label/input" },
			{ "Tipo de Serviço",
					"/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div/div/span[7]/label/select" },
			{"Submit Query", "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div/div/div[8]/input"}};

	public PrecoPrazosTest() {

	}

	public void verifyComponent(WebDriver driver) {
		for (int i = 0; i < xpath.length; i++) {
			if (!driver.findElement(By.xpath(xpath[i][1])).isEnabled()) {
				System.out.println("Component " + xpath[i][0] + ": FAIL!");

			} else {
				System.out.println("Component " + xpath[i][0] + ": OK!");
			}
		}

	}

	public void setPrecoPrazo() {

	}

}
