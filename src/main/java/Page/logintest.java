package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class logintest {
	
	
	WebDriver driver;
	By usernamefield=By.id("user-name");
	By passwordfield=By.id("password");
	By loginbutton=By.id("login-button");
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void setvalues(String username,String password) 
	{
		driver.findElement(usernamefield).sendKeys(username);
		driver.findElement(passwordfield).sendKeys(password);
		
	}
	public void loginclick()
	{
		driver.findElement(loginbutton).click();
	}

}
//login page
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import page.Homepage;


public class Baseclass {
	public static WebDriver driver; 
	public static Homepage home ;

	@BeforeTest
	public void setUp()
	{
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		driver=new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		
	}

	@BeforeMethod  
	public  void objects()
{
	    home=new Homepage(driver);
		
	} 
}

