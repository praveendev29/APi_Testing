package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.AddUserAddress.AddUserAddress_Input_Pojo;
import com.omrbranch.AddUserAddress.AddUserAddress_Output_Pojo;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldata.GlobalData;
import com.omrbranch.pojo.DeleteUserAddress.DeleteUserAddress_Input_Pojo;
import com.omrbranch.pojo.DeleteUserAddress.DeleteUserAddress_Output_Pojo;
import com.omrbranch.pojo.GetUserAddress.GetUserAddress_Output_Pojo;
import com.omrbranch.pojo.UpdateUserAddress.UpdateUserAddress_Input_Pojo;
import com.omrbranch.pojo.UpdateUserAddress.UpdateUserAddress_Output_Pojo;
import com.omrbranch.payloadobject.PayloadObjectManager;

import com.omrbranch.pojo.cityList.CityList_Input_Pojo;
import com.omrbranch.pojo.cityList.CityList_Output_Pojo;
import com.omrbranch.pojo.statelist.Datum;
import com.omrbranch.pojo.statelist.StateList_Output_Pojo;
import com.omrbranch.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

// Step Definitions for State, City, and Address CRUD operations
public class TC002_AddressStep extends BaseClass {
	Response response;
	public PayloadObjectManager pom = PayloadObjectManager.getPayloadInstance();

	// -------------------------------------------------------------------------
	// State List API
	// -------------------------------------------------------------------------

	@Given("User adds headers for StateList")
	public void user_adds_headers_for_state_list() {
		initRestAssured();
		addHeader("accept", "application/json");
	}

	@When("User sends {string} request to StateList endpoint")
	public void user_sends_request_to_state_list_endpoint(String type) {
		response = sendRequest(type, Endpoints.STATELIST);
		int statusCode = getStatusCode(response);
		GlobalData.getGlobalDataInstance().setStatusCode(statusCode);
	}

	@Then("User should verify the stateList response message matches {string} and save the state id")
	public void user_should_verify_the_state_list_response_message_matches_and_save_the_state_id(String expStateName) {
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);

