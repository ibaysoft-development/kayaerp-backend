package com.kaya.erp.kayaerp.service.isemri;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.erp.kayaerp.entity.dto.DtoIsemriFilter;
import com.kaya.erp.kayaerp.entity.model.Isemri;
import com.kaya.erp.kayaerp.entity.model.IsemriDetayView;
import com.kaya.erp.kayaerp.repository.isemri.IsemriJpa;
import com.kaya.erp.kayaerp.repository.view.isemridetay.IsemriDetayViewRepository;

@Service
public class IsemriServiceImpl implements IIsemriService {

	@Autowired
	IsemriJpa isemriRepository;
	
	@Autowired
	IsemriDetayViewRepository isemriDetayViewRepository;
	

	@Override
	public List<Isemri> getAllIsEmri() {

		return isemriRepository.findAll();
	}

	@Override
	public List<Isemri> getIsemriByOlusturan(String olusturan) {

		return isemriRepository.getIsemriByOlusturan(olusturan);
	}

	@Override
	public Isemri addIsemri(Isemri isemri) {
		// TODO Auto-generated method stub
		return isemriRepository.save(isemri);
	}
	
	@Override
	public List<Isemri> searchIsemri(DtoIsemriFilter filter) {
	    return isemriRepository.findIsemriByFilter(filter);
	}

	@Override
	public IsemriDetayView getIsemriDetayViewByIsemriId(int id) {
		
		Optional<IsemriDetayView> isemriOptional = isemriDetayViewRepository.findById(id);
			if(isemriOptional.isPresent()) {
				return isemriOptional.get();
			}
		
		return null;
		
	}

}
