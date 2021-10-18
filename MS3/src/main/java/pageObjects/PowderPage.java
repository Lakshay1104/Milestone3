package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PowderPage {
WebDriver driver;
	
	public PowderPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By heading = By.cssSelector(".plp-title-bar > h1:nth-child(1) > p:nth-child(1)");
	
	public WebElement getHeading() {
		return driver.findElement(heading);
		
	}
}
