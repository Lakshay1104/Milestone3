package practice.practiceproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LiquidPage;
import pageObjects.PowderPage;
import utilities.base;

public class SearchValidation extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void BeforeTest() throws IOException {
		driver = InitializeDriver();                               //Initializing the driver
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));                       //Opening the url 
	}
	
	@Test
	public void ValidateSearch() throws IOException, InterruptedException {
		
		HomePage h= new HomePage(driver);
		h.getSearch().sendKeys(h.getProduct());                    //type "liquid" after retrieving from excel sheet
		h.getSearchButton().click();                               //search for it
		
		LiquidPage l= new LiquidPage(driver);
		
		Assert.assertEquals("Search results\n"                    //verify if text is "Search results for "liquid""
				+ "for \"liquid\"", l.getHeading().getText()); 
		log.debug("Text verified!");                               //log the results
		
}
	@AfterTest
	public void AfterTest() {

		 driver.quit();
		 driver=null;
	}
}
