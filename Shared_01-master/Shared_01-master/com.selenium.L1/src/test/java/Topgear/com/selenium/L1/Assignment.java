/*
 * 
 * Author: Rahul S
 * Emp Id: RA20081501
 * Last Modified: 08/06/2020
 * 
 * Topic: Topgear Selenium Hands-on
 * 
 * Features used: Selenium, Data driven(Excel), Maven-TestNG framework
 * 
 * 
 */

package Topgear.com.selenium.L1;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configuration.PropertiesFile;
import Utils.ExcelUtils;
import Utils.FilesUtils;

public class Assignment {

	WebDriver driver = null;
	String browserName = null;
	static ExcelUtils excel;
	static FilesUtils file;
	static String projectPath = System.getProperty("user.dir");
	static String excelPath = "/excel/testdata.xlsx";
	static String sheetName = "Sheet1";

	@BeforeMethod
	void setUpMethod() {

		System.out.println(projectPath);

		browserName = PropertiesFile.getProperties("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/Resources/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/Resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		excel = new ExcelUtils(projectPath + excelPath, sheetName);

	}

	@Test
	void test1() {

		// excel = new ExcelUtils();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();

		System.out.println(ExcelUtils.getCellDataString(1, 0));
		driver.findElement(By.id("input-email")).sendKeys(ExcelUtils.getCellDataString(1, 0));
		driver.findElement(By.name("password")).sendKeys(ExcelUtils.getCellDataString(1, 1));

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		// driver.findElement(By.xpath("")).click();
		// driver.findElement(By.xpath("")).click();
		// driver.findElement(By.xpath("")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test2() {

		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();

		// loginData
		System.out.println(ExcelUtils.getCellDataString(1, 0));
		driver.findElement(By.id("input-email")).sendKeys(ExcelUtils.getCellDataString(1, 0));
		driver.findElement(By.name("password")).sendKeys(ExcelUtils.getCellDataString(1, 1));

		// login
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

		driver.findElement(By.linkText("Components")).click();
		driver.findElement(By.linkText("Monitors (2)")).click();
		// Thread.sleep(2000);
		driver.findElement(By.linkText("Phones & PDAs (3)")).click();
		Select drp = new Select(driver.findElement(By.id("input-sort")));
		drp.selectByVisibleText("Price (High > Low)");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[3]")).click();
		// Thread.sleep(3000); //js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[3]")).click();
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/div[2]/button[3]")).click();
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[1]/td[2]/a/strong")).click();

		// File

		file = new FilesUtils(projectPath + "/text.txt");
		WebElement w = driver.findElement(By.xpath("//*[@id=\"tab-description\"]/ul/li[5]"));
		System.out.println(w.getText());
		FilesUtils.writeString(w.getText());
		FilesUtils.readString();
		FilesUtils.closeFile();

	

		driver.findElement(By.xpath("//*[@id=\'button-cart\']")).click();
		driver.findElement(By.linkText("shopping cart")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Order History")).click();
		driver.findElement(By.linkText("Newsletter")).click();

		// logout
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		// driver.findElement(By.xpath("")).click();
		// driver.findElement(By.xpath("")).click();
		// driver.findElement(By.xpath("")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test3() {
		// excel = new ExcelUtils(projectPath + "/excel/testdata.xlsx", "Sheet1");
		// JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		System.out.println(ExcelUtils.getCellDataString(1, 0));
		driver.findElement(By.id("input-email")).sendKeys(ExcelUtils.getCellDataString(1, 0));
		driver.findElement(By.name("password")).sendKeys(ExcelUtils.getCellDataString(1, 1));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Canon");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();

	}

	@AfterMethod
	void tearDownMethod() {
		driver.close();
		// driver.quit();
	}

}
