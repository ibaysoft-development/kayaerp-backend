package com.kaya.erp.kayaerp.repository.gorusme;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoGorusmeFilter;
import com.kaya.erp.kayaerp.entity.model.Gorusme;
import com.kaya.erp.kayaerp.util.AppUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class GorusmeJpaImpl implements ICustomGorusme {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override 
	public List <Gorusme>  getGorusmeByGorusmeUsername (String gusername) {
		String sql = "Select * FROM Gorusme  WHERE  .gusername=:gusername";
		try {
			List <Gorusme> gorusmeList = entityManager
			.createNativeQuery(sql, Gorusme.class)
			.setParameter("gusername", gusername)
			.getResultList();
			
			if(AppUtil.isListNullOrEmpty(gorusmeList))  {
				 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gorusme kullanıcı adı Bulunamadı!");
			 }
			return gorusmeList;
		} catch (NoResultException e) {
			 return null;
	   }
    }
	
	  @Override
	    public List<Gorusme> getGorusmeByFilter(DtoGorusmeFilter filter) {
	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Gorusme> cq = cb.createQuery(Gorusme.class);
	        Root<Gorusme> root = cq.from(Gorusme.class);

	        List<Predicate> predicates = new ArrayList<>();

	        if (filter.getGid() != null)
	            predicates.add(cb.equal(root.get("gid"), filter.getGid()));
	        if (filter.getGtipi() != null)
	            predicates.add(cb.equal(root.get("gtipi"), filter.getGtipi()));
	        if (filter.getGanagrup() != null)
	            predicates.add(cb.equal(root.get("ganagrup"), filter.getGanagrup()));
	        if (filter.getGaltgrup() != null)
	            predicates.add(cb.equal(root.get("galtgrup"), filter.getGaltgrup()));
	        if (filter.getGmarka() != null)
	            predicates.add(cb.equal(root.get("gmarka"), filter.getGmarka()));
	        if (filter.getGmodel() != null)
	            predicates.add(cb.equal(root.get("gmodel"), filter.getGmodel()));
	        if (filter.getGmusteri() != null)
	            predicates.add(cb.like(root.get("gmusteri"), "%" + filter.getGmusteri() + "%"));
	        if (filter.getGtel() != null)
	            predicates.add(cb.equal(root.get("gtel"), filter.getGtel()));
	        if (filter.getGaciklama() != null)
	            predicates.add(cb.like(root.get("gaciklama"), "%" + filter.getGaciklama() + "%"));
	        if (filter.getGdealer() != null)
	            predicates.add(cb.equal(root.get("gdealer"), filter.getGdealer()));
	        if (filter.getGusername() != null)
	            predicates.add(cb.equal(root.get("gusername"), filter.getGusername()));
	        if (filter.getGstatu() != null)
	            predicates.add(cb.equal(root.get("gstatu"), filter.getGstatu()));
	        if (filter.getGstatubilgi() != null)
	            predicates.add(cb.equal(root.get("gstatubilgi"), filter.getGstatubilgi()));
	        if (filter.getGfiyat() != null)
	            predicates.add(cb.equal(root.get("gfiyat"), filter.getGfiyat()));
	        if (filter.getGbizinerdenduydunuz() != null)
	            predicates.add(cb.equal(root.get("gbizinerdenduydunuz"), filter.getGbizinerdenduydunuz()));
	        if (filter.getSmsid() != null)
	            predicates.add(cb.equal(root.get("smsid"), filter.getSmsid()));
	        if (filter.getBizinedentercihetmedi() != null)
	            predicates.add(cb.equal(root.get("bizinedentercihetmedi"), filter.getBizinedentercihetmedi()));
	        if (filter.getEmail() != null)
	            predicates.add(cb.equal(root.get("email"), filter.getEmail()));
	        if (filter.getStokadi() != null)
	            predicates.add(cb.equal(root.get("stokadi"), filter.getStokadi()));
	        if (filter.getTalepedilenmarka() != null)
	            predicates.add(cb.equal(root.get("talepedilenmarka"), filter.getTalepedilenmarka()));

	        // Tarih Aralığı (String olarak gelen)
	        if (filter.getBastar() != null && filter.getBittar() != null) {
	            try {               
	                predicates.add(cb.between(root.get("gtarih"), AppUtil.parseDateFromStringToDate(filter.getBastar()), AppUtil.parseDateFromStringToDate(filter.getBittar())));
	            } catch (DateTimeParseException e) {
	                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tarih formatı hatalı! Beklenen: yyyy-MM-dd HH:mm:ss");
	            }
	        }

	        cq.where(cb.and(predicates.toArray(new Predicate[0])));
	        return entityManager.createQuery(cq).getResultList();
	    }
}
