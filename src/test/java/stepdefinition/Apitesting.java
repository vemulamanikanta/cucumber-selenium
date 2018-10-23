package stepdefinition;

import org.json.JSONObject;
import org.junit.Assert;

import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Apitesting {

	@When("^I create an user account$")
	public void i_create_an_user_account() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("first_name", "Virender"); // n
		requestParams.put("last_name", "manikanta");
		requestParams.put("id", "2");

		Response response = request.post("/api/users");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(Integer.toString(statusCode), "201");
		String jsonResponse = response.jsonPath().get("first_name");
		System.out.println(jsonResponse);
		JSONObject myResponse = new JSONObject(response.toString());
		System.out.println("statusCode- " + myResponse.getString("statusCode"));
		System.out.println("First_name- " + myResponse.getString("first_name"));
	}

	@When("^I update an user account$")
	public void i_update_an_user_account() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "vemu"); // n
		requestParams.put("job", "MainFrame Developer");

		Response response = request.patch("/api/users/2");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(Integer.toString(statusCode), "200");
		// String jsonResponse = response.jsonPath().get("updatedAt");
		JSONObject myResponse = new JSONObject(response.toString());
		System.out.println("statusCode- " + myResponse.getString("statusCode"));
		System.out.println("updateAt- " + myResponse.getString("updatedAt"));

	}

	@When("^I delete an user account$")
	public void i_delete_an_user_account() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "vemu"); // n
		requestParams.put("job", "MainFrame Developer");

		Response response = request.delete("/api/users/2");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(Integer.toString(statusCode), "204");

	}
}
