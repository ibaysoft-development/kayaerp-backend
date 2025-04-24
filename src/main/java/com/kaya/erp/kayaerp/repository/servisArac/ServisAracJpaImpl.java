package com.kaya.erp.kayaerp.repository.servisArac;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoServisAracFilter;
import com.kaya.erp.kayaerp.entity.model.ServisArac;
import com.kaya.erp.kayaerp.util.AppUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository

public class ServisAracJpaImpl implements ICustomServisArac {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
//	@Override
//	public List <ServisArac> getServisAracByMARKA(String MARKA) {
//		String sql = "SELECT * FROM SERVISARAC b where b.MARKA =:MARKA";
//	try {
//		List <ServisArac> servisAracList = entityManager
//				.createNativeQuery(sql, ServisArac.class)
//				.setParameter("MARKA", MARKA)
//				.getResultList();
//		if(servisAracList == null) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marka Bulunamadı!");
//		}
//		return servisAracList;
//	} catch (NoResultException e) {
//		return null;
//	    }
//	}
	
	@Override
	public List <ServisArac> getServisAracByMARKA(String MARKA) {
		String sql = "SELECT * FROM SERVISARAC where MARKA =:MARKA";
	try {
		List <ServisArac> servisAracList  = entityManager
				.createNativeQuery(sql, ServisArac.class)
				.setParameter("MARKA", MARKA)
				.getResultList();
		if(AppUtil.isListNullOrEmpty(servisAracList)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marka Bulunamadı!");
		}
		return servisAracList ;
	} catch (NoResultException e) {
		return null;
	    }
	}
	
	@Override
	public List <ServisArac> getServisAracByMODEL(String MODEL) {
		String sql = "SELECT * FROM SERVISARAC where MODEL =:MODEL";
	try {
		List <ServisArac> servisAracList =entityManager
				.createNativeQuery(sql, ServisArac.class)
				.setParameter("MODEL", MODEL)
				.getResultList();
		if(AppUtil.isListNullOrEmpty(servisAracList)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Model Bulunamadı!");
		}
		return servisAracList;
	} catch (NoResultException e) {
		return null;
	    }
	}
	
	@Override
	public List <ServisArac> getServisAracByPLAKA(String PLAKA) {
		String sql = "SELECT * FROM SERVISARAC where PLAKA =:PLAKA";
	try {
		List <ServisArac> servisAracList = entityManager
				.createNativeQuery(sql, ServisArac.class)
				.setParameter("PLAKA", PLAKA)
				.getResultList();
		if(AppUtil.isListNullOrEmpty(servisAracList)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Plaka Bulunamadı!");
		}
		return servisAracList;
	} catch (NoResultException e) {
		return null;
	    }
	}
	
	
	//@Override
	//public ServisArac getServisAracBySASI(String SASI) {
//		String sql = "SELECT * FROM SERVISARAC  where SASI =:SASI";
//	try {
//	   List<ServisArac>	 servisArac = entityManager
//				.createNativeQuery(sql, ServisArac.class)
//				.setParameter("SASI", SASI)
//				.getResultList();
//		
//	   if(AppUtil.isListNullOrEmpty(servisArac)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sasi Bulunamadı!");
//		}
//		return servisArac.get(0);
//	} catch (NoResultException e) {
//		return null;
//	    }
//	}
	 
	@Override
	public ServisArac getServisAracBySASI(String SASI) {
	    String sql = "SELECT * FROM SERVISARAC WHERE SASI = :SASI";
	    try {
	        // Tekil bir sonuç almak için getSingleResult kullanıyoruz
	        ServisArac servisArac = (ServisArac) entityManager
	                .createNativeQuery(sql, ServisArac.class)
	                .setParameter("SASI", SASI)
	                .getSingleResult();

	      
	        return servisArac;
	    } catch (NoResultException e) {
	    	
	    
	    	 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sasi Bulunamadı!");
	    }
	}

	
	@Override
	public List <ServisArac> getServisAracByEKLENMETARIHI(Date bastar,Date bittar) {
		String sql = "SELECT * FROM SERVISARAC b WHERE b.EKLENMETARIHI BETWEEN :bastar AND :bittar";
	try {
		List <ServisArac> servisAracList  = entityManager
				.createNativeQuery(sql, ServisArac.class)
				.setParameter("bastar", bastar)
				.setParameter("bittar", bittar)
				.getResultList();
		if(AppUtil.isListNullOrEmpty(servisAracList)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Eklenme Tarihi Bulunamadı!");
		}
		return servisAracList ;
	} catch (NoResultException e) {
		return null;
	    }
	}

