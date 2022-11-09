package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC004_UpdateIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Update an Incident (REST)";
		testDescription = "Update an Incident and Verify";
		nodes = "Incident";
		authors = "Ramesh";
		category = "REST";
		//dataProvider
		dataFileName = "TC004";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData", dependsOnMethods = "tests.rest.TC001_CreateIncident.createIncident")
    public void updateIncident(File file) {        
                
        Response response = putWithBodyParam(file, "incident/"+sysID);
        response.prettyPrint();
        verifyContentType(response, "application/json");
        
        verifyResponseCode(response, 200);
        
        
        verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia updated");
        sysID = getContentWithKey(response, "result.sys_id");
    }
}




















