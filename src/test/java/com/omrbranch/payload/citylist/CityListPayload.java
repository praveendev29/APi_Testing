package com.omrbranch.payload.citylist;
import com.omrbranch.pojo.cityList.CityList_Input_Pojo;
import com.omrbranch.utility.BaseClass;

	public class CityListPayload extends BaseClass{

		  public CityList_Input_Pojo addCityListPayload(String string) {
		    CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(string);
		    return cityList_Input_Pojo;

		  }
	
	}



