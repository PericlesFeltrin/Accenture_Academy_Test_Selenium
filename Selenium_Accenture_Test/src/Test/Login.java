package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	String username, password;
	
	//Name Component, xpath
	String xpath_login[][] = {
			{"Email", ".//*[@id='email']"},
			{"Password", ".//*[@id='password']"},
			{"Sign In", ".//*[@id='login_btn']"}
	};
	
	//Name Component, xpath
	String xpath_login_car[][] = {
			{"Email", ".//*[@id='dx-l-email']"},
			{"Password", ".//*[@id='dx-l-password']"},
			{"Sign In", ".//*[@id='dx-login-submit']"}
	};

	public Login() {
	
	}
	
	public Login(String user, String pass) {
		username = user;
		password = pass;
	}
	
	private void signIn(WebDriver driver){
		Log log = new Log();
		Page vp;
		if (driver.getTitle().equals("DX Account Login")) {
			log.setNewLog("Login.signIn", "Open Page, title is: " + driver.getTitle());
			vp = new Page(xpath_login);			
		}else{
			log.setNewLog("Login.signIn", "Open Page, title is: " + driver.getTitle());
			vp = new Page(xpath_login_car);		
		}
		vp.verifyComponent(driver);
		log.setNewLog("Login.signIn", "Login...");
		driver.findElement(By.xpath(vp.getXpath("Email"))).sendKeys(username);
		driver.findElement(By.xpath(vp.getXpath("Password"))).sendKeys(password);
		driver.findElement(By.xpath(vp.getXpath("Sign In"))).submit();
		log.setNewLog("Login.signIn", "Username: "+username+" Password: "+password);
	}
	
	public void setSignIn(WebDriver driver){
		signIn(driver);
	}
	
	public void setSignIn(WebDriver driver, String user, String pass){
		username = user;
		password = pass;
		signIn(driver);
	}

	public boolean verifyLogin(WebDriver driver){
		Log log = new Log();
		
		if (driver.getTitle().equals("DX Account Login")) {
			try {
				if (driver.findElement(By.xpath(".//*[@id='login_check_code']/img")).isEnabled()){
					log.setNewLog("Login.verifyLogin", "Login Failed!");
					return false;
				}
			} catch (Exception e) {
				log.setNewLog("Login.verifyLogin", "Login Success!");
				driver.findElement(By.xpath("//*[@id='Countdown']")).click();
				return true;
			}
		}else{
			try {
				if(driver.findElement(By.xpath(".//*[@id='login-error']/i")).isEnabled()){
					log.setNewLog("Login.verifyLogin", "Login Failed!");
					return false;
				}
			} catch (Exception e) {
				log.setNewLog("Login.verifyLogin", "Login Success!");
				return true;
			}
		}	
		
		return false;
	}
	
}
