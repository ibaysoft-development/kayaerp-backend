package com.kaya.erp.kayaerp.repository.altgrup;

import com.kaya.erp.kayaerp.entity.model.Altgrup;

import java.util.List;

public interface ICustomAltgrup {
	
  public List<Altgrup> getAltgrupByAltgrupDealer (String altgrup_dealer);
  
  public List <Altgrup> getAltgrupByAltgrupKodu (String altgrup_kodu);
  
  public List <Altgrup> getAltgrupByAltgrupAdi (String altgrup_adi);
  
  public List <Altgrup> getAltgrupByAltgrupAnagrupId (String altgrup_kodu, Integer anagrup_id);
  
  public List <Altgrup> getAltgrupByAllAltgrupAnagrupId (Integer anagrup_id);
  
}