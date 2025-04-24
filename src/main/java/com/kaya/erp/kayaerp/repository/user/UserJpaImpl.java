package com.kaya.erp.kayaerp.repository.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;


import com.kaya.erp.kayaerp.entity.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserJpaImpl implements ICustomUser{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public User findByUsernameAndPassword (String username,String password) {
		String sql = "SELECT * FROM User_Tb WHERE username = :username AND usarpass  = :password";
		try {
			User user = (User) entityManager
					.createNativeQuery(sql, User.class)
	                .setParameter("username", username)
	                .setParameter("password", password)
	                .getSingleResult();
			
			return user;
		}catch (NoResultException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kullanıcı Bulunamadı!");
		}
	}
}