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
@Table(name = "Musterikarti_Tb")
public class MusteriKarti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan ise

	private Long MUSID;

	private String MUSAD;

	private String MUSSOY;

	private String TCNO;

	private String ADRES;

	private String ISTEL;

	private String CEPTEL;

	private String VERDAIRE;

	private String VERNO;

	private String DYERI;

	private String EMAIL;

	private String DTAR;

	private String BABAADI;

	private String ANAADI;

	private String MESLEK;

	private String EVTEL;

	private String KIZLIK;

	private String IL;
	
	private String BAYI;
	
	private String GOREVI;
	
	private String HANEHALKSAYISI;
	
	private String CINSIYET;
	
	private String CALISMADURUMU;
	
	private String ILCE;
	
	private String SEMT;
	
	private String ISYERIADI;
	
	private String ISYERIADRESI;
	
	private Integer ILID;
	
	private Integer ILCEID;
	
	private Integer SEMTID;
	
	private String CARIKODU;
	
	private String ONAYAKTIVVASYON;
	
	private Integer KULLANIMIZNI;
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	private Date IZINISTEMETARIHI;
	
	private String EKLEYEN;
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	private Date EKLENMETARIH;
	

}