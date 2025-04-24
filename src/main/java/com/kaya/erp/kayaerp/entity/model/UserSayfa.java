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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Sayfa_Tb") // Tablonun adı
public class UserSayfa {


	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan ID
	    @Column(name = "id")
	    private int id;
	  
	  	private int user_id;
	  	
	  	private int sayfa_id;
	  	
	  	private String sayfa_erisimi_statu;
	
}
