package com.example;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class API_PatchMethod {
	
	@Test
	public void testcase01() {
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Kunal123");
		jsondata.put("job", "nms123");
		
		RestAssured.baseURI="https://reqres.in/api/users/786";
		Response response = RestAssured.given().header("Content-type", "application/json").header("x-api-key", "reqres-free-v1").contentType(ContentType.JSON)
		.body(jsondata.toJSONString())
		.when().patch();
		
		response.then().log().all(); // print the logs in console
		
		Assert.assertEquals(response.statusCode(), 200);
	}

}
