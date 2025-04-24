package com.kaya.erp.kayaerp.repository.altgrup;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.model.Altgrup;
import com.kaya.erp.kayaerp.util.AppUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;


public class AltgrupJpaImpl implements ICustomAltgrup {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	public List <Altgrup> getAltgrupByAltgrupDealer (String altgrup_dealer) {
		String sql = "Select * from Altgrup_Tb  where altgrup_dealer=:altgrup_dealer";
		try {
			List <Altgrup> altgrupList = entityManager
					.createNativeQuery (sql,Altgrup.class)
					.setParameter("altgrup_dealer", altgrup_dealer)
					.getResultList();
			
			if(AppUtil.isListNullOrEmpty(altgrupList))  {
				 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Altgrup Dealer Bulunamadı!");
			 }
			return altgrupList;
		} catch (NoResultException e) {
			return null;
		}
	}


@Override
public List <Altgrup> getAltgrupByAltgrupKodu(String altgrup_kodu) {
String sql= "Select * from Altgrup_Tb o where altgrup_kodu=:altgrup_kodu";
try {
	List <Altgrup> altgrupList = entityManager
			.createNativeQuery (sql,Altgrup.class)
			.setParameter("altgrup_kodu", altgrup_kodu)
			.getResultList();
	
	    if(AppUtil.isListNullOrEmpty(altgrupList))  {
		    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Altgrup Kodu Bulunamadı!");
	   }
	     return altgrupList;
          } catch (NoResultException e) {
	return null;
      }
   }



@Override
public List <Altgrup> getAltgrupByAltgrupAdi(String altgrup_adi) {
String sql= "Select * from Altgrup_Tb  where altgrup_adi=:altgrup_adi";
try {
	List <Altgrup> altgrupList = entityManager
			.createNativeQuery (sql,Altgrup.class)
			.setParameter("altgrup_adi", altgrup_adi)
			.getResultList();
	
	    if(AppUtil.isListNullOrEmpty(altgrupList))  {
		    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Altgrup Adi Bulunamadı!");
	   }
	     return altgrupList;
          } catch (NoResultException e) {
	return null;
      }
   }


@Override
public List <Altgrup> getAltgrupByAltgrupAnagrupId(String altgrup_kodu, Integer anagrup_id) {
String sql= "Select * from Altgrup_Tb  where altgrup_kodu=:altgrup_kodu and anagrup_id=:anagrup_id";
try {
	List <Altgrup> altgrupList = entityManager
			.createNativeQuery (sql,Altgrup.class)
			.setParameter("altgrup_kodu", altgrup_kodu)
			.setParameter("anagrup_id", anagrup_id)
			.getResultList();
	
	    if(AppUtil.isListNullOrEmpty(altgrupList))  {
		    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Altgrup Adi Bulunamadı!");
	   }
	     return altgrupList;
          } catch (NoResultException e) {
	return null;
      }
   }


@Override
public List <Altgrup> getAltgrupByAllAltgrupAnagrupId(Integer anagrup_id) {
String sql= "SELECT * FROM Altgrup_Tb WHERE anagrup_id =:anagrup_id";
try {
	List <Altgrup> altgrupList = entityManager
			.createNativeQuery (sql,Altgrup.class)
			.setParameter("anagrup_id", anagrup_id)
			.getResultList();
	
	    if(AppUtil.isListNullOrEmpty(altgrupList))  {
		    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Altgrup Adi Bulunamadı!");
	   }
	     return altgrupList;
          } catch (NoResultException e) {
	return null;
      }
   }
}



