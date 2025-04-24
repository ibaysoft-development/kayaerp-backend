package com.kaya.erp.kayaerp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoRoleByPermittedUser {
	
	private int role_id;
	private String role_name;
	private Boolean isActive;
	
	
}
