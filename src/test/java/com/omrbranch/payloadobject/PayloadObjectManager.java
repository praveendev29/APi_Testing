package com.omrbranch.payloadobject;

import com.omrbranch.payload.adduseraddress.AddUserAddressPayload;
import com.omrbranch.payload.citylist.CityListPayload;
import com.omrbranch.payload.deleteuseraddress.DeleteUserAddressPayload;
import com.omrbranch.payload.updateuseraddress.UpdateUserAddressPayload;

public class PayloadObjectManager {
	  public static PayloadObjectManager pom;

	  public static PayloadObjectManager getPayloadInstance() {
	    if (pom == null) {
	      pom = new PayloadObjectManager();
	    }
	    return pom;
	  }

	  public PayloadObjectManager() {
	  }

	  private CityListPayload cityListPayload;
	  private AddUserAddressPayload addUserAddressPayload;
	  private UpdateUserAddressPayload updateUserAddressPayload;
	  private DeleteUserAddressPayload deleteUserAddressPayload;

	  public CityListPayload getCityListPayload() {
	    return (cityListPayload == null) ? cityListPayload = new CityListPayload() : cityListPayload;
	  }

	  public AddUserAddressPayload getAddUserAddressPayload() {
	    return (addUserAddressPayload == null) ? addUserAddressPayload = new AddUserAddressPayload()
	        : addUserAddressPayload;
	  }

	  public UpdateUserAddressPayload getUpdateUserAddressPayload() {
	    return (updateUserAddressPayload == null) ? updateUserAddressPayload = new UpdateUserAddressPayload()
	        : updateUserAddressPayload;
	  }

	  public DeleteUserAddressPayload getDeleteUserAddressPayload() {
	    return (deleteUserAddressPayload == null) ? deleteUserAddressPayload = new DeleteUserAddressPayload()
	        : deleteUserAddressPayload;
	  }

	}
