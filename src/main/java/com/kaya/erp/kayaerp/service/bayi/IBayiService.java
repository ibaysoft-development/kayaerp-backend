package com.kaya.erp.kayaerp.service.bayi;

import java.util.List;

import com.kaya.erp.kayaerp.entity.model.Bayi;

public interface IBayiService {
	
	public List<Bayi> getAllBayi();
	public Bayi getBayiByIdBayi(Integer id);
	public Bayi getBayiBybayi_kodu(String bayi_kodu);
	public Bayi addBayi (Bayi Bayi);
	public List <Bayi> addBayiList (List <Bayi> bayiList);
	public void deleteBayi (Integer id);
}
