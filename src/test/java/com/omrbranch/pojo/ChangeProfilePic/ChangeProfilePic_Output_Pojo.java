package com.omrbranch.pojo.ChangeProfilePic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProfilePic_Output_Pojo {
	 private int status;
	    public String message;
	    private Datum data;
	    private int cart_count;

}
