package validate_HTTP_Response_Status;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Validate_HTTP_Response_Status_Code {

	@Test
	public void Testcase_Validate_HTTP_Response_code() {

		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification Request = RestAssured.given(); // get request specification of the request
		Response response = Request.get(); // called get method
		int statuscode = response.statusCode();

		Assert.assertEquals(String.valueOf(statuscode), "200");
		
		String statusline = response.statusLine();
		System.out.println(statusline);
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK", "Incorrect status line");
		
		System.out.println("Testcase01 passed: " + "Testcase_Validate_HTTP_Response_code");		

	}
	
	@Test
	public void Testcase_Validatable_HTTP_Response_code() {

		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification Request = RestAssured.given(); // get request specification
		Response response = Request.get(); // called get method
		
		ValidatableResponse validateRes = response.then();
		
        // Validate status code and status line
		validateRes.statusCode(200);	
		validateRes.statusLine("HTTP/1.1 200 OK");
		
		System.out.println("Testcase01 passed: " + "Testcase_Validatable_HTTP_Response_code");		
	}
	
	@Test
	public void Testcase_Validatable_HTTP_Response_code_withBDD_Method() {

		RestAssured.given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
		
		System.out.println("Testcase01 passed: " + "Testcase_Validatable_HTTP_Response_code_withBDD_Method");		
	}
}
