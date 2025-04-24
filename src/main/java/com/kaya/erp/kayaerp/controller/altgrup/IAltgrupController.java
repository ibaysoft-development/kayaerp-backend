package com.kaya.erp.kayaerp.controller.altgrup;

import java.util.List;

import com.kaya.erp.kayaerp.entity.model.Altgrup;

public interface IAltgrupController {
	
	public List<Altgrup> getAllAltgrup();
	public Altgrup getAltgrupByIdAltgrup(Integer id);
	public List<Altgrup> getAltgrupByAltgrupDealer(String altgrup_dealer);
	public List<Altgrup> getAltgrupByAltgrupKodu(String altgrup_kodu);
	public List<Altgrup> getAltgrupByAltgrupAdi(String altgrup_adi);
	public List<Altgrup> getAltgrupByAltgrupAnagrupId(String altgrupKodu ,Integer anagrupId);
    public List<Altgrup> getAltgrupByAllAltgrupAnagrupId(Integer anagrup_id);
	public Altgrup addAltgrup (Altgrup altgrup);
	public List <Altgrup> addAltgrupList (List <Altgrup> altgrup);
	public void deleteAltgrup (Integer id);
    

}