	@Override
	public List<ServisArac> getServisAracByDtoServiceAracFilter(DtoServisAracFilter filter) {
		  CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<ServisArac> cq = cb.createQuery(ServisArac.class);
	        Root<ServisArac> root = cq.from(ServisArac.class);

	        List<Predicate> predicates = new ArrayList<>();

	        if (filter.getAracid() != null)
	            predicates.add(cb.equal(root.get("ARACID"), filter.getAracid()));
	        if (filter.getMarka() != null)
	            predicates.add(cb.equal(root.get("MARKA"), filter.getMarka()));
	        if (filter.getModel() != null)
	            predicates.add(cb.equal(root.get("MODEL"), filter.getModel()));
	        if (filter.getBazarac() != null)
	            predicates.add(cb.equal(root.get("BAZARAC"), filter.getBazarac()));
	        if (filter.getAractip() != null)
	            predicates.add(cb.equal(root.get("ARACTIP"), filter.getAractip()));
	        if (filter.getPlaka() != null)
	            predicates.add(cb.equal(root.get("PLAKA"), filter.getPlaka()));
	        if (filter.getRuhsatsahibi() != null)
	            predicates.add(cb.equal(root.get("RUHSATSAHIBI"), filter.getRuhsatsahibi()));
	        if (filter.getRuhsatsahibitip() != null)
	            predicates.add(cb.equal(root.get("RUHSATSAHIBITIP"), filter.getRuhsatsahibitip()));
	        if (filter.getSasi() != null)
	            predicates.add(cb.equal(root.get("SASI"), filter.getSasi()));
	        if (filter.getMotor() != null)
	            predicates.add(cb.equal(root.get("MOTOR"), filter.getMotor()));
	        if (filter.getRuhsatsahibiadi() != null)
	            predicates.add(cb.like(root.get("RUHSATSAHIBIADI"), "%" + filter.getRuhsatsahibiadi() + "%"));
	        if (filter.getKm() != null)
	            predicates.add(cb.equal(root.get("KM"), filter.getKm()));
	        if (filter.getModelyili() != null)
	            predicates.add(cb.equal(root.get("MODELYILI"), filter.getModelyili()));
	        if (filter.getBayi() != null)
	            predicates.add(cb.equal(root.get("BAYI"), filter.getBayi()));
	        if (filter.getEkleyen() != null)
	            predicates.add(cb.equal(root.get("EKLEYEN"), filter.getEkleyen()));
	        if (filter.getSoforadi() != null)
	            predicates.add(cb.equal(root.get("SOFORADI"), filter.getSoforadi()));
	        if (filter.getSofortel() != null)
	            predicates.add(cb.equal(root.get("SOFORTEL"), filter.getSofortel()));

	        if (filter.getMuayeneTarihiBastar() != null && filter.getMuayeneTarihiBittar() != null) {
	            predicates.add(cb.between(root.get("MUAYENETARIHI"),
	                   AppUtil.parseDateFromStringToDate(filter.getMuayeneTarihiBastar()),
	                   AppUtil.parseDateFromStringToDate(filter.getMuayeneTarihiBittar())));
	        }
	        
	        if (filter.getEgzosTarihiBastar()!= null && filter.getEgzosTarihiBittar() != null) {
	            predicates.add(cb.between(root.get("EGZOSTARIHI"),
	                   AppUtil.parseDateFromStringToDate(filter.getEgzosTarihiBastar()),
	                   AppUtil.parseDateFromStringToDate(filter.getEgzosTarihiBittar())));
	        }
	        
	        if (filter.getEklenmeTarihiBastar()!= null && filter.getEklenmeTarihiBittar() != null) {
	            predicates.add(cb.between(root.get("EKLENMETARIHI"),
	                   AppUtil.parseDateFromStringToDate(filter.getEklenmeTarihiBastar()),
	                   AppUtil.parseDateFromStringToDate(filter.getMuayeneTarihiBittar())));
	        }
	        
	        if (filter.getTescilTarihiBastar() != null && filter.getTescilTarihiBittar() != null) {
	            predicates.add(cb.between(root.get("TESCILTARIHI"),
	                   AppUtil.parseDateFromStringToDate(filter.getTescilTarihiBastar()),
	                   AppUtil.parseDateFromStringToDate(filter.getTescilTarihiBittar())));
	        }

	        cq.where(cb.and(predicates.toArray(new Predicate[0])));
	        return entityManager.createQuery(cq).getResultList();
	}
	
}