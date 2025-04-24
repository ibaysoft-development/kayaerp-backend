package com.kaya.erp.kayaerp.service.isemri;

import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoIsemriFilter;
import com.kaya.erp.kayaerp.entity.model.Isemri;
import com.kaya.erp.kayaerp.entity.model.IsemriDetayView;

public interface IIsemriService {

	List<Isemri> getAllIsEmri();
	List<Isemri> getIsemriByOlusturan(String olusturan);
	
	Isemri addIsemri(Isemri isemri);
	List<Isemri> searchIsemri(DtoIsemriFilter filter);
	IsemriDetayView getIsemriDetayViewByIsemriId(int id);
}
