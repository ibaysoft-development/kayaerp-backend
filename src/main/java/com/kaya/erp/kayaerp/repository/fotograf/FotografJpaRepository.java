package com.kaya.erp.kayaerp.repository.fotograf;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaya.erp.kayaerp.entity.model.Fotograf;

public interface FotografJpaRepository extends JpaRepository<Fotograf, Integer> {
    
	@Query("SELECT u FROM Fotograf u WHERE u.pname LIKE CONCAT('%', :name, '%')")
	 List<Fotograf> getPhotoByName(@Param("name") String name);
	
	
	@Query("SELECT u FROM Fotograf u WHERE u.pname=:name")
	List<Fotograf> getSinglePhotoByName(@Param("name") String name);
	
	
}
