package test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class TestRest {

    public static void main(String a[]) {

        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType("application/json").build();

        // int responseCode =
        // given().log().all().body(getPayLoadOf(pet)).when().post(END_POINT).then().log().all()
        // .extract().statusCode();
        // Assert.assertEquals(responseCode, 200, "Response code is not 200");
        // System.out.println("post response code is ---- "+responseCode);

        ValidatableResponse validatableRequestResponse = given().contentType(ContentType.JSON).when()
                .get("/pet" + "/" + "7723").then();
        int getRequestStatusCode = validatableRequestResponse.extract().statusCode();
        System.out.println("\nget request status code is ------------------------" + getRequestStatusCode);

        Response requestResponse = validatableRequestResponse.extract().response();
        System.out.println("\n get request response is " + requestResponse.getBody().asString());

    }
}
