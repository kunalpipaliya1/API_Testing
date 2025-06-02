package basic_Authentication_and_Digest_Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic_Digest_Authentication {
	
	@Test
	public void basic_auth() {
		
		RequestSpecification ResponseBody = RestAssured.given();
		ResponseBody.baseUri("https://postman-echo.com/");
		ResponseBody.basePath("/basic-auth"); // basic authentication use "Base64" to encode the value
		
		Response response = ResponseBody.auth().basic("postman", "password").get();
		
		System.out.println("Basic Authentication" + response.statusLine());
		
	}
	
	@Test // preemptive -- First time API give the credentials to server.
	public void basic_auth_preemptive() {
		
		RequestSpecification ResponseBody = RestAssured.given();
		ResponseBody.baseUri("https://postman-echo.com/");
		ResponseBody.basePath("/basic-auth");
		
		Response response = ResponseBody.auth().preemptive().basic("postman", "password").get();
		
		System.out.println("preemptive Authentication" + response.statusLine());
		System.out.println("Response body" + response.body().asString());

		
	}
	
	@Test // digest -- It means it's generate a link and base on link we can enter the credentials
	public void digesr_auth() {
		// https://httpbin.org/digest-auth/undefined/Kunal/Kunal
		RequestSpecification ResponseBody = RestAssured.given();
		ResponseBody.baseUri("https://httpbin.org");
		ResponseBody.basePath("/digest-auth/undefined/Kunal/Kunal");
		
		Response response = ResponseBody.auth().digest("Kunal", "Kunal").get();
		
		System.out.println("digest Authentication" + response.statusLine());

		
	}
	

}
