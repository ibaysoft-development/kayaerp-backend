package com.kaya.erp.kayaerp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoServisAracFilter {
	    
	    private Long aracid;
	    private String marka;
	    private String model;
	    private String bazarac;
	    private String aractip;
	    private String plaka;
	    private Long ruhsatsahibi;
	    private String ruhsatsahibitip;
	    private String sasi;
	    private String motor;
	    private String ruhsatsahibiadi;
	    private Long km;
	    private Long modelyili;
	    private String bayi;
	    private String ekleyen;
	    private String soforadi;
	    private String sofortel;
	    private String muayeneTarihiBastar;
	    private String muayeneTarihiBittar;
	    private String egzosTarihiBastar;
	    private String egzosTarihiBittar;
	    private String eklenmeTarihiBastar;
	    private String eklenmeTarihiBittar;
	    private String tescilTarihiBastar;
	    private String tescilTarihiBittar;
}
