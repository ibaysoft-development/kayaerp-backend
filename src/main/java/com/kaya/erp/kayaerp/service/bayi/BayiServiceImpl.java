package com.kaya.erp.kayaerp.service.bayi;

import java.util.List;
import java.util.Optional;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.model.Bayi;
import com.kaya.erp.kayaerp.repository.bayi.BayiJpa;

@Service
public class BayiServiceImpl implements IBayiService {

	@Autowired
	private BayiJpa bayiRepository;

	@Override
	public List<Bayi> getAllBayi() {

		return bayiRepository.findAll();
	}

	@Override
	public Bayi getBayiByIdBayi(Integer id) {

		if (id != null) {

			Optional<Bayi> bayiOptional = bayiRepository.findById(id);

			if (bayiOptional.isPresent()) {

				return bayiOptional.get();
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bayi Bulunamadı: ID = " + id);
		} else {

			throw new IllegalArgumentException("Bayi Id Giriniz!");
		}

	}

	@Override
	public Bayi getBayiBybayi_kodu(String bayi_kodu) {

		if (bayi_kodu.isEmpty()) {
			throw new IllegalArgumentException("Bayi Kodu Giriniz!");

		}

		return bayiRepository.getBayiBybayi_kodu(bayi_kodu);
	}

	@Override
	public Bayi addBayi(Bayi Bayi) {

		if (Bayi == null) {
			throw new IllegalArgumentException("Bayi  Giriniz!");
		}
		
		Bayi eklenenBayi = new Bayi();
		
		try {
			eklenenBayi = bayiRepository.save(Bayi);
		} catch (Exception e) {
			String exeptionString = e.getMessage();
		}
		return eklenenBayi;
	}
   
	public List <Bayi> addBayiList (List <Bayi> bayiList) {
		return bayiRepository.saveAll(bayiList);
	}
	
	public void deleteBayi( Integer id) {
		Optional<Bayi> Bayi = bayiRepository.findById(id);
		
		if (Bayi.isPresent())  {
			
			try {
				bayiRepository .deleteById(id);
				
			} catch (Exception e) {
				throw new IllegalArgumentException(" Bayi bulunamadı!");
			}
		}
	}
}
