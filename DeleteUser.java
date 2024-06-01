package l23;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class DeleteUser {
	
	
	@Test
	void test_deleteUser(ITestContext context) {
		
		String bearerToken = "7299ba720b99078b4e059ed561855f4e5e2e86ef7ac56777dd675b3d9200f1dd";
		
		int id = (Integer) context.getAttribute("user_id"); 
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.pathParam("id", id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(204)
		.log().all();
		
		
	}

}
