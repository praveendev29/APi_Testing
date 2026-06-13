package com.omrbranch.payload.updateuseraddress;


import com.omrbranch.pojo.UpdateUserAddress.UpdateUserAddress_Input_Pojo;

public class UpdateUserAddressPayload {

	public UpdateUserAddress_Input_Pojo updateUserAddressPayload(
	        String addressId,
	        String firstName,
	        String lastName,
	        String mobile,
	        String apartment,
	        int state,
	        int city,
	        int country,
	        String zipcode,
	        String address,
	        String addressType) {

	    return new UpdateUserAddress_Input_Pojo(
	            addressId,
	            firstName,
	            lastName,
	            mobile,
	            apartment,
	            state,
	            city,
	            country,
	            zipcode,
	            address,
	            addressType);
	}
	
	

	
	

}
