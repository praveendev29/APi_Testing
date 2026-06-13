package com.omrbranch.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldata.GlobalData;
import com.omrbranch.pojo.ChangeProfilePic.ChangeProfilePic_Output_Pojo;
import com.omrbranch.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC004_UserProfileStep extends BaseClass {
	Response response;
	

	@Given("User sets bearer authorization using the saved logtoken for profile picture endpoint")
	public void user_sets_bearer_authorization_using_the_saved_logtoken_for_profile_picture_endpoint() {
		initRestAssured();

		// 2. Add headers
		List<Header> lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "multipart/form-data");
		Header h3 = new Header("Authorization", "Bearer " + GlobalData.getGlobalDataInstance().getLogtoken());
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
	}
	
	@Given("User sets multipart request body with valid image file for profile update")
	public void user_sets_multipart_request_body_with_valid_image_file_for_profile_update() {
		File file = new File(System.getProperty("user.dir")+"\\target\\selfie.jpeg");
		addMultiPart("profile_picture", file);
	    
	}
	@When("User sends {string} request to the ChangeProfile endpoint")
	public void user_sends_request_to_the_change_profile_endpoint(String type) {
		response = sendRequest(type, Endpoints.CHANGEPROFILEPIC);
	    
	}
	@Then("User should verify the response message is {string}")
	public void user_should_verify_the_response_message_is(String expectedMessage) {
		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);

		String actualMessage = changeProfilePic_Output_Pojo.getMessage();
		Assert.assertEquals("verify the response message", expectedMessage, actualMessage);
	}




}
