package com.omrbranch.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldata.GlobalData;
import com.omrbranch.pojo.postmanbasicauthlogin.PostmanBasicAuthLogin_Output_Pojo;
import com.omrbranch.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC001_LoginStep extends BaseClass {
	Response response;

	@Given("User adds required login headers")
	public void userAddsRequiredLoginHeaders() {
		initRestAssured();
		addHeader("accept", "application/json");
	}

	@When("User adds basic authentication for login")
	public void userAddsBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		addBasicAuthentication(getPropertyValue("username"), getPropertyValue("password"));

	}

	@When("User sends {string} request to the login endpoint")
	public void userSendsRequestToTheLoginEndpoint(String type) {
		response = sendRequest(type, Endpoints.POSTMANBASICAUTHLOGIN);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		//System.out.println(getResponseBody(response));
		GlobalData.getGlobalDataInstance().setStatusCode(statusCode);

	}

	@Then("User should verify the login response body contains firstName {string} and save the logtoken")
	public void userShouldVerifyTheLoginResponseBodyContainsFirstNameAndSaveTheLogtoken(String expFirstName) {

		PostmanBasicAuthLogin_Output_Pojo postmanBasicAuthLogin_Output_Pojo = response
				.as(PostmanBasicAuthLogin_Output_Pojo.class);
		String logtoken = postmanBasicAuthLogin_Output_Pojo.getData().getLogtoken(); //getting log token from pojo output class
		GlobalData.getGlobalDataInstance().setLogtoken(logtoken); 
		String actualFirst_name = postmanBasicAuthLogin_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("verify login endpoint first name", expFirstName, actualFirst_name);

	}

}
