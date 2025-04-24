package com.kaya.erp.kayaerp.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoRandevuGorusmeDoluVeBos {
	
	private String rbaslatan;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	private Date randevusaati;
	private boolean isAvailable;
	private String dealer;
	

}
