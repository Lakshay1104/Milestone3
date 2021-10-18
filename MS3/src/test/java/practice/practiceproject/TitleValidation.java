package practice.practiceproject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LiquidPage;
import utilities.base;

public class TitleValidation extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void BeforeTest() throws IOException { 
		driver = InitializeDriver();                              //Initializing the driver
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));                      //Opening the url 
	}
	
	@Test
	public void ValidateTitle() throws IOException, InterruptedException {
		
		HomePage h= new HomePage(driver);
		h.getPGEveryday().click();                                //Click on “P&G Everyday”
		Set<String>ids=driver.getWindowHandles();
		Iterator<String>its=ids.iterator();
		String parent = its.next();
		String child = its.next();
		driver.switchTo().window(child);                          //Switch to child tab
		
		Assert.assertTrue(driver.getTitle().contains("P&GGoodEveryday")); //Verify if the title of the new page contains “P&GGoodEveryday”
		log.info("Title Verified!");                                //log the results
		 
}
	@AfterTest
	public void AfterTest() {

		 driver.quit();
		 driver=null;
	}
}
