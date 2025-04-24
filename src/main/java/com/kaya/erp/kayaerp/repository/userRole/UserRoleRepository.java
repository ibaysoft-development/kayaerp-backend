package com.kaya.erp.kayaerp.repository.userRole;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kaya.erp.kayaerp.entity.model.UserRole;

import jakarta.transaction.Transactional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	
	
	@Query("SELECT u FROM UserRole u where u.user_id = :user_id")
	 List<UserRole> getRoleUserId(@Param("user_id") int user_id);
	
	@Query("SELECT ur FROM UserRole ur WHERE ur.role_id IN (:role_id)")
	List<UserRole> findByRoleIds(@Param("role_id") List<Integer> role_id);
	
	
	@Modifying
	@Transactional 
	@Query("DELETE  FROM UserRole ur WHERE ur.user_id = :user_id and ur.role_id IN (:role_id)")
	void deleteByRoleIdAndUserId(@Param("user_id") int user_id,@Param("role_id")  List<Integer> role_id);
	
	


	


}
