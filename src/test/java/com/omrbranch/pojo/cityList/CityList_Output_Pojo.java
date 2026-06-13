package com.omrbranch.pojo.cityList;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class CityList_Output_Pojo {
	
	public int status;
    public String message;
    public ArrayList<Datum> data;

}
