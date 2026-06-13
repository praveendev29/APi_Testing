package com.omrbranch.payload.adduseraddress;

import com.omrbranch.AddUserAddress.AddUserAddress_Input_Pojo;

public class AddUserAddressPayload {


    public AddUserAddress_Input_Pojo addUserAddressPayload(
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

        return new AddUserAddress_Input_Pojo(
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
