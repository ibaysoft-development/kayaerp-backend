package com.kaya.erp.kayaerp.repository.stokKarti;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import com.kaya.erp.kayaerp.entity.model.StokKarti;
import com.kaya.erp.kayaerp.util.AppUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

public class StokKartiJpaImpl implements ICustomStokKarti {
	
	 @PersistenceContext
	    private EntityManager entityManager;
	 
	 @Override
	 public List <StokKarti>  getStokKartiBysadi (String sadi) {
		 String sql = "SELECT * FROM Stok_Karti_Tb  where sadi = :sadi";
		 try {
			 List <StokKarti> stokKartiList =entityManager
					 .createNativeQuery(sql, StokKarti.class)
						.setParameter("sadi", sadi)
						.getResultList();
			 if(AppUtil.isListNullOrEmpty(stokKartiList))  {
				 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stok Karti Adi Bulunamadı!");
			 }
			 return stokKartiList;
		 } catch (NoResultException e) {
			 return null;
	   }
    }
	 
}