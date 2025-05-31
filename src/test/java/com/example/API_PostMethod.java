package com.example;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class API_PostMethod {
	
	@Test
	public void Testcase01() {
//		Response response = RestAssured.post("https://reqres.in/api/users");   // .get("https://reqres.in/api/users/?page=2");
//		System.out.println("Status code: " + response.statusCode());	
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Kunal");
		jsondata.put("job", "nms");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		Response response = RestAssured.given().header("Content-type", "application/json").header("x-api-key", "reqres-free-v1").contentType(ContentType.JSON)
		.body(jsondata.toJSONString())
		.when().post();
		
		response.then().log().all(); // print the logs in console
		
		// below is customize we added, prefer in above without manually
//		System.out.println("API Status code:\n" + response.statusCode() + "\n");
//		System.out.println("API Header code:\n" + response.getHeaders() + "\n");
//		System.out.println("API Detailed cookies:\n" + response.getHeaders() + "\n");
//		System.out.println("API Response Time in millisecond:" + response.getTime()+ "\n");
//		System.out.println("API Response body code:\n" + response.body().asString());

	}

}
