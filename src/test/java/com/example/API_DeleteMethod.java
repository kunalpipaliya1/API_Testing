package com.example;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class API_DeleteMethod {
	
	@Test
	public void testcase01() {
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Kunal");
		jsondata.put("job", "nms");
		
		RestAssured.baseURI="https://reqres.in/api/users/786";
		Response response = RestAssured.given().header("x-api-key", "reqres-free-v1")
		.when().delete();
		
		response.then().log().all(); // print the logs in console

		Assert.assertEquals(response.statusCode(), 204);
		
	}

}
