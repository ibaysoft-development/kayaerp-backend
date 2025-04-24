package com.kaya.erp.kayaerp.service.randevugorusme;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaya.erp.kayaerp.entity.model.RandevuGorusme;
import com.kaya.erp.kayaerp.repository.randevuGorusme.RandevuGorusmeJpa;
import com.kaya.erp.kayaerp.util.AppUtil;
import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeDoluVeBos;
import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeRequest;


@Service
public class RandevuGorusmeServiceImpl implements IRandevuGorusmeService {
	
	
	@Autowired
	private RandevuGorusmeJpa randevugorusmeRepository;
	
	@Override
	public List<RandevuGorusme> getRandevuByBaslatanUser(String rbaslatanuser) {
		
		return randevugorusmeRepository.getRandevuByBaslatanUser(rbaslatanuser);
	}


	
	
	@Override
	public RandevuGorusme addRandevu(RandevuGorusme randevuGorusme) {
	    if (randevuGorusme == null || randevuGorusme.getRtarih() == null || randevuGorusme.getRbaslatanuser() == null) {
	        throw new IllegalArgumentException("Randevu bilgileri eksik!");
	    }
	   
	    Date baslangic = randevuGorusme.getRtarih();
	    
	    // 🔒 Geçmişe randevu alınamasın
	    if (baslangic.before(new Date())) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
	            "Geçmiş bir tarihe randevu alınamaz.");
	    }
	     
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(baslangic);

	    int minute = cal.get(Calendar.MINUTE);
	    if (minute != 0 && minute != 30) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
	                "Randevu sadece her yarım saatte bir alınabilir. (Örn: 13:00, 13:30)");
	    }

	    cal.add(Calendar.MINUTE, 30); // randevu 30 dakika sürüyor
	    Date bitis = cal.getTime();

	    List<RandevuGorusme> cakisanlar = randevugorusmeRepository
	            .findByRtarihBetweenAndRbaslatanuser(baslangic, bitis, randevuGorusme.getRbaslatanuser());

	    if (!cakisanlar.isEmpty()) {
	        throw new ResponseStatusException(HttpStatus.CONFLICT,
	                "Bu saat aralığında zaten bir randevunuz var. Lütfen başka bir zaman seçiniz.");
	    }

	    try {
	        return randevugorusmeRepository.save(randevuGorusme);
	    } catch (Exception e) {
	        throw new RuntimeException("Randevu kaydedilirken hata oluştu: " + e.getMessage());
	    }
	}

	
	
	
//	@Override
//	public RandevuGorusme addRandevu(DtoRandevuGorusmeRequest dto) {
//	    if (dto == null || dto.getRtarih() == null || dto.getRbaslatanuser() == null) {
//	        throw new IllegalArgumentException("Randevu bilgileri eksik!");
//	    }
//
//	    Date baslangic = dto.getRtarih();
//
//	    if (baslangic.before(new Date())) {
//	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//	                "Geçmiş bir tarihe randevu alınamaz.");
//	    }
//
//	    Calendar cal = Calendar.getInstance();
//	    cal.setTime(baslangic);
//	    int minute = cal.get(Calendar.MINUTE);
//	    if (minute != 0 && minute != 30) {
//	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//	                "Randevu sadece her yarım saatte bir alınabilir.");
//	    }
//
//	    cal.add(Calendar.MINUTE, 30);
//	    Date bitis = cal.getTime();
//
//	    List<RandevuGorusme> cakisanlar = randevugorusmeRepository
//	            .findByRtarihBetweenAndRbaslatanuser(baslangic, bitis, dto.getRbaslatanuser());
//
//	    if (!cakisanlar.isEmpty()) {
//	        throw new ResponseStatusException(HttpStatus.CONFLICT,
//	                "Bu saat aralığında zaten bir randevunuz var. Lütfen başka bir zaman seçiniz.");
//	    }
//
//	    try {
//	        // mapToEntity metodu DTO'dan Entity'ye dönüştürür
//	        return randevugorusmeRepository.save(mapToEntity(dto));
//	    } catch (Exception e) {
//	        throw new RuntimeException("Randevu kaydedilirken hata oluştu: " + e.getMessage());
//	    }
//	}

	
	
	
	
