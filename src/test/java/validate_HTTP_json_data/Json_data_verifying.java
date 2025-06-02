package validate_HTTP_json_data;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Json_data_verifying {
	
	@Test
	public void jsondata() {
		
		RequestSpecification Requestspec = RestAssured.given();
		Requestspec.baseUri("https://reqres.in/");
		Requestspec.basePath("/api/users/2");
		
		Response response = Requestspec.get();
		
		ResponseBody bodyresponse = response.body();
		String String_body = bodyresponse.asString();
		
		System.out.println("String Request body: " + String_body);
		
		Assert.assertEquals(String_body.contains("Weaver"), true, "Validated done");
		
		// json validatation
		
		JsonPath jsonvalidate = bodyresponse.jsonPath();

		String firstname = jsonvalidate.get("data.first_name");
		System.out.println("String Request body: " + firstname);

		Assert.assertEquals(firstname, "Janet");
		
	}

}
