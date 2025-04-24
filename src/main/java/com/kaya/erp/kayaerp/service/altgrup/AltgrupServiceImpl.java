package com.kaya.erp.kayaerp.service.altgrup;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.model.Altgrup;
import com.kaya.erp.kayaerp.repository.altgrup.AltgrupJpa;


@Service
public class AltgrupServiceImpl implements IAltgrupService {

	@Autowired
	private AltgrupJpa altgrupRepository;

	@Override
	public List<Altgrup> getAllAltgrup() {

		return altgrupRepository.findAll();
	}

	@Override
	public Altgrup getAltgrupByIdAltgrup(Integer id) {

		if (id != null) {

			Optional<Altgrup> altgrupOptional = altgrupRepository.findById(id);

			if (altgrupOptional.isPresent()) {

				return altgrupOptional.get();
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Altgrup Bulunamadı: ID = " + id);
		} else {

			throw new IllegalArgumentException("Altgrup Id Giriniz!");
		}

	}

	@Override
	public List<Altgrup>getAltgrupByAltgrupAdi(String altgrupAdi) {
		
		return altgrupRepository.getAltgrupByAltgrupAdi(altgrupAdi);
	}

	
	
	@Override
	public List<Altgrup> getAltgrupByAltgrupDealer(String altgrup_dealer) {
		if (altgrup_dealer.isEmpty()) {
			throw new IllegalArgumentException("Altgrup Dealer Giriniz!");

		}

		return altgrupRepository.getAltgrupByAltgrupDealer(altgrup_dealer);
	}
	
	@Override
	public List<Altgrup> getAltgrupByAltgrupKodu(String altgrup_kodu) {
		
		if (altgrup_kodu.isEmpty()) {
			throw new IllegalArgumentException("Altgrup Dealer Giriniz!");

		}

		return altgrupRepository.getAltgrupByAltgrupKodu(altgrup_kodu);
	}


	@Override
	public List<Altgrup> getAltgrupByAllAltgrupAnagrupId(Integer anagrup_id) {
		return altgrupRepository.getAltgrupByAllAltgrupAnagrupId(anagrup_id);
	}

	@Override
	public List<Altgrup> getAltgrupByAltgrupAnagrupId(String altgrup_kodu ,Integer anagrup_id ) {
		return altgrupRepository.getAltgrupByAltgrupAnagrupId(altgrup_kodu, anagrup_id);
	}

	@Override
	public Altgrup addAltgrup(Altgrup altgrup) {
		if (altgrup.getAltgrupDealer() == null || altgrup.getAltgrupDealer().isEmpty()) {
			throw new IllegalArgumentException("Altgrup Dealer Giriniz!");
		}

		Altgrup eklenenAltgrup = new Altgrup();

		try {

			eklenenAltgrup = altgrupRepository.save(altgrup);

		} catch (Exception e) {
			String exeptionString = e.getMessage();
		}

		return eklenenAltgrup; 
	}

	public List<Altgrup> addAltgrupList(List<Altgrup> altgrupList) {
		
		return altgrupRepository.saveAll(altgrupList);
	}

	public void deleteAltgrup(Integer id) {
  
		Optional<Altgrup> altgrup = altgrupRepository.findById(id);

		
		if (altgrup.isPresent()) {

			try {
				altgrupRepository.deleteById(id);
				
			} catch (Exception e) {

				throw new IllegalArgumentException(e.getMessage());

			}

		} else {
			throw new IllegalArgumentException("ServisArac bulunamadı!");
		}
	}
	
	
}
	
	
