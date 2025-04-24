package com.kaya.erp.kayaerp.service.user;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoUserByPermittedBayi;
import com.kaya.erp.kayaerp.entity.model.User;
import com.kaya.erp.kayaerp.entity.model.UserBayi;
import com.kaya.erp.kayaerp.entity.model.UserRole;
import com.kaya.erp.kayaerp.repository.user.UserJpa;
import com.kaya.erp.kayaerp.repository.userBayi.UserBayiRepository;
import com.kaya.erp.kayaerp.repository.userRole.UserRoleRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserJpa userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private UserBayiRepository userBayiRepository;

	@Override
	public User getUserById(int id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isEmpty()) {

			User user = userOptional.get();

			return user;
		}

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Kullanıcı bulunamadı: Username = " + userOptional.get().getUsername());
	}

	@Override
	public Boolean checkUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.existsById(id);
	}

	@Override
	public User loginUser(String unameString, String pass) {
		User user = userRepository.findByUsernameAndPassword(unameString, pass);

		if (user == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Kullanıcı bulunamadı: Username = " + unameString);
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> allUsers = userRepository.findAll();

		return allUsers;
	}

	@Override
	public User addUserAndReturnEntity(User newUser) {

		if (newUser != null) {

			try {
				User addedUser = userRepository.save(newUser);
				return addedUser;
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kullanıcı Oluşturulamadı");
			}

		}

		throw new IllegalArgumentException("Kullanıcı  boş olamaz!");
	}

	@Override
	public User defineRoleToAddedUser(Integer user_id, List<Integer> role_id) {

		if (user_id == null || role_id == null) {
			throw new IllegalArgumentException("Kullanıcı ID veya Rol ID boş olamaz!");
		}

		Optional<User> optionalUser = userRepository.findById(user_id);
		if (optionalUser.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kullanıcı bulunamadı: ID = " + user_id);
		}

		List<UserRole> userRoles = userRoleRepository.getRoleUserId(user_id);

		Set<Integer> mevcutRolIdSeti = new HashSet<>();
		for (UserRole userRole : userRoles) {
			mevcutRolIdSeti.add(userRole.getRole_id());
		}

		List<Integer> eklenecekRolIdListesi = new ArrayList<>();
		for (Integer eklenecekRolId : role_id) {
			if (!mevcutRolIdSeti.contains(eklenecekRolId)) {
				eklenecekRolIdListesi.add(eklenecekRolId);
			}
		}

		// 🚀 5. Yeni Rolleri Kullanıcıya Ekle
		for (Integer yeniRolId : eklenecekRolIdListesi) {
			UserRole yeniUserRole = new UserRole();
			yeniUserRole.setUser_id(user_id);
			yeniUserRole.setRole_id(yeniRolId);
			yeniUserRole.setCreate_date(Timestamp.valueOf(LocalDateTime.now()));
			userRoleRepository.save(yeniUserRole); // Veritabanına kaydet
		}

		return null;
	}

	@Override
	public List<User> getUsersByRoles(List<Integer> roleIds) {

		if (roleIds == null || roleIds.isEmpty()) {
			throw new IllegalArgumentException("Rol ID listesi boş olamaz!");
		}

		List<UserRole> userRoles = userRoleRepository.findByRoleIds(roleIds);

		Set<Integer> userIds = new HashSet<>();
		for (UserRole userRole : userRoles) {
			userIds.add(userRole.getUser_id());
		}

		List<User> users = userRepository.findAllById(userIds);

		return users;
	}

	@Override
	public List<DtoUserByPermittedBayi> getDtoUserByPermittedBayi(int bayi_id) {
		
		List<User> getAllUsers = userRepository.findAll();
		
		List<Integer> bayiyeTanimliUserlarinId =   userBayiRepository.getUserBayiByBayiId(bayi_id).stream().map(UserBayi::getUser_id).collect(Collectors.toList());
		
		List<DtoUserByPermittedBayi> dtoUserByPermittedBayis = getAllUsers.stream().map( xxx -> new DtoUserByPermittedBayi(xxx.getId(),xxx.getUsername(),bayiyeTanimliUserlarinId.contains(xxx.getId()))).collect(Collectors.toList());
		
		
		
		return dtoUserByPermittedBayis;
	}

	@Override
	public List<DtoUserByPermittedBayi> saveAndDeleteUsersByPermittedBayi(List<DtoUserByPermittedBayi> dtoUser,
			int bayi_id) {
		
		List<Integer> bayiyeTanimliUserlarinId = userBayiRepository.getUserBayiByBayiId(bayi_id).
				stream().map(UserBayi::getUser_id).collect(Collectors.toList());
		
		List<UserBayi> eklenecekUserler =
				dtoUser.stream().filter(userDto -> userDto.getIsActive() && !bayiyeTanimliUserlarinId.contains(userDto.getUser_id())).map(
						newUser-> new UserBayi(newUser.getUser_id(),bayi_id, new Timestamp(System.currentTimeMillis()))
						
						).collect(Collectors.toList());
		
		List<Integer> silinecekUserlerList  = dtoUser.stream().
				filter(deletedUser -> !deletedUser.getIsActive() && bayiyeTanimliUserlarinId.contains(deletedUser.getUser_id()))
				.map(DtoUserByPermittedBayi:: getUser_id).collect(Collectors.toList());
		
		
		if(!eklenecekUserler.isEmpty()) {
			userBayiRepository.saveAll(eklenecekUserler);
			
		}
		if(!silinecekUserlerList.isEmpty()) {
			userBayiRepository.deleteUsersByBayiId(bayi_id,silinecekUserlerList);
		}
		
		
		
		return getDtoUserByPermittedBayi(bayi_id);
	}

	

}
