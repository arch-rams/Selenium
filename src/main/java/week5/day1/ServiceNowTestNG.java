package week5.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumProject.ExternalUtil;

public class ServiceNowTestNG extends BaseClassServiceNow {

	//public WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	ServiceNow snow = new ServiceNow();
	
	
	
	public static List<String> keyList = new ArrayList<>();
	

	@Test(dataProvider = "CreateNUpdate")
	public void createNewIncident(String entryNo, String incNum, String Caller, String ShortDesc, String State, String Urgency,
			String AssignTo, String Status) {
		// create New Incident
		snow.searchFilter(driver, "Incident", "Create New");
		String inc = snow.enterIncidentDetails(driver, ShortDesc, Caller);

		// Add incident Num to List
		System.out.println("The key is:  " +entryNo);
		//keyVal.put("entryNo", entryNo);
		//keyVal.put("IncidentNo", inc);
		
		//Verify number is created and add to excel file
		Assert.assertEquals(snow.userSearch(driver, "number", inc), inc);
		//keyVal.put("Status", "Created");
		rowVals.addAll(Arrays.asList(entryNo, inc, "Created"));
		
	}

	//@Test(dataProvider = "CreateNUpdate")
	public void updateIncident(String incNum, String Caller, String ShortDesc, String State, String Urgency,
			String AssignTo, String Status) {
		snow.userSearch(driver, "number", incNum);
		snow.updateInc(driver, incNum, State, Urgency, AssignTo);

	}

}
