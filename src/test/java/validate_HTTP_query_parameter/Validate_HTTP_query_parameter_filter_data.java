package validate_HTTP_query_parameter;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Validate_HTTP_query_parameter_filter_data {
	// https://reqres.in/api/users?page=2
	
	@Test
	public void filter_data() {
		
		RequestSpecification Request = RestAssured.given();
		
		Request.baseUri("https://reqres.in");
		Request.basePath("/api/users");
		Request.headers("x-api-key", "reqres-free-v1"); // API Key
		Request.queryParam("page", 2).queryParam("id", 10);
		
		Response response = Request.get();
		
		String responsebodystring = response.getBody().asString();
		System.out.println("Response body string: " + responsebodystring);
		
		JsonPath jsonpathview = response.jsonPath();
		
		String last_name  = jsonpathview.get("data.last_name");
		
		System.out.println("Response body last name string: " + last_name);

		Assert.assertEquals(last_name, "Fields");

		
		
		
	}

	private io.restassured.path.json.JsonPath jsonPath() {
		// TODO Auto-generated method stub
		return null;
	}

	private JsonPath JsonPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
