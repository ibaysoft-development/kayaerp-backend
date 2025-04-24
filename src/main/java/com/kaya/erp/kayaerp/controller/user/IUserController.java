package com.kaya.erp.kayaerp.controller.user;

import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoUserByPermittedBayi;
import com.kaya.erp.kayaerp.entity.dto.DtoUserLoginRequest;
import com.kaya.erp.kayaerp.entity.model.User;

public interface IUserController {
	
	public User getUserById(int id);

	public User loginUser(DtoUserLoginRequest user);
	
	public List<User> getAllUsers();
	
	public Boolean checkUserById(int id);
	
	public User addUserAndReturnEntity(User user);
	
	public User defineRoleToAddedUser(Integer user_id, List<Integer> role_id);
	
	public List<User> getUsersByRoles(List<Integer> roleIds);
	
	public List<DtoUserByPermittedBayi> getDtoUserByPermittedBayi (int bayi_id); 
	
	
	public List<DtoUserByPermittedBayi> saveAndDeleteUsersByPermittedBayi(List<DtoUserByPermittedBayi> userDto,int bayi_id); 
	
}
