package com.kaya.erp.kayaerp.repository.randevuGorusme;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kaya.erp.kayaerp.entity.model.RandevuGorusme;
import com.kaya.erp.kayaerp.repository.randevuGorusme.ICustomRandevuGorusme;



public interface RandevuGorusmeJpa extends JpaRepository<RandevuGorusme,Integer>,ICustomRandevuGorusme{

	List<RandevuGorusme> findByRtarihBetweenAndRbaslatanuser(Date start, Date end, String rbaslatanuser);



	
}