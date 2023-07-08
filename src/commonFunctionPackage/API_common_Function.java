package commonFunctionPackage;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
//import requestRepositoryPackage.post_req_repository;

public class API_common_Function {

	
	public static int response_statuscode(String baseURI,String resouce,String requestBody) {
		RestAssured.baseURI=baseURI;
		
		int statusCode=given().header("Content-Type","application/json").body(requestBody).when().post(resouce).then().extract().statusCode();
		
		return statusCode; 
	}
	public static String response_Body(String baseURI,String resouce,String requestBody) {
		RestAssured.baseURI=baseURI;
		
		
String responseBody=given().header("Content-Type","application/json").body(requestBody).when().post(resouce).then().extract().response().asString();
			return responseBody;
	}

}