package practice.practiceproject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PowderPage;
import utilities.base;

public class HeadingValidation extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void BeforeTest() throws IOException {
		driver = InitializeDriver();                                          //Initializing the driver
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));                                  //Opening the url 
	}
	@Test
	public void ValidateHeading() throws IOException, InterruptedException {
		
		HomePage h= new HomePage(driver);
		 Actions a = new Actions(driver);
		 a.moveToElement(h.getShop()).build().perform();                  //Hover on “Shop Products”
         h.getPowder().click();                                           //Click on "Powder"
         
         PowderPage p = new PowderPage(driver);
         Assert.assertEquals("Shop Tide Powder Detergents", p.getHeading().getText());    //Verify if the heading contains a the text as “Shop Tide Powder Detergents”
         log.info("Heading verified!");                                  //log the results
		
		
}
	@AfterTest
	public void AfterTest() {

		 driver.quit();
		 driver=null;
	}
}
