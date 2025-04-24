package com.kaya.erp.kayaerp.entity.model;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Gorusme_Tb")
public class Gorusme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan ise

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

	private Date gtarih;

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
