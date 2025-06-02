package validate_HTTP_Response_Header;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Header_Verify {
	// https://reqres.in/api/users?page=2
	
	@Test
	public void Headerverify() {
		
		RequestSpecification Requestedheader = RestAssured.given();

		Requestedheader.baseUri("https://reqres.in/");
		Requestedheader.basePath("api/users");
		
		Response response = Requestedheader.get();
		String singleheader = response.getHeader("Content-Type");
		System.out.println("Single Header: " + singleheader + "\n\n");

		Headers all_header = response.getHeaders();
//		System.out.println("All Header List old: " + all_header + "\n\n");
		
		// above single statement also we take the header and for loop also we take like below.
		
		for(Header header:all_header) {
			System.out.println("All Header List: " + header.getName() + "Name with value" + header.getValue());
		}
		
		// validate the header
		Assert.assertEquals(singleheader, "application/json; charset=utf-8");
		
		
	}
	

}
