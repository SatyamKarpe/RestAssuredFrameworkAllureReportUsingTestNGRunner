package testClassPackage;
import java.io.IOException;

import java.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctionPackage.API_common_Function;
import commonFunctionPackage.Utility_commonFunction;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.post_req_repository;
public class post_tc_3 {
	@Test
public static void execute() throws IOException {
for(int i=0;i<5;i++)
{
	String baseURI=post_req_repository.base_URI();
	String requestBody=post_req_repository.post_request3();
	String resource=post_req_repository.post_resource();
	int statusCode=API_common_Function.response_statuscode(baseURI, resource, requestBody );
if(statusCode==201)
{
String responseBody=API_common_Function.response_Body(baseURI, resource, requestBody);
System.out.println(responseBody);
post_tc_3.validator(responseBody, statusCode, requestBody);
Utility_commonFunction.evidencefilecreator("post_tc_3", responseBody, requestBody);
break;
}
else 
{
	
	
System.out.println("correct status code not found hence retrying");
}
}
}
public static void validator(String responseBody,int statusCode,String requestBody) {
//Parse response body and its parameters
JsonPath jsp=new JsonPath(responseBody);
String res_name=jsp.getString("name");
String res_job=jsp.getString("job");
String res_id=jsp.getString("id");
String res_createdAt=jsp.getString("createdAt");

//parse request body and its parameters
Assert.assertEquals(statusCode,201);
Assert.assertEquals(res_name, "rony");
Assert.assertEquals(res_job, "labqa");
Assert.assertNotNull(res_id);
String currentdate = LocalDate.now().toString();
Assert.assertEquals(res_createdAt.substring(0,10), currentdate);
}
}

