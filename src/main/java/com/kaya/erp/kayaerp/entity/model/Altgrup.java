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
@Table(name = "Altgrup_Tb")

public  class Altgrup{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan ise
    @Column(name = "id")
    private Integer id;
	
	@Column (name= "anagrup_id", length=100)
	private Integer anagrupId;
	
	@Column(name = "altgrup_dealer", length = 255)
    private String altgrupDealer;
	
	@Column (name= "altgrup_kodu", length= 100)
	private String altgrupKodu;
	
	@Column (name= "altgrup_adi",length= 255)
	private String altgrupAdi;
	
	
}


    
   
