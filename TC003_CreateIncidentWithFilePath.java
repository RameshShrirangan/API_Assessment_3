package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC003_CreateIncidentWithFilePath extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new Incident (REST)";
		testDescription = "Create a new Incident and Verify";
		nodes = "Incident";
		authors = "Ramesh";
		category = "REST";
		//dataProvider
		//dataFileName = "TC001";
		//dataFileType = "JSON";
	}

	@Test()
	public void createIncident() {		
				
		File filePath=new File("./data/TC001.json");
		Response response = postWithBodyAsFilePathAndUrl(filePath, "incident");
		response.prettyPrint();
		verifyContentType(response, "application/json");
		
		verifyResponseCode(response, 201);
		verifyResponseTime(response, 4000);
		
		
		verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia");
		sysID = getContentWithKey(response, "result.sys_id");
	}


}




















