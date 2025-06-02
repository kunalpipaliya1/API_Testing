package api_key_authentication;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api_key_authent {
	
	@Test
	public void Bearertoken() {
		// https://api.openweathermap.org/data/2.5/weather?q=Rajkot&appid=YOUR_API_KEY

		RequestSpecification request = RestAssured.given();
		
		request.baseUri("https://api.openweathermap.org");
		request.basePath("/data/2.5/weather");
		request.queryParam("q", "Rajkot");
		request.queryParam("appid", "4708cd9d4ae4bf2dd98a2e23ac3d24815ba88cd49bcb72dc6ed5621e222f4043");
		
		Response response = request.get();
		System.out.println("Response body" + response.statusCode());
		System.out.println("Response body" + response.statusLine());

		
	}

}