		// Loop through states to find the matching name and store its ID
		ArrayList<Datum> data = stateList_Output_Pojo.getData();
		for (Datum eachStateList : data) {
			String actualStateName = eachStateList.getName();
			if (actualStateName.equals(expStateName)) {
				int stateId = eachStateList.getId();
				String stateIdText = String.valueOf(stateId);
				GlobalData.getGlobalDataInstance().setStateIdText(stateIdText);
				System.out.println(stateIdText);
				Assert.assertEquals("verify state list endpoint state name", expStateName, actualStateName);
				break;
			}
		}
	}

	// -------------------------------------------------------------------------
	// City List API
	// -------------------------------------------------------------------------

	@Given("User adds headers for CityList")
	public void user_adds_headers_for_city_list() {
		initRestAssured();

		List<Header> lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
	}

	@When("User adds request body with state id for city list")
	public void user_adds_request_body_with_state_id_for_city_list() {
		// Pass the saved state ID into the city payload
		CityList_Input_Pojo cityListPayload = pom.getCityListPayload()
				.addCityListPayload(GlobalData.getGlobalDataInstance().getStateIdText());
		addPayload(cityListPayload);
	}

	@When("User sends {string} request to CityList endpoint")
	public void user_sends_request_to_city_list_endpoint(String type) {
		response = sendRequest(type, Endpoints.CITYLIST);
	}

	@Then("User should verify the cityList response message matches {string} and save the city id")
	public void user_should_verify_the_city_list_response_message_matches_and_save_the_city_id(
			String expectedCityName) {
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		
		// Find matching city name and store its ID
		ArrayList<com.omrbranch.pojo.cityList.Datum> data = cityList_Output_Pojo.getData();
		for (com.omrbranch.pojo.cityList.Datum eachCityList : data) {
			String name = eachCityList.getName();
			if (name.equals(expectedCityName)) {
				int cityId = eachCityList.getId();
				String cityIdText = String.valueOf(cityId);
				GlobalData.getGlobalDataInstance().setCityIdText(cityIdText);
				System.out.println(cityIdText);
				Assert.assertEquals("verify state list endpoint state name", expectedCityName, name);
				break;
			}
		}
	}

	// -------------------------------------------------------------------------
	// Add Address API
	// -------------------------------------------------------------------------

	@Given("User adds headers and bearer authorization for accessing address endpoints")
	public void user_adds_headers_and_bearer_authorization_for_accessing_address_endpoints() {
		initRestAssured();

		List<Header> lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		Header h3 = new Header("Authorization", "Bearer " + GlobalData.getGlobalDataInstance().getLogtoken());
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
	}

	@When("User adds request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_adds_request_body_for_add_new_address(String firstName, String lastName, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		AddUserAddress_Input_Pojo addUserAddressPayload = PayloadObjectManager.getPayloadInstance()
				.getAddUserAddressPayload().addUserAddressPayload(firstName, lastName, mobile, apartment,
						Integer.parseInt(state), Integer.parseInt(city), Integer.parseInt(country), zipcode, address,
						address_type);

		addPayload(addUserAddressPayload);
	}

	@Then("User sends {string} request to addUserAddress endpoint")
	public void user_sends_request_to_add_user_address_endpoint(String type) {
		response = sendRequest(type, Endpoints.ADDUSERADDRESS);
	}

	@Then("User should verify the addUserAddress response message matches {string} and save the address id")
	public void user_should_verify_the_add_user_address_response_message_matches_and_save_the_address_id(
			String responseMessage) {
		AddUserAddress_Output_Pojo AddUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actualAddUserMessage = AddUserAddress_Output_Pojo.getMessage();
		System.out.println(actualAddUserMessage);
		
		// Capture and save address ID for update/delete scenarios
		int address_id = AddUserAddress_Output_Pojo.getAddress_id();
		String addressIdText = String.valueOf(address_id);
		GlobalData.getGlobalDataInstance().setAddressIdText(addressIdText);
		
		Assert.assertEquals("verify the addUserAddress response message", responseMessage, actualAddUserMessage);
		System.out.println(addressIdText);
	}

	// -------------------------------------------------------------------------
	// Update Address API
	// -------------------------------------------------------------------------

	@When("User adds request body to update address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_adds_request_body_to_update_address(String firstName, String lastName, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		UpdateUserAddress_Input_Pojo updateUserAddressPayload = PayloadObjectManager.getPayloadInstance()
				.getUpdateUserAddressPayload()
				.updateUserAddressPayload(GlobalData.getGlobalDataInstance().getAddressIdText(),
						firstName, lastName, mobile, apartment, Integer.parseInt(state), Integer.parseInt(city),
						Integer.parseInt(country), zipcode, address, address_type);

		addPayload(updateUserAddressPayload);
	}

	@When("User sends {string} request to updateUserAddress endpoint")
	public void user_sends_request_to_update_user_address_endpoint(String type) {
		response = sendRequest(type, Endpoints.UPDATEUSERADDRESS);
	}

	@Then("User should verify the updateUserAddress response message matches {string}")
	public void user_should_verify_the_update_user_address_response_message_matches(String expResponseMessage) {
		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String actualResponseMessage = updateUserAddress_Output_Pojo.getMessage();
		System.out.println(actualResponseMessage);
		Assert.assertEquals("verify the updateUserAddress response message", expResponseMessage, actualResponseMessage);
	}

	// -------------------------------------------------------------------------
	// Get Address API
	// -------------------------------------------------------------------------

	@Given("User adds headers and bearer authorization for accessing get address endpoints")
	public void user_adds_headers_and_bearer_authorization_for_accessing_get_address_endpoints() {
		initRestAssured();

		List<Header> lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + GlobalData.getGlobalDataInstance().getLogtoken());
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
	}

	@When("User sends {string} request to GetUserAddress endpoint")
	public void user_sends_request_to_get_user_address_endpoint(String type) {
		response = sendRequest(type, Endpoints.GETUSERADDRESS);
	}

	@Then("User should verify the GetUserAddress response message matches {string}")
	public void user_should_verify_the_get_user_address_response_message_matches(String expectedResponseMessage) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String getMessage = getUserAddress_Output_Pojo.getMessage();
		System.out.println(getMessage);
		Assert.assertEquals("verify the GetUserAddress response message", expectedResponseMessage, getMessage);
	}

	// -------------------------------------------------------------------------
	// Delete Address API
	// -------------------------------------------------------------------------

	@When("User adds request body with address id")
	public void user_adds_request_body_with_address_id() {
		DeleteUserAddress_Input_Pojo deleteUserAddressPayload = PayloadObjectManager.getPayloadInstance()
				.getDeleteUserAddressPayload()
				.addDeleteUserAddressPayload(GlobalData.getGlobalDataInstance().getAddressIdText());
		addPayload(deleteUserAddressPayload);
	}

	@When("User sends {string} request to DeleteAddress endpoint")
	public void user_sends_request_to_delete_address_endpoint(String type) {
		response = sendRequest(type, Endpoints.DELETEUSERADDRESS);
	}

	@Then("User should verify the DeleteAddress response message matches {string}")
	public void user_should_verify_the_delete_address_response_message_matches(String expMessage) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String actualMessage = deleteUserAddress_Output_Pojo.getMessage();
		System.out.println(actualMessage);
		Assert.assertEquals("verify the DeleteAddress response message", expMessage, actualMessage);
	}
}