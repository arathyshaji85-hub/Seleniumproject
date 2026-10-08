
package testpkg;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import Page.Homepage;

public class Homepage extends Baseclass {

    @Test//(dependsOnMethods="LoginPage")
    public void test1() {

		Homepage home=new Homepage(driver); 
 
        String actualtext = home.text();

        String expected = "Products"; 

        Assert.assertEquals(actualtext, expected, "Text mismatch");
        System.out.println("Text verifyed");
        WebDriverWait wait =new  WebDriverWait(driver,Duration.ofSeconds(20));
       wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/inventory.html"));
      
    }
    
    @Test
    public void test2() {

        home.sortLowToHigh();
    }
    @Test
    public void test3() {

        home.addtoCart(); 
    }
    @Test
    public void test4()
    {
    	home.cartIconClick();
    }
}