//	@Override
//	public RandevuGorusme addRandevu(RandevuGorusme randevuGorusme) {
//	    if (randevuGorusme == null || randevuGorusme.getRtarih() == null || randevuGorusme.getRbaslatanuser() == null) {
//	        throw new IllegalArgumentException("Randevu bilgileri eksik!");
//	    }
//
//	    Date baslangic = randevuGorusme.getRtarih();
//	    Calendar cal = Calendar.getInstance();
//	    cal.setTime(baslangic);
//	    cal.add(Calendar.MINUTE, 30); // randevu 30 dakika sürüyor
//	    Date bitis = cal.getTime();
//
//	    // Kullanıcının aynı saat aralığında randevusu var mı?
//	    List<RandevuGorusme> cakisanlar = randevugorusmeRepository
//	        .findByRtarihBetweenAndRbaslatanuser(baslangic, bitis, randevuGorusme.getRbaslatanuser());
//
//	    if (!cakisanlar.isEmpty()) {
//	        throw new ResponseStatusException(HttpStatus.CONFLICT,
//	            "Bu saat aralığında zaten bir randevunuz var. Lütfen başka bir zaman seçiniz.");
//	    }
//
//	    try {
//	        return randevugorusmeRepository.save(randevuGorusme);
//	    } catch (Exception e) {
//	        throw new RuntimeException("Randevu kaydedilirken hata oluştu: " + e.getMessage());
//	    }
//	}

//	@Override
//	public RandevuGorusme addRandevu(RandevuGorusme randevuGorusme) {
//	    if (randevuGorusme == null || randevuGorusme.getRtarih() == null) {
//	        throw new IllegalArgumentException("Randevu bilgileri eksik!");
//	    }
//
//	    Date baslangic = randevuGorusme.getRtarih();
//	    Calendar cal = Calendar.getInstance();
//	    cal.setTime(baslangic);
//	    cal.add(Calendar.MINUTE, 30);
//	    Date bitis = cal.getTime();
//
//	    // Aynı tarih ve saat aralığında randevu var mı?
//	    List<RandevuGorusme> cakisanlar = randevugorusmeRepository
//	        .findByRtarihBetween(baslangic, bitis);
//
//	    if (!cakisanlar.isEmpty()) {
//	        throw new ResponseStatusException(HttpStatus.CONFLICT,
//	                "Bu saat aralığında zaten bir randevu var. Lütfen başka bir zaman seçiniz.");
//	    }
//
//	    try {
//	        return randevugorusmeRepository.save(randevuGorusme);
//	    } catch (Exception e) {
//	        throw new RuntimeException("Randevu kaydedilirken hata oluştu: " + e.getMessage());
//	    }
//	}
	
