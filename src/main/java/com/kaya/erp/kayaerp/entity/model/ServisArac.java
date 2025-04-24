package com.kaya.erp.kayaerp.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SERVISARAC")
public class ServisArac {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "ARACID")
	private Long ARACID;

	@Column(name = "MARKA", length = 150)
	private String MARKA;
	
	@Column(name = "MODEL", length = 150)
	private String MODEL;
	
	@Column(name = "BAZARAC", length = 150)
	private String BAZARAC;
	
	@Column(name = "ARACTIP", length = 150)
	private String ARACTIP;
	
	@Column(name = "PLAKA", length = 150)
	private String PLAKA;
	
	@Column(name = "RUHSATSAHIBI")
	private Long RUHSATSAHIBI;
	
	@Column(name = "RUHSATSAHIBITIP", length = 150)
	private String RUHSATSAHIBITIP;
	
	@Column(name = "SASI", length = 150)
	private String SASI;
	
	@Column(name = "MOTOR", length = 150)
	private String MOTOR;
	
	@Column(name = "RUHSATSAHIBIADI", length = 150)
	private String RUHSATSAHIBIADI;
	
	@Column(name = "KM")
	private Long KM;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	@Column(name = "TESCILTARIHI", length = 150)
	private Date TESCILTARIHI;
	
	@Column(name = "MODELYILI")
	private Long MODELYILI;
	
	@Column(name = "BAYI", length = 150)
	private String BAYI;
	
	@Column(name = "EKLEYEN", length = 150)
	private String EKLEYEN;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	@Column(name = "EKLENMETARIHI", length = 150)
	private Date EKLENMETARIHI;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	@Column(name = "MUAYENETARIHI", length = 150)
	private Date MUAYENETARIHI;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	@Column(name = "EGZOSTARIHI", length = 150)
	private Date EGZOSTARIHI;
	
	@Column(name = "SOFORADI", length = 150)
	private String SOFORADI;
	
	@Column(name = "SOFORTEL", length = 150)
	private String SOFORTEL;
	
	@Column(name = "MOTORCC", length = 150)
	private String MOTORCC;
	
	@Column(name = "RENK", length = 150)
	private String RENK;
}
	
	
	
	
	