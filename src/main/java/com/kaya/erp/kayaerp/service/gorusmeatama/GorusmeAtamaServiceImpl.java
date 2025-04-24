package com.kaya.erp.kayaerp.service.gorusmeatama;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.model.GorusmeAtama;
import com.kaya.erp.kayaerp.repository.gorusmeAtama.GorusmeAtamaJpa;

@Service
public class GorusmeAtamaServiceImpl implements IGorusmeAtamaService {
	
	@Autowired
	private GorusmeAtamaJpa gorusmeatamaRepository;
	
	
	@Override
	public  GorusmeAtama getGorusmeAtamaById(Integer gaid) {
		Optional<GorusmeAtama> gorusmeAtamaOprOptional = gorusmeatamaRepository.findById(gaid);
		if(gorusmeAtamaOprOptional.isPresent()) {
			return gorusmeAtamaOprOptional.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gorusme Bulunamadı");
	}


	@Override
	public GorusmeAtama getGorusmeAtamaByGid(Integer gid) {
	
		return gorusmeatamaRepository.getGorusmeAtamaByGid(gid);
	}
	
	
	
}
