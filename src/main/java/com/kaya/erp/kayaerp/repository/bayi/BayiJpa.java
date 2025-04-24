package com.kaya.erp.kayaerp.repository.bayi;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.Bayi;
import com.kaya.erp.kayaerp.repository.bayi.ICustomBayi;

public interface BayiJpa extends JpaRepository<Bayi,Integer>,ICustomBayi{
	
}