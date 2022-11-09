package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC002_GetIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new Incident (REST)";
		testDescription = "Create a new Incident and Verify";
		nodes = "Incident";
		authors = "Ramesh";
		category = "REST";
	}

	@Test()
	public void getIncident() {		
	
		Response response = get("incident");
		verifyResponseCode(response,200);
		verifyResponseTime(response, 10000);
		//verifyContentsWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia");
	
	}


}




















