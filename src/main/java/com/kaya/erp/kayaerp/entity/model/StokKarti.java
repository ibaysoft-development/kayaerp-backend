package com.kaya.erp.kayaerp.entity.model;

import java.sql.Timestamp;

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
@Table(name = "Stok_Karti_Tb")
public class StokKarti {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "sid")
	private Integer sid;

	@Column(name = "saciklamasi", length = 150)
	private String saciklamasi;
	
	@Column(name = "sadi", length = 150)
	private String sadi;
	
	@Column(name = "saltgrup", length = 150)
	private String saltgrup;
	
	@Column(name = "saltgrupid")
	private String saltgrupid;
	
	@Column(name = "sanagrup", length = 150)
	private String sanagrup;
	
	@Column(name = "sanagrupid")
	private String sanagrupid;
	
	@Column(name = "sbirim", length = 150)
	private String sbirim;
	
	@Column(name = "sbirimfiyati", length = 150)
	private Double sbirimfiyati;
	
	@Column(name = "scins", length = 150)
	private String scins;
	
	@Column(name = "sdealer", length = 150)
	private String sdealer;
	
	@Column(name = "sdepoid")
	private int sdepoid;
	
	@Column(name = "sdepokodu", length = 150)
	private String sdepokodu;
	
	@Column(name = "seklenmetarihi", length = 150)
	private Timestamp seklenmetarihi;
	
	@Column(name = "sekleyen", length = 150)
	private String sekleyen;
	
	@Column(name = "skisaisim", length = 150)
	private String skisaisim;
	
	@Column(name = "skodu", length = 150)
	private String skodu;
	
	@Column(name = "smuhkod", length = 150)
	private String smuhkod;
	
	@Column(name = "sozelgrup", length = 150)
	private String sozelgrup;
	
	@Column(name = "sozelgrupid")
	private int sozelgrupid;
	
	@Column(name = "srafomru")
	private int srafomru;
	
	@Column(name = "supdatedate", length = 150)
	private Timestamp supdatedate;
	
	@Column(name = "supdateuser", length = 150)
	private String supdateuser;
	
	@Column(name = "svergi", length = 150)
	private Double svergi;
	
	@Column(name = "svergipointer", length = 150)
	private int svergipointer;
	
	@Column(name = "syazici", length = 150)
	private String syazici;
	
	@Column(name = "msureticikod", length = 150)
	private String msureticikod;
	
	@Column(name = "msprimkod", length = 150)
	private String msprimkod;
	
	@Column(name = "msmuhkod", length = 150)
	private String msmuhkod;
	
	@Column(name = "msmyili", length = 150)
	private String msmyili;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    
    
    
    
}
