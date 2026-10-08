
package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Homepage {

    WebDriver driver;

    By product = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    
    By sort=By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    
    By cart1=By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By cart2 = By.id("add-to-cart-sauce-labs-bike-light");
    By cart3=By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    By cart4=By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
    By cart5=By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");
    By cart6=By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
    
   By carticon =By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    

    public Homepage(WebDriver driver) {

        this.driver = driver;

        
    }

    public String text() {

        return driver.findElement(product).getText();
    } 
     
    public void sortLowToHigh() {

        WebElement element = driver.findElement(sort);
 
        Select s = new Select(element);

        s.selectByVisibleText("Price (low to high)");
    }
    public void addtoCart() {
        driver.findElement(cart1).click();
        driver.findElement(cart2).click();
        driver.findElement(cart3).click();
        driver.findElement(cart4).click();
        driver.findElement(cart5).click();
        driver.findElement(cart6).click();
    }
    public void cartIconClick()
    {
    	driver.findElement(carticon).click();
    }
     
}