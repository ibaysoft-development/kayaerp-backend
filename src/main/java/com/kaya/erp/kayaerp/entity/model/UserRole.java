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
@Table(name = "User_Role_Tb") // Tablonun adı
public class UserRole {

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan ID
	    @Column(name = "id")
	    private int id;
	  
	  	private int user_id;
	  	
	  	private int role_id;
	  	
	  	private Timestamp create_date;

		public UserRole(Integer user_id, int role_id, Timestamp create_date) {
			super();
			this.user_id = user_id;
			this.role_id = role_id;
			this.create_date = create_date;
		}
	  	
	  	
	
}
