package Test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product {

	//Name Component, xpath
	String xpath[][] = {
			{"Txt Keyword", ".//*[@id='txtKeyword']"},
			{"Search", ".//*[@id='btnSearch']"}
	};
	Log log = new Log();
	
	public Product() {
		
	}
	
	public void setSearchProduct(WebDriver driver, String keyword){
		Page vp = new Page(xpath);
		driver.findElement(By.xpath(vp.getXpath("Txt Keyword"))).clear();
		driver.findElement(By.xpath(vp.getXpath("Txt Keyword"))).sendKeys(keyword);
		driver.findElement(By.xpath(vp.getXpath("Search"))).click();
	}

	public void addCartSearch(WebDriver driver){		
		WebElement element = driver.findElement(By.xpath(".//*[@id='content_ProductList1_rpProducts_hlAddToCart_0']/span"));
		log.setNewLog("Product.addCartSearch", "Add product "+element.getText());
		element.click();
		
		Page vp = new Page();
		if(vp.verifyComponent(driver, ".//*[@id='c_list']/div[3]/p[2]/span/a", "Go to Cart")){
			log.setNewLog("Product.addCartSearch", "Add product success.");
		}
		
		//driver.findElement(By.xpath(".//*[@id='content_ProductList1_rpProducts_hlAddToCart_1']/span")).click();
		
	}
	
	public void addCart(WebDriver driver){		
		WebElement element = driver.findElement(By.xpath(".//*[@id='btn-add-to-cart']"));
		log.setNewLog("Product.addCart", "Add product to cart");
		element.click();
	}
	
	public void addList(WebDriver driver){		
		WebElement element = driver.findElement(By.xpath("html/body/div[4]/div/div[2]/div[1]/div[1]/div[2]/div[2]/a[2]"));
		log.setNewLog("Product.addList", "Add product to list");
		element.click();
	}
		
	public void openProduct(WebDriver driver){		
		WebElement element = driver.findElement(By.xpath(".//*[@id='content_ProductList1_rpProducts_lnkShortHeadLine1_0']"));
		log.setNewLog("Product.openProduct", "Open Product: " + element.getText());
		element.click();
	}
	
	public String getDescription(WebDriver driver){
		WebElement name = driver.findElement(By.xpath(".//*[@id='headline']"));
		log.setNewLog("Product.getDescription", "Name Product: " + name.getText());		
		return name.getText();
	}
	
	public float getPrice(WebDriver driver){
		WebElement elementPrice = driver.findElement(By.xpath(".//*[@id='price']"));
		float lastPrice, price, priceOff=0;
		log.setNewLog("Product.getPrice", "Price: " + elementPrice.getText().replaceAll(",", "."));
		price = Float.parseFloat(elementPrice.getText().replaceAll(",","."));
		try {

			WebElement elementLastPrice = driver.findElement(By.xpath(".//*[@id='list-price']"));
			WebElement elementPriceOff = driver.findElement(By.xpath(".//*[@id='priceOff']/b"));
			log.setNewLog("Product.getPrice", "Last Price: " + elementLastPrice.getText().replaceAll(",",".").replaceAll("R", "").replace("$", ""));
			log.setNewLog("Product.getPrice", "Price Off: " + elementPriceOff.getText() + "%");
			lastPrice = Float.parseFloat(elementLastPrice.getText().replaceAll(",",".").replaceAll("R","").replace("$",""));
			priceOff = Float.parseFloat(elementPriceOff.getText());
			
			priceOff = lastPrice-lastPrice*(priceOff/100);
			if(price > priceOff){
				log.setNewLog("Product.getPrice", "More $" + (price-priceOff));
			}else if(price < priceOff){
				log.setNewLog("Product.getPrice", "Lost $" + (priceOff-price));
			}else{
				log.setNewLog("Product.getPrice", "Price Off OK");
			}
				
		} catch (Exception e) {
		}
		
		return price;		
	}
	
	public ArrayList<String> getWishList(WebDriver driver){
		ArrayList<String> listItens = new ArrayList<>();
		int i = 1;
		WebElement element;
		do{
			try {
				element = driver.findElement(By.xpath("html/body/div[4]/div/div[2]/div/div[3]/div[2]/ul/li["+i+"]/div[2]/p[1]/a"));
				listItens.add(element.getText());
				log.setNewLog("Product.getWishList", "Iten "+i+": "+element.getText());
				i++;				
			} catch (Exception e) {
				break;
			}
		}while(true);
		
		return listItens;
		
	}
}
