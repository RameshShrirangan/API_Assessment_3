package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC005_DeleteIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Dlete an Incident (REST)";
		testDescription = "Delete an Incident and Verify";
		nodes = "Incident";
		authors = "Ramesh";
		category = "REST";
		//dataProvider
		//dataFileName = "TC001";
		//dataFileType = "JSON";
	}

	@Test(dependsOnMethods = "tests.rest.TC004_UpdateIncident.updateIncident")
	public void deleteIncident() {		
				
		Response response = delete("incident/"+sysID);
        response.prettyPrint();
        //verifyContentType(response, "application/json");
        
        verifyResponseCode(response, 204);
        if(response.statusCode() == 204) {
            System.out.println("Testcase has been PASS");
        }else {
            System.out.println("Fail");
        }
        
        
	}



}







