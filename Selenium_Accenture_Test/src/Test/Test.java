package Test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test {

	public Test() {

	}

	public void cart(WebDriver driver, ArrayList<String> keywordProduct) {

		ArrayList<String> tabs = new ArrayList<String>();
		Log log = new Log();
		log.setNewLog("Test.Cart", "Start Test in Dx.com");
		driver.get("http://www.dx.com/");
		driver.manage().window().maximize();

		log.screenshot(driver);
		
		log.setNewLog("Test.cart", "Open Page: " + driver.getTitle());
		log.setNewLog("Test.cart", "Start Verify Page Component");
		Page page = new Page();
		page.verifyComponent(driver);
		driver.findElement(By.xpath(page.getXpath("Login"))).click();
		log.setNewLog("Test.cart", "Open Page: " + driver.getTitle());

		// driver.findElement(By.xpath(page.getXpath("Cart"))).click();
		// driver.findElement(By.xpath(page.getXpath(".//*[@id='cart-login']"))).click();
		
		Login login = new Login("jogol@bol.com.br", "teste123-");
		login.setSignIn(driver);
		if (!login.verifyLogin(driver)) {
			log.setNewLog("Test.cart", "Error Login. Close test.");
			return;
		}
		page.verifyComponent(driver);

		Product product = new Product();

		ArrayList<String> nameProduct = new ArrayList<String>();
		ArrayList<Float> priceProduct = new ArrayList<Float>();
		float totalPrice = 0;
		for (int i = 0; i < keywordProduct.size(); i++) {
			product.setSearchProduct(driver, keywordProduct.get(i));
			log.screenshot(driver);
			product.openProduct(driver);
			log.screenshot(driver);
			log.setNewLog("Test.cart", "Switch page");

			tabs.clear();
			tabs.addAll(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			log.setNewLog("Test.cart", "Close Page: " + driver.getTitle());
			driver.close();
			driver.switchTo().window(tabs.get(1));

			log.setNewLog("Test.cart", "Open Page: " + driver.getTitle());
			product.getDescription(driver);
			product.addCart(driver);
			if (!page.verifyComponent(driver, ".//*[@id='detailAddToCartPanel']/div/div/span", "Error add product")) {
				nameProduct.add(product.getDescription(driver));
				priceProduct.add(product.getPrice(driver));
				totalPrice += priceProduct.get(priceProduct.size() - 1);
			} else {
				log.setNewLog("Test.cart", "Error add product to cart: " + product.getDescription(driver));
			}
		}

		driver.findElement(By.xpath(page.getXpath("Cart"))).click();
		log.setNewLog("Test.cart", "Open Page: " + driver.getTitle());
		log.screenshot(driver);

		Cart cart = new Cart();
		cart.verifyPage(driver);
		if (totalPrice == cart.getTotalPrice(driver)) {
			log.setNewLog("Test.cart", "Cart price total OK. " + totalPrice + " = " + cart.getTotalPrice(driver));
		} else {
			log.setNewLog("Test.cart",
					"ERROR Cart price total Fail." + totalPrice + " <> " + cart.getTotalPrice(driver));
		}
		driver.quit();
	}

	public void wishList(WebDriver driver, ArrayList<String> keywordProduct) {

		ArrayList<String> tabs = new ArrayList<String>();
		Log log = new Log();
		log.setNewLog("Test.wishList", "Start Test in Dx.com");
		driver.get("http://www.dx.com/");
		driver.manage().window().maximize();

		log.setNewLog("Test.wishList", "Open Page: " + driver.getTitle());
		log.setNewLog("Test.wishList", "Start Verify Page Component");
		Page page = new Page();
		page.verifyComponent(driver);
		driver.findElement(By.xpath(page.getXpath("Login"))).click();
		log.setNewLog("Test.wishList", "Open Page: " + driver.getTitle());

		Login login = new Login("jogol@bol.com.br", "teste123-");
		login.setSignIn(driver);
		if (!login.verifyLogin(driver)) {
			log.setNewLog("Test.wishList", "Error Login. Close test.");
			return;
		}

		page.verifyComponent(driver);

		Product product = new Product();

		ArrayList<String> nameProduct = new ArrayList<String>();
		float totalPrice = 0;
		for (int i = 0; i < keywordProduct.size(); i++) {
			product.setSearchProduct(driver, keywordProduct.get(i));
			product.openProduct(driver);
			log.setNewLog("Test.wishList", "Switch page");

			tabs.clear();
			tabs.addAll(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			log.setNewLog("Test.wishList", "Close Page: " + driver.getTitle());
			driver.close();
			driver.switchTo().window(tabs.get(1));

			log.setNewLog("Test.wishList", "Open Page: " + driver.getTitle());
			product.getDescription(driver);
			product.addList(driver);
			nameProduct.add(product.getDescription(driver));
		}

		
		driver.get("https://my.dx.com/Wishlist/Index");
		log.setNewLog("Test.wishList", "Open Page: " + driver.getTitle());

		ArrayList<String> listItens = product.getWishList(driver);
		for (int i = 0; i < nameProduct.size(); i++) {
			if (!listItens.contains(nameProduct.get(i))) {
				log.setNewLog("Test.wishList", nameProduct.get(i) + " not in list FAIL");
			}else{
				log.setNewLog("Test.wishList", nameProduct.get(i) + " in list OK");
			}
		}
		
		driver.quit();
	}

}
