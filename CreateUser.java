package l23;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class CreateUser {
	
	@Test
	void test_createUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());  //will create name of the user
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "7299ba720b99078b4e059ed561855f4e5e2e86ef7ac56777dd675b3d9200f1dd";
		
		int id=given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
			
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		System.out.println("Generated id is:"+id);
		
		context.setAttribute("user_id", id);	
		
	}

}
