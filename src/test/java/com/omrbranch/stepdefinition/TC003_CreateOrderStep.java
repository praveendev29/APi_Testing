package com.omrbranch.stepdefinition;

import com.omrbranch.utility.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC003_CreateOrderStep extends BaseClass {
	Response response;
	

	@Given("User sets bearer authorization for ClearCart endpoint")
	public void user_sets_bearer_authorization_for_clear_cart_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sends {string} request to the ClearCart endpoint")
	public void user_sends_request_to_the_clear_cart_endpoint(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify the ClearCart response message is {string}")
	public void verify_the_clear_cart_response_message_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User sets headers for SearchProduct")
	public void user_sets_headers_for_search_product() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sets request body to search for product {string}")
	public void user_sets_request_body_to_search_for_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sends {string} request to the SearchProduct endpoint")
	public void user_sends_request_to_the_search_product_endpoint(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify the search result includes product name {string} and Save the category ID and product ID from response")
	public void verify_the_search_result_includes_product_name_and_save_the_category_id_and_product_id_from_response(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User sets bearer authorization for GetSearchProductList endpoint")
	public void user_sets_bearer_authorization_for_get_search_product_list_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sets request body with saved product ID")
	public void user_sets_request_body_with_saved_product_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sends {string} request to the GetSearchProductList endpoint")
	public void user_sends_request_to_the_get_search_product_list_endpoint(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify the response includes product with specification {string} and save the variant ID")
	public void verify_the_response_includes_product_with_specification_and_save_the_variant_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User sets bearer authorization for AddToCart endpoint")
	public void user_sets_bearer_authorization_for_add_to_cart_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sets request body using saved variant ID")
	public void user_sets_request_body_using_saved_variant_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sends {string} request to the AddToCart endpoint")
	public void user_sends_request_to_the_add_to_cart_endpoint(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify the AddToCart response message is {string}")
	public void verify_the_add_to_cart_response_message_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@Given("User sets bearer authorization for GetCart endpoint")
	public void user_sets_bearer_authorization_for_get_cart_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sends {string} request to the GetCart endpoint")
	public void user_sends_request_to_the_get_cart_endpoint(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify the GetCart response message is {string} Save the cart ID")
	public void verify_the_get_cart_response_message_is_save_the_cart_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@Given("User sets bearer authorization for SetAddress endpoint")
	public void user_sets_bearer_authorization_for_set_address_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sets request body with saved address ID and cart ID")
	public void user_sets_request_body_with_saved_address_id_and_cart_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sends {string} request to the SetAddress endpoint")
	public void user_sends_request_to_the_set_address_endpoint(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify the SetAddress response message is {string}")
	public void verify_the_set_address_response_message_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User sets bearer authorization for CreateOrder endpoint")
	public void user_sets_bearer_authorization_for_create_order_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sets request body to create order with payment details {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_sets_request_body_to_create_order_with_payment_details(String string, String string2, String string3, String string4, String string5, String string6, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}
	@When("User sends {string} request to the CreateOrder endpoint")
	public void user_sends_request_to_the_create_order_endpoint(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Verify the CreateOrder response message is {string}")
	public void verify_the_create_order_response_message_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}




















}
