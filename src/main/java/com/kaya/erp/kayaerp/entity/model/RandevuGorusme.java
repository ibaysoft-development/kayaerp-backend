package com.kaya.erp.kayaerp.entity.model;

import java.sql.Timestamp;
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
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Randevu_Gorusme_Tb")
public class RandevuGorusme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan ise
	
    private Integer rid;
	
	
	private String rbaslatanuser;
	
	private String rmusteriadi;
	
	//private String rmusterisoyadi;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "Europe/Istanbul")
	
	private Date rtarih;
	
	private String rdealer;
	
	private String rmusteritel;
	
	private String rmusteriemail;
	
	//public RandevuGorusme(String rmusteriemail,String rmusteriadi) {
		//this.rmusteriemail=rmusteriemail;
		
	//}
	
	

	

}