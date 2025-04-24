package com.kaya.erp.kayaerp.service.musterikarti;

//import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoServisAracFilter;
import com.kaya.erp.kayaerp.entity.model.MusteriKarti;
import com.kaya.erp.kayaerp.repository.musteriKarti.MusteriKartiJpa;
import com.kaya.erp.kayaerp.util.AppUtil;


@Service
public class MusteriKartiServiceImpl implements IMusteriKartiService {

	@Autowired
	private MusteriKartiJpa musteriKartiRepository;
	
	@Override
	public List<MusteriKarti> getMusteriKartiByTCNO(String TCNO) {
		if (TCNO.isEmpty()) {
			throw new IllegalArgumentException("TCNO Giriniz!");

		}

		return musteriKartiRepository.getMusteriKartiByTCNO(TCNO);
	}
	
	@Override
	public MusteriKarti addMusteriKarti(MusteriKarti musteriKarti) {
	    if (musteriKarti.getTCNO() == null || musteriKarti.getTCNO().isEmpty()) {
	        throw new IllegalArgumentException("TC Kimlik Numarası boş olamaz. Lütfen geçerli bir TC Kimlik Numarası giriniz.");
	    }

	    // TCNO daha önce kayıtlı mı kontrol et
	    //List<MusteriKarti> mevcutKartiList = musteriKartiRepository.getMusteriKartiByTCNO(musteriKarti.getTCNO());
	    


	    
	    try {
	        return musteriKartiRepository.save(musteriKarti);
	    } catch (Exception e) {
	        throw new RuntimeException("Müşteri kartı eklenirken bir hata oluştu: " + e.getMessage());
	    }
	}


	
	
	@Override
	public void deleteMusteriKarti(Long MUSID) {
  
		Optional<MusteriKarti> musteriKarti = musteriKartiRepository.findById(MUSID);

		
		if (musteriKarti.isPresent()) {

			try {
				musteriKartiRepository.deleteById(MUSID);
				
			} catch (Exception e) {

				throw new IllegalArgumentException(e.getMessage());

			}

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Musteri Bulunamadı!");
		}
	}
}