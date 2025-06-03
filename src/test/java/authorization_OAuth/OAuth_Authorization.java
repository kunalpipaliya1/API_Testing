package authorization_OAuth;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth_Authorization {

    @Test
    public void OAuth2_ClientCredentials() {

        // Login JSON
        String jsonBody = """
                {
                  "username": "admin",
                  "password": "12qwaszx!@"
                }
                """;

        RestAssured.useRelaxedHTTPSValidation();

        // Step 1: Login and get token
        Response postmethod = RestAssured.given()
                .baseUri("https://gfgnl-inventory.gujarat.gov.in:9090")
                .basePath("/login")
                .contentType("application/json")
                .body(jsonBody)
                .post();

        System.out.println("Login Status Code: " + postmethod.statusCode());

        // Extract JWT token as plain string
        String accessToken = postmethod.getBody().asString().trim();
        System.out.println("Access Token: " + accessToken);

        // Step 2: Use token to make authorized GET request
        Response getmethod = RestAssured.given()
                .baseUri("https://gfgnl-inventory.gujarat.gov.in:9090")
                .basePath("/fault-management/getNEStatus")
                .queryParam("status", "DOWN")
                .queryParam("lgdCodes", "O301036")
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json") // optional, but may be required
                .accept("application/json") // ensure JSON response
                .get();

        // Step 3: Print response from protected endpoint
        System.out.println("GET Status Code: " + getmethod.statusCode());
        System.out.println("GET Response: " + getmethod.prettyPrint());
    }
}
