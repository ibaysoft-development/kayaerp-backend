package com.kaya.erp.kayaerp.repository.servisArac;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.ServisArac;

public interface ServisAracJpa extends JpaRepository<ServisArac,Long>,ICustomServisArac {
	
}