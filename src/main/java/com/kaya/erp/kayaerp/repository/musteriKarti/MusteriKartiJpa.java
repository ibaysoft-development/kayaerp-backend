package com.kaya.erp.kayaerp.repository.musteriKarti;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.MusteriKarti;

public interface MusteriKartiJpa extends JpaRepository<MusteriKarti,Long>,ICustomMusteriKarti {
	 //Optional<MusteriKarti> findByTCNO(String TCNO);
}