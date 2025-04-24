package com.kaya.erp.kayaerp.entity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "vw_Isemri_Detay")
public class IsemriDetayView {

    @Id  // Zorunlu, ama view'da bir PK olmayabilir. Gerekirse yapay bir ID seçilebilir.
    private int ISEMRIID;
    private String PLAKA;  // veya başka tekil bir alan
    private String TARIH;
    private String EVTEL;
    private String ISTEL;
    private String VERDAIRE;
    private String VERNO;
    private String EMAIL;
    private String MARKA;
    private String MODEL;
    private String RENK;
    private String SASI;
    private String RUHSATSAHIBI;
    private String MOTORCC;
    private String OLUSTURAN;
    private String KM;
    private String CEPTEL;
    private String ADRES;
    private String BAZARAC;
    private String MODELYILI;
    

    // Getter - Setter
}
