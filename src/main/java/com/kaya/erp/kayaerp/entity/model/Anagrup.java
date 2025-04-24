package com.kaya.erp.kayaerp.entity.model;


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
@Table(name = "Anagrup_Tb")

public class Anagrup {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan ise
    @Column(name = "id")
    private int id;
	
	@Column(name = "anagrup_dealer", length = 255)
    private String anagrupDealer;
	
	@Column (name= "anagrup_kod", length= 100)
	private String anagrupKod;
	
	@Column (name= "anagrup_adi",length= 255)
	private String anagrupAdi;
	
	@Column (name= "anagrup_sira", length =100)
	private Integer anagrupSira;
	
	
	
}

    
   
