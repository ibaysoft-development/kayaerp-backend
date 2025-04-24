package com.kaya.erp.kayaerp.repository.roleSayfa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kaya.erp.kayaerp.entity.model.RoleSayfa;

import jakarta.transaction.Transactional;

@Repository
public interface RoleSayfaRepository extends JpaRepository<RoleSayfa, Integer> {

	 @Query("SELECT u FROM RoleSayfa u where u.role_id = :role_id")
	 List<RoleSayfa> getPagesByPermittedRole(@Param("role_id") int role_id);
	 
	 @Modifying
	 @Transactional
	 @Query("DELETE FROM RoleSayfa rs WHERE rs.role_id = :role_id AND rs.sayfa_id = :sayfa_id")
	 void deleteByRoleIdAndSayfaId(@Param("role_id") int role_id, @Param("sayfa_id") int sayfa_id);
	 
	 @Modifying
	 @Transactional 
	 @Query("DELETE FROM RoleSayfa rs WHERE rs.role_id = :role_id AND rs.sayfa_id IN (:sayfaIds)")
	 void deleteByRoleIdAndSayfaIds(@Param("role_id") int role_id, @Param("sayfaIds") List<Integer> sayfaIds);


	
}
