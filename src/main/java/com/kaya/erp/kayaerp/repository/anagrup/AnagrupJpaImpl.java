package com.kaya.erp.kayaerp.repository.anagrup;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.model.Anagrup;
import com.kaya.erp.kayaerp.util.AppUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

public class AnagrupJpaImpl implements ICustomAnagrup {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override 
	public List <Anagrup>  getAnagrupByAnagrupDealer (String anagrup_dealer) {
		String sql = "Select * from Anagrup_Tb where anagrup_dealer=:anagrup_dealer";
		try {
			List <Anagrup> anagrupList = entityManager
			.createNativeQuery(sql, Anagrup.class)
			.setParameter("anagrup_dealer", anagrup_dealer)
			.getResultList();
			
			if(AppUtil.isListNullOrEmpty(anagrupList))  {
				 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anagrup Adi Bulunamadı!");
			 }
			return anagrupList;
		} catch (NoResultException e) {
			 return null;
	   }
	}

	@Override
	public Anagrup getAnagrupByAnagrupKod(String anagrup_kod) {
		String sql="Select * from Anagrup_Tb  where anagrup_kod=:anagrup_kod";
		try {
			Anagrup anagrup = (Anagrup) entityManager
					.createNativeQuery(sql,  Anagrup.class)
	                .setParameter("anagrup_kod", anagrup_kod)
	                .getSingleResult();
			
			return anagrup;
		} catch (NoResultException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Anagrup Kodu Bulunamadı!");
	}
  }
}

