package api_key_authentication;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api_key_authentication {
	
	@Test
	public void Bearertoken() {
		// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid=YOUR_API_KEY
		// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

		RequestSpecification request = RestAssured.given();
		
		request.baseUri("https://api.openweathermap.org");
		request.basePath("/data/2.5/weather");
		request.queryParam("q", "Rajkot");
		request.queryParam("appid", "82a7225b84c1931c4618d5ed6df88df5");
		
		Response response = request.get();
		System.out.println("Response body" + response.statusCode());
		System.out.println("Response body" + response.statusLine());
		
		int status_code = response.statusCode();
		
		
		Assert.assertEquals(status_code, 200);
		
	}

}
