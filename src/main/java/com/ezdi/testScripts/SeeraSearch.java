package com.ezdi.testScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ezdi.library.MyBaseTest;
import com.ezdi.library.Utils;

import enums.RequestType;
import library.Logging;

public class SeeraSearch extends MyBaseTest {

	SeeraSearch() {
		xlops.setXLParamFileAndSheet("testData.xlsx", this.getClass().getSimpleName());
	}

	private final String fullURL = MyBaseTest.seeraBaseURL + "search/request";
	private final String idIdentifierForDelete = "id";

	@Test(dataProvider = "dataProvider")
	public void postSearch2Adults1Child(String testMethodName, String user, String testCaseId) throws Throwable {

		try {
			Utils utils = new Utils(RequestType.POST, fullURL, getUserTypeByEnumID(user), this.xlops);
			UserSearch us = new UserSearch("", "", false, 2, 1, new int[] {3}, "paris");
			utils.httpRequest.setPayLoad(us.requestJSON.toString());
			utils.httpRequest.buildAndExecute();

			
			  Logging.log.info("Response for " + testMethodName + ": " +
			  utils.httpRequest.getResponseBody()); Logging.log.info("Response Code: " +
			  utils.httpRequest.getStatusCode());
			 

			Assert.assertEquals(utils.httpRequest.getStatusCode(), "200");
			JSONAssert.assertEquals(
					new JSONObject(utils.xlops.getCellValue(testMethodName, "responsePayload", "test_data")),
					new JSONObject(utils.httpRequest.getResponseBody()), JSONCompareMode.NON_EXTENSIBLE);

		} catch (Exception e) {
			Logging.log.info("Error in TestMethod " + testMethodName + " " + MyBaseTest.getStaktrace(e));
			Assert.fail();
		}

	}
	
