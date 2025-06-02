package API_Testing_CURD_Operation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_GetMethod {
	
	// without BDD method
	@Test(invocationCount=3) // 3 means 3 time same test execute
	public void test01_Without_BDD() {
		
//		Response response = RestAssured.get("https://reqres.in/api/users/?page=2"); // without credentials get request
		
		Response response = RestAssured.given().auth().preemptive().basic("master", "master").get("http://10.172.0.175:4524/v1/rfts/servers/systemAlarms");
		
		if(response!=null) {
			System.out.println("Response received...!!");
		} else {
			System.out.println("Response empty...!!");
		}
		
		System.out.println("API Status code: " + response.statusCode());
		System.out.println("API Response body code: " + response.body().asString());
		System.out.println("API Header code: " + response.getHeaders());
		System.out.println("API Detailed cookies: " + response.getDetailedCookies());
		System.out.println("API Repsonse Time in millisecond: " + response.getTime());

		int actualstatuscode = response.statusCode();
		int expectedstatuscode = 200;
		
		Assert.assertEquals(actualstatuscode, expectedstatuscode, "Status code validation");

	}
	
	// using BDD method(given,when,then)
	@Test(invocationCount=0) // not execute this test case because it's update 0
	public void Test02_With_BDD() {
		
		Response response = RestAssured
		.given()
		.auth()
		.preemptive()
		.basic("master", "master")
		.when()
		.get("http://10.172.0.175:4524/v1/rfts/servers/systemAlarms");
		
		System.out.println("API Status code:\n" + response.statusCode() + "\n");
		System.out.println("API Header code:\n" + response.getHeaders() + "\n");
		System.out.println("API Detailed cookies:\n" + response.getHeaders() + "\n");
		System.out.println("API Repsonse Time in millisecond:" + response.getTime() + "\n");
		System.out.println("API Response body code:\n" + response.body().asString() + "\n");
		
	}
	
	@Test
	public void Test03_API_Key_without_BDD() {
		
		Response response = RestAssured.given().header("x-api-key", "reqres-free-v1").when().get("https://reqres.in/api/users/?page=2");

		System.out.println("API Status code:\n" + response.statusCode() + "\n");
		System.out.println("API Header code:\n" + response.getHeaders() + "\n");
		System.out.println("API Detailed cookies:\n" + response.getHeaders() + "\n");
		System.out.println("API Repsonse Time in millisecond:" + response.getTime() + "\n");
		System.out.println("API Response body code:\n" + response.body().asString() + "\n");
	}

}