//	@Override
//	public List<LocalTime> getBugunkuDoluSaatler() {
//	    LocalDate today = LocalDate.now();
//
//	    LocalDateTime start = today.atTime(9, 0);  // mesai başlangıcı
//	    LocalDateTime end = today.atTime(17, 0);   // mesai bitişi
//
//	    List<RandevuGorusme> randevular = randevugorusmeRepository.findByRtarihBetween(
//	        java.sql.Timestamp.valueOf(start),
//	        java.sql.Timestamp.valueOf(end)
//	    );
//
//	    return randevular.stream()
//	        .map(r -> r.getRtarih().toInstant().atZone(ZoneId.systemDefault()).toLocalTime())
//	        .map(t -> t.truncatedTo(ChronoUnit.MINUTES))
//	        .collect(Collectors.toList());
//	}
	
	
	@Override
	public List<LocalTime> getDoluSaatlerByDate(String kullaniciAdi, LocalDate tarih) {
	    LocalDateTime start = tarih.atTime(9, 0);  // mesai başlangıcı
	    LocalDateTime end = tarih.atTime(17, 0);   // mesai bitişi

	    List<RandevuGorusme> randevular = randevugorusmeRepository.findByRtarihBetweenAndRbaslatanuser(
	        java.sql.Timestamp.valueOf(start),
	        java.sql.Timestamp.valueOf(end),
	        kullaniciAdi
	    );

	    return randevular.stream()
	        .map(r -> r.getRtarih().toInstant().atZone(ZoneId.systemDefault()).toLocalTime())
	        .map(t -> t.truncatedTo(ChronoUnit.MINUTES))
	        .collect(Collectors.toList());
	}

	
	
	@Override
	public List<LocalTime> getMusaitSaatlerByDate(String kullaniciAdi, LocalDate tarih) {
	    List<LocalTime> tumSaatler = new ArrayList<>();
	    for (int i = 9; i <= 16; i++) {
	        tumSaatler.add(LocalTime.of(i, 0));
	        tumSaatler.add(LocalTime.of(i, 30));
	    }

	    List<LocalTime> dolu = getDoluSaatlerByDate(kullaniciAdi, tarih);
	    tumSaatler.removeAll(dolu);

	    return tumSaatler;
	}



	@Override
	public List<DtoRandevuGorusmeDoluVeBos> getRandevuDatesByDtoRandevuGorusmeDoluVeBos(String rbaslatan, String dealer,
			String tarih) {
		
        Date convertedDate = AppUtil.parseDateFromStringToDate(tarih);
         
       
		
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(convertedDate);
	    calendar.add(Calendar.DATE, 1); // 1 gün ekle
	    Date tomorrow = calendar.getTime();
	    
	    List<RandevuGorusme> doluRandevular =   randevugorusmeRepository.findByRtarihBetweenAndRbaslatanuser(convertedDate,tomorrow,rbaslatan);
	    
	    List<Date> doluSaatler = doluRandevular.stream().map(m->m.getRtarih()).collect(Collectors.toList()); 
	    List<Date> birgununtumSaatleri = getYarimSaatlikAraliklar(convertedDate);
	    
	    
	   List<DtoRandevuGorusmeDoluVeBos> dtoList = birgununtumSaatleri.stream().map(m-> new DtoRandevuGorusmeDoluVeBos(rbaslatan,m, doluSaatler.contains(m) ,dealer)).collect(Collectors.toList());
		
		return dtoList;
	}


	
	
	
	
	
    public static List<Date> getYarimSaatlikAraliklar(Date date) {
        List<Date> saatListesi = new ArrayList<>();

        // Date'i LocalDate'e çevir
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Başlangıç ve bitiş saatleri
        LocalTime startTime = LocalTime.of(8, 0);   // 08:00
        LocalTime endTime = LocalTime.of(20, 0);    // 20:00

        // Zamanı yarımşar saat artırarak listeye ekle
        for (LocalTime time = startTime; !time.isAfter(endTime); time = time.plusMinutes(30)) {
            LocalDateTime dateTime = LocalDateTime.of(localDate, time);
            Date fullDate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
            saatListesi.add(fullDate);
        }

        return saatListesi;
    }
	
	
	
	
//	@Override
//	public List<LocalTime> getBugunkuDoluSaatler(String kullaniciAdi) {
//	    LocalDate today = LocalDate.now();
//
//	    LocalDateTime start = today.atTime(9, 0);  // mesai başlangıcı
//	    LocalDateTime end = today.atTime(17, 0);   // mesai bitişi
//
//	    List<RandevuGorusme> randevular = randevugorusmeRepository.findByRtarihBetweenAndRbaslatanuser(
//	        java.sql.Timestamp.valueOf(start),
//	        java.sql.Timestamp.valueOf(end),
//	        kullaniciAdi
//	    );
//
//	    return randevular.stream()
//	        .map(r -> r.getRtarih().toInstant().atZone(ZoneId.systemDefault()).toLocalTime())
//	        .map(t -> t.truncatedTo(ChronoUnit.MINUTES))
//	        .collect(Collectors.toList());
//	}
//
//
//
//	@Override
//	public List<LocalTime> getBugunkuMusaitSaatler(String kullaniciAdi) {
//	    List<LocalTime> tumSaatler = new ArrayList<>();
//	    for (int i = 9; i <= 16; i++) {
//	        tumSaatler.add(LocalTime.of(i, 0));
//	        tumSaatler.add(LocalTime.of(i, 30));
//	    }
//
//	    List<LocalTime> dolu = getBugunkuDoluSaatler(kullaniciAdi);
//	    tumSaatler.removeAll(dolu);
//
//	    return tumSaatler;
//	}


	
	
	
	
	
	//@Override
    //public RandevuGorusme addRandevu (RandevuGorusme randevuGorusme) {
   	 //if (randevuGorusme == null) {
	//		throw new IllegalArgumentException("Randevu  Giriniz!");
	//	}
  // 	RandevuGorusme eklenenRandevu = new RandevuGorusme ();
   //	 try {
   	//	eklenenRandevu = randevugorusmeRepository.save(randevuGorusme);
   //	 } catch  (Exception e) {
	//		String exeptionString = e.getMessage();
   //	 }
   //	 return eklenenRandevu;
  //  }

    
   
}