	@Test(dataProvider = "dataProvider")
	public void postSearchPastDates(String testMethodName, String user, String testCaseId) throws Throwable {

		try {
			Utils utils = new Utils(RequestType.POST, fullURL, getUserTypeByEnumID(user), this.xlops);
			UserSearch us = new UserSearch("", "", true, 2, 1, new int[] {3}, "paris");
			utils.httpRequest.setPayLoad(us.requestJSON.toString());
			utils.httpRequest.buildAndExecute();

			
			  Logging.log.info("Response for " + testMethodName + ": " +
			  utils.httpRequest.getResponseBody()); Logging.log.info("Response Code: " +
			  utils.httpRequest.getStatusCode());
			 
			Assert.assertEquals(utils.httpRequest.getStatusCode(), "400");
			
			String expectedJSONString = utils.xlops.getCellValue(testMethodName, "responsePayload", "test_data");
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -1);
			expectedJSONString = expectedJSONString.replace("replaceDate", dateFormat.format(cal.getTime()));
			
			JSONAssert.assertEquals(
					new JSONObject(expectedJSONString),
					new JSONObject(utils.httpRequest.getResponseBody()), JSONCompareMode.NON_EXTENSIBLE);

		} catch (Exception e) {
			Logging.log.info("Error in TestMethod " + testMethodName + " " + MyBaseTest.getStaktrace(e));
			Assert.fail();
		}

	}

	@Test(dataProvider = "dataProvider")
	public void postSearch2AdultsOnly(String testMethodName, String user, String testCaseId) throws Throwable {

		try {
			Utils utils = new Utils(RequestType.POST, fullURL, getUserTypeByEnumID(user), this.xlops);
			UserSearch us = new UserSearch("", "", false, 2, 0, new int[] {}, "paris");
			utils.httpRequest.setPayLoad(us.requestJSON.toString());
			utils.httpRequest.buildAndExecute();

			
			  Logging.log.info("Response for " + testMethodName + ": " +
			  utils.httpRequest.getResponseBody()); Logging.log.info("Response Code: " +
			  utils.httpRequest.getStatusCode());
			 

			Assert.assertEquals(utils.httpRequest.getStatusCode(), "200");
			JSONAssert.assertEquals(
					new JSONObject(utils.xlops.getCellValue(testMethodName, "responsePayload", "test_data")),
					new JSONObject(utils.httpRequest.getResponseBody()), JSONCompareMode.NON_EXTENSIBLE);

		} catch (Exception e) {
			Logging.log.info("Error in TestMethod " + testMethodName + " " + MyBaseTest.getStaktrace(e));
			Assert.fail();
		}

	}
	
	
	@Test(dataProvider = "dataProvider")
	public void postSearch1AdultOnly(String testMethodName, String user, String testCaseId) throws Throwable {

		try {
			Utils utils = new Utils(RequestType.POST, fullURL, getUserTypeByEnumID(user), this.xlops);
			UserSearch us = new UserSearch("", "", false, 1, 0, new int[] {}, "paris");
			utils.httpRequest.setPayLoad(us.requestJSON.toString());
			utils.httpRequest.buildAndExecute();

			
			  Logging.log.info("Response for " + testMethodName + ": " +
			  utils.httpRequest.getResponseBody()); Logging.log.info("Response Code: " +
			  utils.httpRequest.getStatusCode());
			 

			Assert.assertEquals(utils.httpRequest.getStatusCode(), "200");
			JSONAssert.assertEquals(
					new JSONObject(utils.xlops.getCellValue(testMethodName, "responsePayload", "test_data")),
					new JSONObject(utils.httpRequest.getResponseBody()), JSONCompareMode.NON_EXTENSIBLE);

		} catch (Exception e) {
			Logging.log.info("Error in TestMethod " + testMethodName + " " + MyBaseTest.getStaktrace(e));
			Assert.fail();
		}

	}
	
	
	@Test(dataProvider = "dataProvider")
	public void postSearch1ChildOnly(String testMethodName, String user, String testCaseId) throws Throwable {

		try {
			Utils utils = new Utils(RequestType.POST, fullURL, getUserTypeByEnumID(user), this.xlops);
			UserSearch us = new UserSearch("", "", false, 0, 1, new int[] {1}, "paris");
			utils.httpRequest.setPayLoad(us.requestJSON.toString());
			utils.httpRequest.buildAndExecute();

			
			  Logging.log.info("Response for " + testMethodName + ": " +
			  utils.httpRequest.getResponseBody()); Logging.log.info("Response Code: " +
			  utils.httpRequest.getStatusCode());
			 

			Assert.assertEquals(utils.httpRequest.getStatusCode(), "200");
			JSONAssert.assertEquals(
					new JSONObject(utils.xlops.getCellValue(testMethodName, "responsePayload", "test_data")),
					new JSONObject(utils.httpRequest.getResponseBody()), JSONCompareMode.NON_EXTENSIBLE);

		} catch (Exception e) {
			Logging.log.info("Error in TestMethod " + testMethodName + " " + MyBaseTest.getStaktrace(e));
			Assert.fail();
		}

	}

	@Test(dataProvider = "dataProvider")
	public void postSearchWithoutPerson(String testMethodName, String user, String testCaseId) throws Throwable {

		try {
			Utils utils = new Utils(RequestType.POST, fullURL, getUserTypeByEnumID(user), this.xlops);
			UserSearch us = new UserSearch("", "", false, 0, 0, new int[] {}, "paris");
			utils.httpRequest.setPayLoad(us.requestJSON.toString());
			utils.httpRequest.buildAndExecute();

			
			  Logging.log.info("Response for " + testMethodName + ": " +
			  utils.httpRequest.getResponseBody()); Logging.log.info("Response Code: " +
			  utils.httpRequest.getStatusCode());
			 

			Assert.assertEquals(utils.httpRequest.getStatusCode(), "200");
			JSONAssert.assertEquals(
					new JSONObject(utils.xlops.getCellValue(testMethodName, "responsePayload", "test_data")),
					new JSONObject(utils.httpRequest.getResponseBody()), JSONCompareMode.NON_EXTENSIBLE);

		} catch (Exception e) {
			Logging.log.info("Error in TestMethod " + testMethodName + " " + MyBaseTest.getStaktrace(e));
			Assert.fail();
		}

	}

	private class UserSearch {
		String chekInDate = "";
		String checkOutDate = "";
		boolean isPastDate = false;
		int numberOfAdults = 0;
		int numberOfChildren = 0;
		int[] ageOfChildren = {};
		String destination = "";
		JSONObject requestJSON = null;

		UserSearch(String chekInDate, String checkOutDate, boolean isPastDate, int numberOfAdults, int numberOfChildren, int[] ageOfChildren, String destination) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			if (isPastDate == false) {
				this.chekInDate = dateFormat.format(new Date());

				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, 5);

				this.checkOutDate = dateFormat.format(cal.getTime());
			} else if (isPastDate == true) {

				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, -5);

				this.chekInDate = dateFormat.format(cal.getTime());

				this.checkOutDate = dateFormat.format(new Date());
			}

			JSONObject requestJSON = new JSONObject();
			JSONObject dates = new JSONObject();
			dates.put("checkin", this.chekInDate);
			dates.put("checkout", this.checkOutDate);
			requestJSON.put("dates", dates);
			
			this.destination = destination;
			requestJSON.put("destination", this.destination);
			
			this.numberOfAdults = numberOfAdults;
			JSONArray guest1Array = new JSONArray();
			JSONObject adtJSONObject = new JSONObject();
			for(int i = 0; i < this.numberOfAdults; i++) {
				guest1Array.put(adtJSONObject.put("type", "ADT"));
			}
			
			
			JSONArray guest2Array = new JSONArray();
			guest2Array = new JSONArray(guest1Array.toString());
			
			this.numberOfChildren = numberOfChildren;
			JSONObject chdJSONObject = new JSONObject();
			for(int i = 0; i < this.numberOfChildren; i++) {
				chdJSONObject.put("type", "CHD");
				chdJSONObject.put("age", ageOfChildren[i]);
			}
			guest1Array.put(chdJSONObject);
			
			JSONObject guest1JObject = new JSONObject();
			guest1JObject.put("guest", guest1Array);
			
			JSONObject guest2JObject = new JSONObject();
			guest2JObject.put("guest", guest2Array);
			
			
			JSONArray roomJArray = new JSONArray();
			roomJArray.put(guest1JObject);
			roomJArray.put(guest2JObject);
			
			requestJSON.put("room", roomJArray);
			this.requestJSON = requestJSON;
			System.out.println("");
		}
	}

}
