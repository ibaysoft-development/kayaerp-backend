package com.kaya.erp.kayaerp.service.sayfa;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoPageByPermittedRole;
import com.kaya.erp.kayaerp.entity.model.RoleSayfa;
import com.kaya.erp.kayaerp.entity.model.Sayfa;
import com.kaya.erp.kayaerp.entity.model.User;
import com.kaya.erp.kayaerp.entity.model.UserRole;
import com.kaya.erp.kayaerp.entity.model.UserSayfa;
import com.kaya.erp.kayaerp.repository.roleSayfa.RoleSayfaRepository;
import com.kaya.erp.kayaerp.repository.sayfa.SayfaRepository;
import com.kaya.erp.kayaerp.repository.user.UserJpa;
import com.kaya.erp.kayaerp.repository.userRole.UserRoleRepository;
import com.kaya.erp.kayaerp.repository.userSayfa.UserSayfaRepository;

@Service
public class SayfaServiceImpl implements ISayfaService {

	@Autowired
	UserJpa userRepository;

	@Autowired
	SayfaRepository sayfaRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	RoleSayfaRepository roleSayfaRepository;

	@Autowired
	UserSayfaRepository userSayfaRepository;

	@Override
	public List<Sayfa> getPagesPermittedUser(int user_id) {

		Optional<User> user = userRepository.findById(user_id);

		List<Sayfa> kullanininSayfalariList = new ArrayList<>();

		if (user.isPresent()) {

			List<UserRole> kullaniciRolu = userRoleRepository.getRoleUserId(user.get().getId());

			if (!kullaniciRolu.isEmpty()) {

				for (UserRole userRole : kullaniciRolu) {

					List<Sayfa> userRoleSayfalarList = getPagesByPermittedRole(userRole.getRole_id());

					if (!userRoleSayfalarList.isEmpty()) {

						for (Sayfa userSayfa : userRoleSayfalarList) {
							if (!kullanininSayfalariList.contains(userSayfa)) {
								kullanininSayfalariList.add(userSayfa);
							}

						}

					} else {
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
								"Role ait sayfa yok: ID = " + userRole.getRole_id());
					}

				}

			} else {

				// throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kullanıcının Rolü
				// yok: ID = " + user_id);
			}

			List<UserSayfa> userSayfa = userSayfaRepository.getUserSayfaByUserİd(user.get().getId());
			if (userSayfa.size() > 0) {
				for (UserSayfa userSayfa2 : userSayfa) {
					if (userSayfa2.getSayfa_erisimi_statu().equals("EKLENDI")) {
						Optional<Sayfa> optionalSayfaOptional = sayfaRepository.findById(userSayfa2.getSayfa_id());
						if (optionalSayfaOptional.isPresent()) {
							Sayfa sayfa = optionalSayfaOptional.get();

							if (!kullanininSayfalariList.contains(sayfa)) {
								kullanininSayfalariList.add(sayfa);
							}

						}

					} else if (userSayfa2.getSayfa_erisimi_statu().equals("CIKARILDI")) {
						Optional<Sayfa> optionalSayfaOptional = sayfaRepository.findById(userSayfa2.getSayfa_id());
						if (optionalSayfaOptional.isPresent()) {
							Sayfa sayfa = optionalSayfaOptional.get();
							if (kullanininSayfalariList.contains(userSayfa2)) {
								kullanininSayfalariList.remove(sayfa);
							}

						}

					}

				}

			}

			return kullanininSayfalariList;
		}

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kullanıcı bulunamadı: ID = " + user_id);

	}

	@Override
	public List<Sayfa> getAllPages() {
		// TODO Auto-generated method stub
		return sayfaRepository.findAll();
	}

	@Override
	public List<Sayfa> getPagesByPermittedRole(int role_id) {
		List<RoleSayfa> roleSayfas = roleSayfaRepository.getPagesByPermittedRole(role_id);

		List<Sayfa> sayfalarList = new ArrayList<>();

		for (RoleSayfa roleSayfa : roleSayfas) {

			Optional<Sayfa> optionalSayfa = sayfaRepository.findById(roleSayfa.getSayfa_id());
			if (optionalSayfa.isPresent()) {
				sayfalarList.add(optionalSayfa.get());

			} else {

			}

		}

		return sayfalarList;
	}

	@Override
	public List<DtoPageByPermittedRole> getDtoPagesByPermittedRole(int role_id) {

		List<Sayfa> getAllPages = sayfaRepository.findAll();

		List<Integer> roleAitSayfaIds = roleSayfaRepository.getPagesByPermittedRole(role_id).stream()
				.map(RoleSayfa::getSayfa_id).collect(Collectors.toList());

		List<DtoPageByPermittedRole> dtoPages = getAllPages.stream()
				.map(sayfa -> new DtoPageByPermittedRole(sayfa.getId(), sayfa.getSayfa_adi(),
						roleAitSayfaIds.contains(sayfa.getId())))
				.collect(Collectors.toList());

		return dtoPages;
	}

	@Override
	public List<DtoPageByPermittedRole> saveAndDeletePagesByDtoPermittedRole(List<DtoPageByPermittedRole> dtoPages, int role_id) {

		List<Integer> roleAitSayfaIds = roleSayfaRepository.getPagesByPermittedRole(role_id).stream()
				.map(RoleSayfa::getSayfa_id).collect(Collectors.toList());

		List<RoleSayfa> eklenecekSayfalar = dtoPages.stream()
				.filter(dto -> dto.getIsActive() && !roleAitSayfaIds.contains(dto.getSayfaId()))
				.map(dto -> new RoleSayfa(role_id, dto.getSayfaId(), new Timestamp(System.currentTimeMillis())))
				.collect(Collectors.toList());

		List<Integer> silinecekSayfaIds = dtoPages.stream()
				.filter(dto -> !dto.getIsActive() && roleAitSayfaIds.contains(dto.getSayfaId()))
				.map(DtoPageByPermittedRole::getSayfaId).collect(Collectors.toList());

		if (!eklenecekSayfalar.isEmpty()) {
			roleSayfaRepository.saveAll(eklenecekSayfalar);
		}

		if (!silinecekSayfaIds.isEmpty()) {
			roleSayfaRepository.deleteByRoleIdAndSayfaIds(role_id, silinecekSayfaIds);
		}

		return getDtoPagesByPermittedRole(role_id);
	}

}
