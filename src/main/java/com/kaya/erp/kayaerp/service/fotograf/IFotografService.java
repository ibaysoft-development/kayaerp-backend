package com.kaya.erp.kayaerp.service.fotograf;

import java.util.Date;

import com.kaya.erp.kayaerp.entity.dto.DtoImageUploadRequest;

public interface IFotografService {
	
	void savePhoto(DtoImageUploadRequest foto,String path,Date ptarih);

}
