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
@Table(name = "User_Bayi_Tb")
public class UserBayi {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan ID
	    @Column(name = "id")
	    private int id;
	  
	  	private int user_id;
	  	
	  	private int bayi_id;
	  	
	  	private Timestamp create_date;

		public UserBayi(int user_id, int bayi_id, Timestamp create_date) {
			super();
			this.user_id = user_id;
			this.bayi_id = bayi_id;
			this.create_date = create_date;
		}
	  	
	  	

}
