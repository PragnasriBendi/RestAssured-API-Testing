package l23;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	void test_updateUser(ITestContext context) {
		
        Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());  //will create name of the user
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken = "7299ba720b99078b4e059ed561855f4e5e2e86ef7ac56777dd675b3d9200f1dd";
		
		//int id = (Integer) context.getAttribute("user_id"); 
		
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.pathParam("id", id)
		.body(data.toString())
			
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		System.out.println("Generated id is:"+id);
		
	}

}
