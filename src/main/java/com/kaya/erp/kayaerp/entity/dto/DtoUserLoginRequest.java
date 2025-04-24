package com.kaya.erp.kayaerp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoUserLoginRequest {

	private String username;
	private String password;
	
	
	
}
