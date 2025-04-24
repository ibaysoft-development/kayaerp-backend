package com.kaya.erp.kayaerp.entity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Tb") // Tablonun adı
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan ID
    @Column(name = "id")
    private int id;

    @Column(name = "username", length = 100, unique = true, nullable = false)
    private String username;

    @Column(name = "usarpass", length = 100, nullable = false)
    private String password; // Şifre güvenlik için "password" olarak adlandırıldı

    @Column(name = "userdealer", length = 100)
    private String userDealer;

    @Column(name = "userstatu")
    private int userStatu; // Eğer 0/1 olarak tutuluyorsa Boolean olabilir

    @Column(name = "usertel", length = 100)
    private String userTel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserDealer() {
		return userDealer;
	}

	public void setUserDealer(String userDealer) {
		this.userDealer = userDealer;
	}

	public int getUserStatu() {
		return userStatu;
	}

	public void setUserStatu(int userStatu) {
		this.userStatu = userStatu;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public User(int id, String username, String password, String userDealer, int userStatu, String userTel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userDealer = userDealer;
		this.userStatu = userStatu;
		this.userTel = userTel;
	}

	public User() {
		super();
	}
    
    
    
    

   
}
