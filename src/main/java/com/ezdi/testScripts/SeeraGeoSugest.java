package com.ezdi.testScripts;

import org.apache.http.params.BasicHttpParams;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ezdi.library.MyBaseTest;
import com.ezdi.library.Utils;

import enums.RequestType;
import library.Logging;
import library.catAPILib.TheCat;

public class SeeraGeoSugest  extends MyBaseTest {
	
	
	SeeraGeoSugest() {
		xlops.setXLParamFileAndSheet("testData.xlsx", this.getClass().getSimpleName());
	}

	private final String fullURL = MyBaseTest.seeraBaseURL + "geo-suggest";
	private final String idIdentifierForDelete = "id";

	@Test(dataProvider = "dataProvider")
	public void getGeoSuggestions(String testMethodName, String user, String testCaseId) throws Throwable {

		try {
			Utils utils = new Utils(RequestType.GET, fullURL + "?query=paris", getUserTypeByEnumID(user), this.xlops);
			utils.httpRequest.buildAndExecute();
			/*
			 * Logging.log.info("Response for " + testMethodName + ": " +
			 * utils.httpRequest.getResponseBody()); Logging.log.info("Response Code: " +
			 * utils.httpRequest.getStatusCode());
			 */
			
			Assert.assertEquals(utils.httpRequest.getStatusCode(), "200");
			Assert.assertEquals(new JSONObject(utils.httpRequest.getResponseBody()).getJSONArray("hotels").length(), 5);
			JSONAssert.assertEquals(new JSONObject(utils.xlops.getCellValue(testMethodName, "responsePayload", "test_data")), new JSONObject(utils.httpRequest.getResponseBody()), JSONCompareMode.NON_EXTENSIBLE);
		} catch (Exception e) {
			Logging.log.info("Error in TestMethod " + testMethodName + " " + MyBaseTest.getStaktrace(e));
			Assert.fail();
		}

	}

}
