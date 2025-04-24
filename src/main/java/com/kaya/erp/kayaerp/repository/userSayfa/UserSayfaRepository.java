package com.kaya.erp.kayaerp.repository.userSayfa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaya.erp.kayaerp.entity.model.UserSayfa;

public interface UserSayfaRepository extends JpaRepository<UserSayfa, Integer>{

	
	@Query("SELECT u FROM UserSayfa u where u.user_id = :user_id")
	 List<UserSayfa> getUserSayfaByUserİd(@Param("user_id") int user_id);
}
