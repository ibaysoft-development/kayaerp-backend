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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Role_Sayfa_Tb") // Tablonun adı
public class RoleSayfa {

	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan ID
	    @Column(name = "id")
	    private int id;
	  
	  	private int role_id;
	  	
	  	private int sayfa_id;
	  	
	  	private Timestamp create_date;
	
	  	
	 // Özel Constructor (id dahil değil çünkü DB tarafından otomatik atanıyor)
	    public RoleSayfa(int role_id, int sayfa_id, Timestamp create_date) {
	        this.role_id = role_id;
	        this.sayfa_id = sayfa_id;
	        this.create_date = create_date;
	    }
}
