package API_Testing_CURD_Operation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class API_PutMethod {
	
	@Test
	public void testcase01() {
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Kunal");
		jsondata.put("job", "nms");
		
		RestAssured.baseURI="https://reqres.in/api/users/786";
		Response response = RestAssured.given().header("Content-type", "application/json").header("x-api-key", "reqres-free-v1").contentType(ContentType.JSON)
		.body(jsondata.toJSONString())
		.when().put();
		
		response.then().log().all(); // print the logs in console

		Assert.assertEquals(response.statusCode(), 200);
	}

}
