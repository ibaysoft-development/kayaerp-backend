package com.kaya.erp.kayaerp.entity.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Isemri_Tb")
public class Isemri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan ise
    @Column(name = "ISEMRIID")
    private Long isemriId;

    @Column(name = "MUSID")
    private Long musId;

    @Column(name = "MUSTIP", length = 255)
    private String musTip;

    @Column(name = "MUSTERI", length = 255)
    private String musteri;

    @Column(name = "TELEFON", length = 255)
    private String telefon;

    @Column(name = "KM")
    private Long km;

    @Column(name = "PLAKA", length = 255)
    private String plaka;

    @Column(name = "ARACID")
    private Long aracId;

    @Column(name = "TARIH")
    private Date tarih;

    @Column(name = "OLUSTURAN", length = 255)
    private String olusturan;

    @Column(name = "BAYI", length = 255)
    private String bayi;

    @Column(name = "STATU", length = 255)
    private String statu;

    @Column(name = "ISEMRITIP", length = 255)
    private String isemriTip;

    @Column(name = "ONAYVEREN", length = 255)
    private String onayVeren;

    @Column(name = "ISCILIKDURUMU")
    private Integer iscilikDurumu;

    @Column(name = "SURE")
    private BigDecimal sure;

    @Column(name = "DURUM", length = 255)
    private String durum;

    @Column(name = "TUTAR")
    private BigDecimal tutar;

    @Column(name = "MARKA", length = 255)
    private String marka;

    @Column(name = "MODEL", length = 255)
    private String model;

    @Column(name = "RESMIMI", length = 255)
    private String resmimi;
    
    @Column(name = "SASI", length = 255)
    private String sasi;
}
