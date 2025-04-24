package com.kaya.erp.kayaerp.repository.musteriKarti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoServisAracFilter;
import com.kaya.erp.kayaerp.entity.model.MusteriKarti;
import com.kaya.erp.kayaerp.repository.servisArac.ICustomServisArac;
import com.kaya.erp.kayaerp.util.AppUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository

public class MusteriKartiJpaImpl implements ICustomMusteriKarti {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
	@Override
	public List <MusteriKarti> getMusteriKartiByTCNO(String TCNO) {
	    String sql = "SELECT * FROM Musterikarti_Tb WHERE TCNO = :TCNO";
	    try {
			List <MusteriKarti> musteriKartiList = entityManager
					.createNativeQuery(sql, MusteriKarti.class)
					.setParameter("TCNO", TCNO)
					.getResultList();
			if(AppUtil.isListNullOrEmpty(musteriKartiList)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TCNO Bulunamadı!");
		}
			return musteriKartiList;
		} catch (NoResultException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		    }
		}

	
	


	
}