package com.kaya.erp.kayaerp.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.User;
import com.kaya.erp.kayaerp.repository.user.ICustomUser;


public interface UserJpa extends JpaRepository<User,Integer>,ICustomUser {
	
}