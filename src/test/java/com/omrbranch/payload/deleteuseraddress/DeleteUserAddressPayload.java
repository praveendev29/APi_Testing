package com.omrbranch.payload.deleteuseraddress;

import com.omrbranch.pojo.DeleteUserAddress.DeleteUserAddress_Input_Pojo;

import com.omrbranch.utility.BaseClass;

public class DeleteUserAddressPayload extends BaseClass {
	 public DeleteUserAddress_Input_Pojo addDeleteUserAddressPayload(String string) {
		 DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(string);
		    return deleteUserAddress_Input_Pojo;

		  }

}
