package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By shop = By.cssSelector(".header-main-menu > div:nth-child(1) > a:nth-child(1)");
	By powder = By.cssSelector("div.submenu-child:nth-child(1) > div:nth-child(4) > a:nth-child(1) > span:nth-child(1)");
	By search = By.cssSelector(".input-wrap > input:nth-child(1)");
	By searchButton = By.cssSelector(".input-wrap > button:nth-child(2)");
	By pgeveryday = By.cssSelector(".footer-related-navigation > div:nth-child(5) > a:nth-child(1)");
	public WebElement getShop() {
		return driver.findElement(shop);
		
	}
	
	public WebElement getPowder() {
		return driver.findElement(powder);
		
	}
	
	public WebElement getSearch() {
		return driver.findElement(search);
		
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
		
	}
	
	public WebElement getPGEveryday() {
		return driver.findElement(pgeveryday);
		
	}
	
	public String getProduct() throws IOException {
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis = new FileInputStream(".\\Product.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int count = workbook.getNumberOfSheets();
		for(int i=0;i<count;i++) {
			if(workbook.getSheetName(i).equals("data")) {
				XSSFSheet sheet =workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				Iterator<Cell> c=firstRow.cellIterator();
				while(c.hasNext()) {
				 Cell cell=c.next();
				 a.add(cell.getStringCellValue());
				}
				
			}
		}
		return a.get(0);
	}
	
	
}

