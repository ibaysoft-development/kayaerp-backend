package com.kaya.erp.kayaerp.repository.gorusmeAtama;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.model.GorusmeAtama;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GorusmeAtamaJpaImpl implements ICustomGorusmeAtama {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public GorusmeAtama getGorusmeAtamaByGid(Integer gid) {

		String sql = "SELECT * FROM Gorusme_Atama_Tb WHERE gid = :gid";
		List<GorusmeAtama> result = entityManager.createNativeQuery(sql, GorusmeAtama.class).setParameter("gid", gid).getResultList();
		if (result.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Görüşme bulunamadı");
		}
		return result.get(0);
	}
	
}
