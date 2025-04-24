package com.kaya.erp.kayaerp.repository.anagrup;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.Anagrup;
import com.kaya.erp.kayaerp.repository.anagrup.ICustomAnagrup;



public interface AnagrupJpa extends JpaRepository<Anagrup,Integer>,ICustomAnagrup{
	
}