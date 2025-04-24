package com.kaya.erp.kayaerp.repository.stokKarti;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.StokKarti;


public interface StokKartiJpa extends JpaRepository<StokKarti,Integer>,ICustomStokKarti {
	
}