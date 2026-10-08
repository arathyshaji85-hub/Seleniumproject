
package testpkg;

import org.testng.annotations.Test;

import base.Baseclass;
import Page.loginPage;

public class logintest  extends LoginBase {
	
	@Test
	public void test()
	{
		LoginPage lo=new LoginPage(driver);
		lo.setvalues("standard_user", "secret_sauce");
		lo.loginclick();
	}
}