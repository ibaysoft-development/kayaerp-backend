package com.kaya.erp.kayaerp.service.role;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoRoleByPermittedUser;
import com.kaya.erp.kayaerp.entity.model.Role;
import com.kaya.erp.kayaerp.entity.model.UserRole;
import com.kaya.erp.kayaerp.repository.role.RoleRepository;
import com.kaya.erp.kayaerp.repository.userRole.UserRoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public List<Role> getAllRoles() {

		return roleRepository.findAll();

	}

	@Override
	public Role getRoleById(int id) {
		Role role = new Role();
		Optional<Role> optionalRoleOptional = roleRepository.findById(id);
		if (optionalRoleOptional.isPresent()) {
			role = optionalRoleOptional.get();
			return role;
		}

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role Bulunamadı: ID = " + id);
	}

	@Override
	public Role addRoleAndReturnEntity(Role role) {

		if (role == null) {
			throw new IllegalArgumentException("Kullanıcı Rolu Giriniz!");

		}

		Role addedrole = roleRepository.save(role);
		return addedrole;

	}

	@Override
	public List<DtoRoleByPermittedUser> getDtoRolesByPermittedUsers(int user_id) {

		List<Role> getAllRoles = roleRepository.findAll();

		List<Integer> kullaniciyaAitRollerId = userRoleRepository.getRoleUserId(user_id).stream()
				.map(UserRole::getRole_id).collect(Collectors.toList());

		List<DtoRoleByPermittedUser> dtoRoles = getAllRoles.stream()
				.map(role -> new DtoRoleByPermittedUser(role.getId(), role.getRole_name(),
						kullaniciyaAitRollerId.contains(role.getId())))
				.collect(Collectors.toList());

		return dtoRoles;
	}

	@Override
	public List<DtoRoleByPermittedUser> saveAndDeleteRolesByPermittedUsers(List<DtoRoleByPermittedUser> dtoUser,
			int user_id) {

		List<Integer> kullaniciyaAitRollerId = userRoleRepository.getRoleUserId(user_id).stream()
				.map(UserRole::getRole_id).collect(Collectors.toList());

		List<UserRole> eklenecekRollerList = dtoUser.stream()
				.filter(user -> user.getIsActive() && !kullaniciyaAitRollerId.contains(user.getRole_id()))
				.map(dto -> new UserRole(user_id, dto.getRole_id(), new Timestamp(System.currentTimeMillis())))
				.collect(Collectors.toList());

		List<Integer> silinecekRollerId = dtoUser.stream()
				.filter(user -> !user.getIsActive() && kullaniciyaAitRollerId.contains(user.getRole_id()))
				.map(DtoRoleByPermittedUser::getRole_id).collect(Collectors.toList());

		if (!eklenecekRollerList.isEmpty()) {
			userRoleRepository.saveAll(eklenecekRollerList);
		}

		if (!silinecekRollerId.isEmpty()) {
			userRoleRepository.deleteByRoleIdAndUserId(user_id, silinecekRollerId);
		}

		return getDtoRolesByPermittedUsers(user_id);
	}

}
