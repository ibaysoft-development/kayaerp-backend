package com.kaya.erp.kayaerp.repository.gorusme;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.Gorusme;
import com.kaya.erp.kayaerp.repository.gorusme.ICustomGorusme;



public interface GorusmeJpa extends JpaRepository<Gorusme,Integer>,ICustomGorusme{
	
}