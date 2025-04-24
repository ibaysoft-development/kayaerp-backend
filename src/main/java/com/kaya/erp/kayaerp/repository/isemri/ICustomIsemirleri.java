package com.kaya.erp.kayaerp.repository.isemri;

import java.util.Date;
import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoIsemriFilter;
import com.kaya.erp.kayaerp.entity.model.Isemri;

public interface ICustomIsemirleri {
	 public List<Isemri> getIsemriByOlusturan(String olusturan);
	 public List<Isemri> getIsemriByTarih(Date bastar, Date bittar);
	 List<Isemri> findIsemriByFilter(DtoIsemriFilter filter);
}
