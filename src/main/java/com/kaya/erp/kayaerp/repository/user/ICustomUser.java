package com.kaya.erp.kayaerp.repository.user;

import com.kaya.erp.kayaerp.entity.model.User;




public interface ICustomUser {
	
	public User findByUsernameAndPassword(String Username, String Password);
	
}