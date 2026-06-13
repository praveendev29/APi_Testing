package com.omrbranch.pojo.GetUserAddress;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserAddress_Output_Pojo {
	public int status;
    public String message;
    public ArrayList<Datum> data;

}
