package com.kaya.erp.kayaerp.service.servisarac;

//import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoServisAracFilter;
import com.kaya.erp.kayaerp.entity.model.ServisArac;
import com.kaya.erp.kayaerp.repository.servisArac.ServisAracJpa;
import com.kaya.erp.kayaerp.util.AppUtil;


@Service
public class ServisAracServiceImpl implements IServisAracService {

	@Autowired
	private ServisAracJpa servisAracRepository;

	@Override
	public List<ServisArac> getAllServisArac() {

		return servisAracRepository.findAll();
	}

	@Override
	public ServisArac getServisAracByIdServisArac(Long ARACID) {
		if (ARACID != null) {

			Optional<ServisArac> servisaracOptional = servisAracRepository.findById(ARACID);

			if (servisaracOptional.isPresent()) {

				return servisaracOptional.get();
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Servis Arac Bulunamadı: ID = " + ARACID);
		} else {

			throw new IllegalArgumentException("Stok Id Giriniz!");
		}

	}

	@Override
	public List<ServisArac> getServisAracByMARKA(String MARKA) {
		if (MARKA.isEmpty()) {
			throw new IllegalArgumentException("Marka Adi Giriniz!");

		}

		return servisAracRepository.getServisAracByMARKA(MARKA);
	}

	@Override
	public List<ServisArac> getServisAracByMODEL(String MODEL) {
		if (MODEL.isEmpty()) {
			throw new IllegalArgumentException("Model Adi Giriniz!");

		}

		return servisAracRepository.getServisAracByMODEL(MODEL);
	}

	@Override
	public List<ServisArac> getServisAracByPLAKA(String PLAKA) {
		if (PLAKA.isEmpty()) {
			throw new IllegalArgumentException("Plaka Adi Giriniz!");

		}

		return servisAracRepository.getServisAracByPLAKA(PLAKA);
	}

	@Override
	public ServisArac getServisAracBySASI(String SASI) {
		if (SASI.isEmpty()) {
			throw new IllegalArgumentException("Sasi Adi Giriniz!");

		}

		return servisAracRepository.getServisAracBySASI(SASI);
	}

	

	@Override
	public List<ServisArac> getServisAracByEKLENMETARIHI(String bastar, String bittar) {

		// Tarih formatını düzgün bir şekilde dönüştürmeliyiz
		Date bastarDate = AppUtil.parseDateFromStringToDate(bastar);
		Date bittarDate =  AppUtil.parseDateFromStringToDate(bittar);

		return servisAracRepository.getServisAracByEKLENMETARIHI(bastarDate, bittarDate);
	}

	

	@Override
	public ServisArac addServisArac(ServisArac servisArac) {
		if (servisArac.getMARKA() == null || servisArac.getMARKA().isEmpty()) {
			throw new IllegalArgumentException("Marka Adı Giriniz!");
		}
		if (servisArac.getMODEL() == null || servisArac.getMODEL().isEmpty()) {
			throw new IllegalArgumentException("Model Adı Giriniz!");
		}

		ServisArac eklenenServisArac = new ServisArac();

		try {

			eklenenServisArac = servisAracRepository.save(servisArac);

		} catch (Exception e) {
			String exeptionString = e.getMessage();
		}

		return eklenenServisArac; // Veriyi kaydediyoruz
	}

	@Override
	public List<ServisArac> addServisAracList(List<ServisArac> servisAracList) {
		// Gerekli validasyonları burada yapabilirsiniz.
		return servisAracRepository.saveAll(servisAracList);
	}

	@Override
	public void deleteServisArac(Long ARACID) {
  
		Optional<ServisArac> servisArac = servisAracRepository.findById(ARACID);

		
		if (servisArac.isPresent()) {

			try {
				servisAracRepository.deleteById(ARACID);
				
			} catch (Exception e) {

				throw new IllegalArgumentException(e.getMessage());

			}

		} else {
			throw new IllegalArgumentException("ServisArac bulunamadı!");
		}
	}

	@Override
	public List<ServisArac> getServisAracByDtoServiceAracFilter(DtoServisAracFilter filter) {
		// TODO Auto-generated method stub
		return servisAracRepository.getServisAracByDtoServiceAracFilter(filter);
	}

	// Tek bir ServisArac eklemek için metod
	// public ServisArac addServisArac(ServisArac servisArac) {
	// Gerekli validasyonları burada yapabilirsiniz.
	// return servisaracRepository.save(servisArac);
}
