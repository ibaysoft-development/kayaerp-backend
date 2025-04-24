package com.kaya.erp.kayaerp.service.fotograf;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.erp.kayaerp.entity.dto.DtoImageUploadRequest;
import com.kaya.erp.kayaerp.entity.model.Fotograf;
import com.kaya.erp.kayaerp.repository.fotograf.FotografJpaRepository;

@Service
public class FotografServiceImpl implements IFotografService {

	@Autowired
	FotografJpaRepository fotoRepository;
	
	@Override
	public void savePhoto(DtoImageUploadRequest foto,String path,Date ptarih) {
		
		Fotograf fotoEntity =  new Fotograf();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd&HH_mm_ss");
		String dateString = formatter.format(ptarih);
		
		fotoEntity.setPname(foto.getFileName()+"-"+dateString);
		fotoEntity.setSasi(foto.getSasi());
		fotoEntity.setType(foto.getType());
		fotoEntity.setPath(path);
		fotoEntity.setPtarih(ptarih);
		fotoRepository.save(fotoEntity);
		
	}

}
