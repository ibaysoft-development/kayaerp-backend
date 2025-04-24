package com.kaya.erp.kayaerp.entity.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DtoRandevuGorusmeRequest {
	
    
    private String rbaslatanuser;
	
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	private Date rtarih;
	
	private String rdealer;
	
	private Boolean isActive;
	
	
	
	
	

}