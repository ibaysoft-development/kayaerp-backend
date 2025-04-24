package com.kaya.erp.kayaerp.repository.userBayi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaya.erp.kayaerp.entity.model.UserBayi;

import jakarta.transaction.Transactional;

public interface UserBayiRepository extends JpaRepository<UserBayi, Integer> {

	@Query("SELECT u FROM UserBayi u where u.bayi_id = :bayi_id")
	 List<UserBayi> getUserBayiByBayiId(@Param("bayi_id") int bayi_id);
	
	
	@Modifying
	@Transactional 
	@Query("DELETE  FROM UserBayi ur WHERE ur.bayi_id = :bayi_id and ur.user_id IN (:user_id)")
	void deleteUsersByBayiId(@Param("bayi_id") int bayi_id,@Param("user_id")  List<Integer> user_id);
	
	
}
