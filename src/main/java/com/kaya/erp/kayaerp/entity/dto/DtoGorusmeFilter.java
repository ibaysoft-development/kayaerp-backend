package com.kaya.erp.kayaerp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGorusmeFilter {
	private Integer gid;

	private String gtipi;

	private String ganagrup;

	private String galtgrup;

	private String gmarka;

	private String gmodel;

	private String gmusteri;

	private String gtel;

	private String gaciklama;

	private String gdealer;

	private String gusername;

	private String gtarih;
	
	private String bastar;
	private String bittar;

	private Integer gstatu;

	private String gstatubilgi;

	private Double gfiyat;

	private String gbizinerdenduydunuz;

	private String smsid;

	private String bizinedentercihetmedi;

	private String email;

	private String stokadi;

	private String talepedilenmarka;
}
