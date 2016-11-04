package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	String xpath[][] = { 
			{"Continue Shopping", ".//*[@id='summary-container']/div[3]/a"},
			{"Checkout",".//*[@id='formCart']/div[1]/button[2]"},
			{"PayPal", ".//*[@id='formCart']/div[1]/button[1]"}
	};
	public Cart() {
		
	}
	
	public void getItens(){
		
	}
	
	public void verifyPage(WebDriver driver){
		Page page = new Page(xpath);
		page.verifyComponent(driver);
	}
	
	public float getTotalPrice(WebDriver driver){
		int i = 1;
		float total = 0;
		WebElement name, price;
		
		do{
			try {
				name = driver.findElement(By.xpath(".//*[@id='cart-products']/tbody/tr["+i+"]/td[2]/a"));
				price = driver.findElement(By.xpath(".//*[@id='cart-products']/tbody/tr["+i+"]/td[5]/span"));
				total += Float.parseFloat(price.getAttribute("data-price").replaceAll(",","."));
				i++;
			} catch (Exception e) {
				break;
			}
		}while(true);
		
		return total;
	}

}
