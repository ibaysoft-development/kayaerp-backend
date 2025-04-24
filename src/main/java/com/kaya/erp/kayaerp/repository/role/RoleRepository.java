package com.kaya.erp.kayaerp.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaya.erp.kayaerp.entity.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	
	
}
