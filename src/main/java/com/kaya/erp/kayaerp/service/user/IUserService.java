package com.kaya.erp.kayaerp.service.user;

import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoUserByPermittedBayi;
import com.kaya.erp.kayaerp.entity.model.User;


public interface IUserService {
	
	public User getUserById(int id);
	
	public Boolean checkUserById(int id);

	public User loginUser(String unameString ,String pass);
	
	public List<User> getAllUsers();
	
	public User addUserAndReturnEntity(User newUser);
	
	public User defineRoleToAddedUser(Integer user_id,List<Integer> role_id);
	
	public List<User> getUsersByRoles(List<Integer> roleIds);
	
	public List<DtoUserByPermittedBayi> getDtoUserByPermittedBayi (int bayi_id); 
	
	public List<DtoUserByPermittedBayi> saveAndDeleteUsersByPermittedBayi(List<DtoUserByPermittedBayi> dtoUser,int bayi_id);
	
	
	

}
