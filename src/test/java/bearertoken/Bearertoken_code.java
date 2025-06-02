package bearertoken;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Bearertoken_code {
	
	@Test
	public void Bearertoken() {
		
		RequestSpecification request = RestAssured.given();
		
		request.baseUri("https://gorest.co.in");
		request.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "kunal12");
		payload.put("email", "kunal21@gmail.com");
		payload.put("gender", "male");
		payload.put("status", "active");
		
		String AuthToken = "Bearer 4708cd9d4ae4bf2dd98a2e23ac3d24815ba88cd49bcb72dc6ed5621e222f4043";
		
		request.header("Authorization", AuthToken)
		.contentType(ContentType.JSON).body(payload.toJSONString());
		
		Response reponse = request.post();		
		
		Assert.assertEquals(reponse.statusCode(), 201);
		
	}

}
