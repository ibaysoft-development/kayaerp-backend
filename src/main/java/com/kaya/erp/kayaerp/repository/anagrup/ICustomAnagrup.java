package com.kaya.erp.kayaerp.repository.anagrup;

import com.kaya.erp.kayaerp.entity.model.Anagrup;
import java.util.List;


public interface ICustomAnagrup {
	
	public List <Anagrup> getAnagrupByAnagrupDealer(String anagrup_dealer);
	
	public Anagrup getAnagrupByAnagrupKod(String anagrup_kod);
}