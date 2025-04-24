package com.kaya.erp.kayaerp.repository.altgrup;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.Altgrup;
import com.kaya.erp.kayaerp.repository.altgrup.ICustomAltgrup;


public interface AltgrupJpa extends JpaRepository<Altgrup,Integer>,ICustomAltgrup{
	
}
