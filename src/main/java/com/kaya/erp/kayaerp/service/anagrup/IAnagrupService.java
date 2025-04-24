package com.kaya.erp.kayaerp.service.anagrup;

import java.util.List;

import com.kaya.erp.kayaerp.entity.model.Anagrup;

public interface IAnagrupService {
	
	public List<Anagrup> getAllAnagrup();
	public Anagrup getAnagrupByIdAnagrup(Integer id);
	public Anagrup getAnagrupByAnagrupKod(String anagrup_kod);
	public List<Anagrup> getAnagrupByAnagrupDealer(String anagrup_dealer);
	public Anagrup addAnagrup (Anagrup anagrup);
	public List <Anagrup> addAnagrupList (List <Anagrup> anagrupList);
	public void deleteAnagrup (Integer id);
	
}

