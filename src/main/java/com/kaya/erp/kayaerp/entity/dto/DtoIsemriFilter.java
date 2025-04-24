package com.kaya.erp.kayaerp.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoIsemriFilter {
	
	    private Long isemriId;
	    private Long musId;
	    private String musTip;
	    private String musteri;
	    private String telefon;
	    private Long km;
	    private String plaka;
	    private Long aracId;
	    private Date tarih; // tek tarih varsa bunu kullan
	    private String bastar; // aralık
	    private String bittar;
	    private String olusturan;
	    private String bayi;
	    private String statu;
	    private String isemriTip;
	    private String onayVeren;
	    private Integer iscilikDurumu;
	    private BigDecimal sure;
	    private String durum;
	    private BigDecimal tutar;
	    private String marka;
	    private String model;
	    private String resmimi;
	    
	    

}
