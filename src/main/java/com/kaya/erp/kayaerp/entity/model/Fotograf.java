package com.kaya.erp.kayaerp.entity.model;

import java.util.Date;

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
@Table(name = "Fotograf_Tb")
public class Fotograf {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan ise
	private int id;
	private String type;
	private String sasi;
	private String pname;
	private String path;
	private Date ptarih;
	
}
