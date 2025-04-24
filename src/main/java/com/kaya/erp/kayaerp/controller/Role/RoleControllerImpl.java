package com.kaya.erp.kayaerp.controller.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.dto.DtoRoleByPermittedUser;
import com.kaya.erp.kayaerp.entity.model.Role;
import com.kaya.erp.kayaerp.service.role.IRoleService;


@RestController
@RequestMapping(value="/rest/api/role", produces = "application/json;charset=UTF-8")
public class RoleControllerImpl implements IRoleController{

	@Autowired
	IRoleService roleService;
	
	
	@GetMapping(path = "/getAllRoles")
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return  roleService.getAllRoles();
	}

	@GetMapping(path = "/getRoleById")
	@Override
	public Role getRoleById(@RequestParam int id) {
		// TODO Auto-generated method stub
		return roleService.getRoleById(id);
	}

	@GetMapping(path = "/getDtoRolesByPermittedUsers")
	@Override
	public List<DtoRoleByPermittedUser> getDtoRolesByPermittedUsers(int user_id) {
		
		return roleService.getDtoRolesByPermittedUsers(user_id);
	}

	@PostMapping("/addRoleAndReturnEntity")
	@Override
	public Role addRoleAndReturnEntity(@RequestBody Role role) {
		// TODO Auto-generated method stub
		return roleService.addRoleAndReturnEntity(role);
	}

	@PostMapping("/saveAndDeleteRolesByPermittedUsers")
	@Override
	public List<DtoRoleByPermittedUser> saveAndDeleteRolesByPermittedUsers(@RequestBody List<DtoRoleByPermittedUser> dtoUser,
			int user_id) {
		// TODO Auto-generated method stub
		return roleService.saveAndDeleteRolesByPermittedUsers( dtoUser, user_id);
	}

}
