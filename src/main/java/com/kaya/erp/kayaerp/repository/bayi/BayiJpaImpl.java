package com.kaya.erp.kayaerp.repository.bayi;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;


import com.kaya.erp.kayaerp.entity.model.Bayi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class BayiJpaImpl implements ICustomBayi{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override 
	public Bayi getBayiBybayi_kodu (String bayi_kodu) {
		String sql = "SELECT * FROM Bayi_Tb where bayi_kodu = :bayi_kodu";
		try {
			Bayi bayi = (Bayi) entityManager
					.createNativeQuery(sql,Bayi.class)
					.setParameter("bayi_kodu", bayi_kodu)
					.getSingleResult(); 
			
			return bayi;
			} catch (NoResultException e) {
				
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bayi Bulunamadı!");
			}
	}
}