package com.kaya.erp.kayaerp.repository.randevuGorusme;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeDoluVeBos;
import com.kaya.erp.kayaerp.entity.model.RandevuGorusme;
import com.kaya.erp.kayaerp.util.AppUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class  RandevuGorusmeJpaImpl implements ICustomRandevuGorusme {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override 
	
	public List <RandevuGorusme> getRandevuByBaslatanUser (String rbaslatanuser) {
		String sql = "Select * FROM Randevu_Gorusme_Tb  WHERE  rbaslatanuser=:rbaslatanuser";
		try {
			List <RandevuGorusme> randevuList = entityManager
			.createNativeQuery(sql, RandevuGorusme.class)
			.setParameter("rbaslatanuser", rbaslatanuser)
			.getResultList();
			
			if(AppUtil.isListNullOrEmpty(randevuList))  {
				 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Randevu başlatan kişiye ait randevu bulunmamaktadir.");
			 }
			return randevuList;
		} catch (NoResultException e) {
			 return null;
	   }
	}

//	@Override
//    public List<RandevuGorusme> findByRtarihBetween(Date start, Date end) {
//        try {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<RandevuGorusme> query = cb.createQuery(RandevuGorusme.class);
//            Root<RandevuGorusme> root = query.from(RandevuGorusme.class);
//
//            // rtarih BETWEEN start AND end
//            Predicate predicate = cb.between(root.get("rtarih"), start, end);
//            query.select(root).where(predicate);
//
//            return entityManager.createQuery(query).getResultList();
//
//        } catch (NoResultException e) {
//            return new ArrayList<>();
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
//                    "Randevular getirilirken hata oluştu: " + e.getMessage());
//        }
//    }

	@Override
    public List<RandevuGorusme> findByRtarihBetweenAndRbaslatanuser(Date start, Date end, String rbaslatanuser) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<RandevuGorusme> query = cb.createQuery(RandevuGorusme.class);
            Root<RandevuGorusme> root = query.from(RandevuGorusme.class);

            Predicate datePredicate = cb.between(root.get("rtarih"), start, end);
            Predicate userPredicate = cb.equal(root.get("rbaslatanuser"), rbaslatanuser);

            query.select(root).where(cb.and(datePredicate, userPredicate));

            return entityManager.createQuery(query).getResultList();

        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Kullanıcıya ait randevular getirilirken hata oluştu: " + e.getMessage());
        }
    }

	
	
	
}