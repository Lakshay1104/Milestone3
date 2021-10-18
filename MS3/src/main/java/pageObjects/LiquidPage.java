package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LiquidPage {
WebDriver driver;
	
	public LiquidPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By heading = By.cssSelector(".title > div:nth-child(1)");
	
	public WebElement getHeading() {
		return driver.findElement(heading);
		
	}
}
