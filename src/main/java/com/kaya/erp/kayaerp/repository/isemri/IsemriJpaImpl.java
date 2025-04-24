package com.kaya.erp.kayaerp.repository.isemri;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoIsemriFilter;
import com.kaya.erp.kayaerp.entity.model.Isemri;
import com.kaya.erp.kayaerp.util.AppUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class IsemriJpaImpl implements ICustomIsemirleri{

	

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Isemri> getIsemriByOlusturan(String olusturan) {
    	
        String sql = "SELECT * FROM KAYAERP.dbo.Isemri_Tb WHERE olusturan = :olusturan";
        Query query = entityManager.createNativeQuery(sql, Isemri.class);
        query.setParameter("olusturan", olusturan);
        return query.getResultList();
    }

	@Override
	public List<Isemri> getIsemriByTarih(Date bastar,Date bittar) {
		
		
		  String sql = "SELECT * FROM KAYAERP.dbo.Isemri_Tb WHERE TARIH >= :bastar and TARIH <=:bittar";
	        Query query = entityManager.createNativeQuery(sql, Isemri.class);
	        query.setParameter("bastar", bastar);
	        query.setParameter("bittar", bittar);
	        
	        List<Isemri> isemriDbIsemris = query.getResultList();
	        
	        if(AppUtil.isListNullOrEmpty(isemriDbIsemris)) {
	        	
	        	return isemriDbIsemris;
	        }else {
	        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bu tarih aralıgında Isemri Bulunamadı!");
	        	
	        }
	         
	}
	
	@Override
	public List<Isemri> findIsemriByFilter(DtoIsemriFilter filter) {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Isemri> cq = cb.createQuery(Isemri.class);
	    Root<Isemri> root = cq.from(Isemri.class);

	    List<Predicate> predicates = new ArrayList<>();

	    if (filter.getIsemriId() != null)
	        predicates.add(cb.equal(root.get("isemriId"), filter.getIsemriId()));

	    if (filter.getMusId() != null)
	        predicates.add(cb.equal(root.get("musId"), filter.getMusId()));

	    if (filter.getMusTip() != null)
	        predicates.add(cb.equal(root.get("musTip"), filter.getMusTip()));

	    if (filter.getMusteri() != null)
	        predicates.add(cb.like(root.get("musteri"), "%" + filter.getMusteri() + "%"));

	    if (filter.getTelefon() != null)
	        predicates.add(cb.equal(root.get("telefon"), filter.getTelefon()));

	    if (filter.getKm() != null)
	        predicates.add(cb.equal(root.get("km"), filter.getKm()));

	    if (filter.getPlaka() != null)
	        predicates.add(cb.equal(root.get("plaka"), filter.getPlaka()));

	    if (filter.getAracId() != null)
	        predicates.add(cb.equal(root.get("aracId"), filter.getAracId()));

	    if (filter.getTarih() != null)
	        predicates.add(cb.equal(root.get("tarih"), filter.getTarih()));

	    // 🔥 Tarih aralığı kontrolü
	    if (filter.getBastar() != null && filter.getBittar() != null) {
	        try {
//	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	            LocalDateTime start = LocalDateTime.parse(filter.getBastar(), formatter);
//	            LocalDateTime end = LocalDateTime.parse(filter.getBittar(), formatter);

	            predicates.add(cb.between(
	                root.get("tarih"),
	                AppUtil.parseDateFromStringToDate(filter.getBastar()),
	                AppUtil.parseDateFromStringToDate(filter.getBittar())
	            ));
	        } catch (DateTimeParseException e) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tarih formatı yanlış! Beklenen: yyyy-MM-dd HH:mm:ss");
	        }
	    }
	    if (filter.getOlusturan() != null)
	        predicates.add(cb.equal(root.get("olusturan"), filter.getOlusturan()));

	    if (filter.getBayi() != null)
	        predicates.add(cb.equal(root.get("bayi"), filter.getBayi()));

	    if (filter.getStatu() != null)
	        predicates.add(cb.equal(root.get("statu"), filter.getStatu()));

	    if (filter.getIsemriTip() != null)
	        predicates.add(cb.equal(root.get("isemriTip"), filter.getIsemriTip()));

	    if (filter.getOnayVeren() != null)
	        predicates.add(cb.equal(root.get("onayVeren"), filter.getOnayVeren()));

	    if (filter.getIscilikDurumu() != null)
	        predicates.add(cb.equal(root.get("iscilikDurumu"), filter.getIscilikDurumu()));

	    if (filter.getSure() != null)
	        predicates.add(cb.equal(root.get("sure"), filter.getSure()));

	    if (filter.getDurum() != null)
	        predicates.add(cb.equal(root.get("durum"), filter.getDurum()));

	    if (filter.getTutar() != null)
	        predicates.add(cb.equal(root.get("tutar"), filter.getTutar()));

	    if (filter.getMarka() != null)
	        predicates.add(cb.equal(root.get("marka"), filter.getMarka()));

	    if (filter.getModel() != null)
	        predicates.add(cb.equal(root.get("model"), filter.getModel()));

	    if (filter.getResmimi() != null)
	        predicates.add(cb.equal(root.get("resmimi"), filter.getResmimi()));

	    cq.where(cb.and(predicates.toArray(new Predicate[0])));
	    TypedQuery<Isemri> query = entityManager.createQuery(cq);
	    return query.getResultList();
	}

    
	
	
	
	
	
	
}
