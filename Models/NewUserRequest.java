package com.nicoz.NZWanderlust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserRequest {

    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private Long reputationScoreId;
	private String address;	
	private String phoneNumber;	    
	private Integer userLevelID;  
}
