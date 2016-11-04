package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

	// Name Component, xpath
	String xpath[][] = { { "Txt Keyword", ".//*[@id='txtKeyword']" }, { "Search", ".//*[@id='btnSearch']" },
			{ "Login", ".//*[@id='redirectToLogin']" }, { "Register", ".//*[@id='redirectToRegister']" },
			{ "Cart", ".//*[@id='miniCart']/a" }, { "Username", "html/body/div[2]/div/div[2]/ul/li[1]/a[1]" },
			{ "Logout", "html/body/div[2]/div/div[2]/ul/li[1]/a[3]" }};
	public Page() {

	}

	public Page(String new_xpath[][]) {
		xpath = new_xpath;
	}

	public void verifyComponent(WebDriver driver) {
		Log log = new Log();
		log.setNewLog("Page.verifyComponent", "Verify Page: " + driver.getTitle());
		for (int i = 0; i < xpath.length; i++) {
			try {
				if (driver.findElement(By.xpath(xpath[i][1])).isEnabled()) {
					log.setNewLog("Page.verifyComponent", "Component " + xpath[i][0] + ": OK!");
				}
			} catch (Exception e) {
				log.setNewLog("Page.verifyComponent", "Component " + xpath[i][0] + ": FAIL!");
			}
		}

	}

	public boolean verifyComponent(WebDriver driver, String xpath, String alias) {
		Log log = new Log();
		log.setNewLog("Page.verifyComponent", "Verify Page, Component: " + driver.getTitle());
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			if (element.isEnabled()) {
				log.setNewLog("Page.verifyComponent", "XPATH: " + xpath + " Component: " + alias + " / " + element.getText() + ": OK!");
				return true;
			}
		} catch (Exception e) {
			log.setNewLog("Page.verifyComponent", "XPATh: " + xpath + " Component: " + alias + ": FAIL!");
			return false;
		}
		return false;
	}

	public String getXpath(String nameComponent) {
		for (int i = 0; i < xpath.length; i++) {
			if (xpath[i][0].equals(nameComponent)) {
				return xpath[i][1];
			}
		}
		return nameComponent;
	}
}