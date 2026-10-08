
package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
	
	WebDriver driver;
	By usernamefield=By.id("user-name");
	By passwordfield=By.id("password");
	By loginbutton=By.id("login-button");
	
	public loginpage(WebDriver driver)
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
