package com.kaya.erp.kayaerp.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.dto.DtoUserByPermittedBayi;
import com.kaya.erp.kayaerp.entity.dto.DtoUserLoginRequest;
import com.kaya.erp.kayaerp.entity.model.User;
import com.kaya.erp.kayaerp.service.user.IUserService;

@RestController
@RequestMapping(value ="/rest/api/user" , produces = "application/json;charset=UTF-8")
public class UserControllerImpl implements IUserController {

	@Autowired
	private IUserService userService;

	@GetMapping(path = "/list/{id}")
	@Override
	public User getUserById(@PathVariable(name = "id") int id) {
		// TODO Auto-generated method stub
		return userService.getUserById(id);
	}

	@PostMapping(path = "/loginUser")
	@Override
	public User loginUser(@RequestBody DtoUserLoginRequest loginRequest) {
		return userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
	}

	@GetMapping(path = "/getAllUsers")
	@Override
	public List<User> getAllUsers() {

		return userService.getAllUsers();
	}

	@GetMapping(path = "/checkUserById/{id}")
	@Override
	public Boolean checkUserById(@PathVariable(name = "id") int id) {
		// TODO Auto-generated method stub
		return userService.checkUserById(id);
	}

	
	@PostMapping(path = "/addUserAndReturnEntity")
	@Override
	public User addUserAndReturnEntity(@RequestBody User user) {
		// TODO Auto-generated method stub
		return userService.addUserAndReturnEntity(user);
	}

	@PostMapping(path = "/defineRoleToAddedUser/{user_id}")
	@Override
	public User defineRoleToAddedUser(@PathVariable(name="user_id") Integer user_id, @RequestBody List<Integer> role_id) {
		// TODO Auto-generated method stub
		return userService.defineRoleToAddedUser(user_id, role_id);
	}

	@GetMapping(path = "/getUsersByRoles")
	@Override
	public List<User> getUsersByRoles(@RequestBody List<Integer> roleIds) {
		// TODO Auto-generated method stub
		return userService.getUsersByRoles(roleIds);
	}

	@GetMapping(path = "/getDtoUserByPermittedBayi/{id}")
	@Override
	public List<DtoUserByPermittedBayi> getDtoUserByPermittedBayi(@PathVariable(name = "id") int bayi_id) {
		
		return userService.getDtoUserByPermittedBayi(bayi_id);
	}

	@PostMapping(path = "/saveAndDeleteUsersByPermittedBayi/{bayi_id}")
	@Override
	public List<DtoUserByPermittedBayi> saveAndDeleteUsersByPermittedBayi( @RequestBody List<DtoUserByPermittedBayi> userDto,
			@PathVariable(name="bayi_id") int bayi_id) {
		// TODO Auto-generated method stub
		return userService.saveAndDeleteUsersByPermittedBayi(userDto, bayi_id);
	}

}
