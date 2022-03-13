package week5.ServiceNow;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.seleniumProject.ExternalUtil;
import com.seleniumProject.UtilFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClassServiceNow extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public String url = "https://dev58620.service-now.com/";
	public String fileName,  sheetName;
	
	public static Map<String, String> keyVal = new LinkedHashMap<>();
	public static List<String> Titles = new ArrayList<>();
	public static List<List<String>> dataTable = new ArrayList<>();
	public static List<String> rowVals = new ArrayList<>();
	
	@BeforeMethod(alwaysRun=true)
	public void setUpDriver() {
		UtilFiles util = new UtilFiles();
		driver = util.setUpDriver("chrome");
		util.maximize(driver);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		// 2. Enter UserName and Password Using Id Locator
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Mother@3090");

		// 3. Click on Login Button using ID Locator
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();

	}

	@DataProvider(name = "CreateNUpdate")
	public String[][] readFromExcel() throws IOException {
		return ExternalUtil.readFromExcel(fileName, sheetName);
	}
	
	

	@BeforeClass
	public void setData() {
		fileName = "ServiceNow";
		sheetName = "UpdateOnly";
		
	}

	public List<List<String>> writeToList(Map<String, String> val) {
		List<List<String>> dataList = new ArrayList<>();
		
		
		List<String> keySet = new ArrayList<>(val.keySet());
		List<String> valSet = new ArrayList<>(val.values());
		
		dataList.add(keySet);
		dataList.add(valSet);
		

		return dataList;
	}
	
	
	
	
	
	public void updateMtd() {
		dataTable.add(Titles);
		String writeStatus;
		/*
		 * try { //writeStatus = ExternalUtil.updateExcel(writeToList(keyVal), fileName,
		 * sheetName); writeStatus = ExternalUtil.updateExcel(dataTable, fileName,
		 * sheetName); System.out.println(writeStatus);
		 * Assert.assertTrue(writeStatus.equalsIgnoreCase("Success")); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		rowVals.forEach(inVal -> {
			System.out.println(inVal);
		});
	}

}
