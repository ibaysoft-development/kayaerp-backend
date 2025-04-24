package com.kaya.erp.kayaerp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoPageByPermittedRole {
	
	private int sayfaId;
	private String sayfaAdi;
	private Boolean isActive;

}
