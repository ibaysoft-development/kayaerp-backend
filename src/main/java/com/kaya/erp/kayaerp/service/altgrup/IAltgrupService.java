package com.kaya.erp.kayaerp.service.altgrup;

import java.util.List;

import com.kaya.erp.kayaerp.entity.model.Altgrup;

public interface IAltgrupService {
	
	public List<Altgrup> getAllAltgrup();
	public Altgrup getAltgrupByIdAltgrup(Integer id);
	public List<Altgrup> getAltgrupByAltgrupDealer (String altgrup_dealer);
	public List<Altgrup> getAltgrupByAltgrupKodu(String altgrup_kodu);
	public List<Altgrup> getAltgrupByAltgrupAdi(String altgrup_adi);
	public List<Altgrup> getAltgrupByAltgrupAnagrupId(String altgrup_kodu ,Integer anagrup_id );
	public List<Altgrup> getAltgrupByAllAltgrupAnagrupId(Integer anagrup_id);
	public Altgrup addAltgrup (Altgrup altgrup);
	public List <Altgrup> addAltgrupList (List <Altgrup> altgrupList);
	public void deleteAltgrup (Integer id);
	

	
	
}
