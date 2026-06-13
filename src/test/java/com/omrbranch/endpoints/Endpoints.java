package com.omrbranch.endpoints;

public interface Endpoints {
	
	 String BASE_URL = "https://omrbranch.com/api/";

	    String POSTMANBASICAUTHLOGIN = BASE_URL + "postmanBasicAuthLogin";
	    String STATELIST = BASE_URL + "stateList";
	    String CITYLIST = BASE_URL + "cityList";
	    String ADDUSERADDRESS = BASE_URL + "addUserAddress";
	    String UPDATEUSERADDRESS = BASE_URL + "updateUserAddress";
	    String GETUSERADDRESS = BASE_URL + "getUserAddress";
	    String DELETEUSERADDRESS = BASE_URL + "deleteAddress";
	    String CHANGEPROFILEPIC = BASE_URL+"changeProfilePic";
}
