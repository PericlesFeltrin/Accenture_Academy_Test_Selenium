package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {

	public Cart() {
		
	}
	
	public void getItens(){
		
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
