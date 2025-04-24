package com.kaya.erp.kayaerp.controller.fotograf;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.dto.DtoImageUploadRequest;
import com.kaya.erp.kayaerp.entity.model.Fotograf;
import com.kaya.erp.kayaerp.repository.fotograf.FotografJpaRepository;
import com.kaya.erp.kayaerp.repository.fotograf.FotografRepositoryProxy;
import com.kaya.erp.kayaerp.service.fotograf.IFotografService;

@RestController
@RequestMapping(value = "/rest/api/fotograf", produces = "application/json;charset=UTF-8")
public class FotografController {

	private final FotografRepositoryProxy fotografRepo;
	private final FotografJpaRepository fotografJpaRepository;

	public FotografController(FotografRepositoryProxy fotografRepo, FotografJpaRepository fotografJpaRepository) {
		this.fotografRepo = fotografRepo;
		this.fotografJpaRepository = fotografJpaRepository;
	}

	@Autowired
	IFotografService fotoservice;

	@GetMapping("/listAll")
	public List<Fotograf> getAllPhotos() {
		return fotografRepo.findAll();
	}

	@GetMapping("/search")
	public ResponseEntity<List<Fotograf>> searchByName(@RequestParam String name) {

		int countOfDbFoto = fotografJpaRepository.getPhotoByName(name).size();
		if (countOfDbFoto > 0) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(fotografRepo.search(name));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestBody DtoImageUploadRequest request) {
		String filePath = "";

		Date now = Date.from(Instant.now());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd&HH_mm_ss");
		String dateString = formatter.format(now);
		String fileNameString = request.getFileName()+"-"+dateString;

		try {
			filePath = fotografRepo.uploadBase64Image(request.getBase64Image(),fileNameString);

			if (filePath.contains("Var Olan Fotograf")) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Var olan bir fotoğraf mevcut.");
			}

			fotoservice.savePhoto(request, filePath, now);
			return ResponseEntity.ok("Yüklendi: " + filePath);
		} catch (Exception e) {
			throw new RuntimeException("Yüklenemedi: ");
		}

	}

	@GetMapping("/path/{fileName}")
	public ResponseEntity<String> getPath(@PathVariable String fileName) {

		int countOfDbFoto = fotografJpaRepository.getSinglePhotoByName(fileName).size();

		if (countOfDbFoto > 0) {
			String url = fotografRepo.getImagePath(fileName);
			return ResponseEntity.ok(url);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fotograf Bulunamadi");

	}
	
	
	@GetMapping("/delete/{fileName}")
	public ResponseEntity<String> delete(@PathVariable String fileName) {

		int countOfDbFoto = fotografJpaRepository.getSinglePhotoByName(fileName).size();
		String url ="";
		if (countOfDbFoto > 0) {
			try {
			List<Fotograf> silinecekFotograf = fotografJpaRepository.getSinglePhotoByName(fileName);
			if(silinecekFotograf.size()>0) {
				fotografJpaRepository.delete(silinecekFotograf.get(0));
				 url = fotografRepo.deleteImage(fileName);
			}
				
			} catch (Exception e) {
				 ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veri Tabanı Bağlantı Hatası");
			}
			
			
			return ResponseEntity.ok(url);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fotograf Bulunamadi");

	}
}
