package com.kaya.erp.kayaerp.entity.model;

import java.sql.Timestamp;

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
@Table(name = "Bayi_Tb")
public class Bayi {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan ise
    @Column(name = "id")
    private int id;

    @Column(name = "bayi_adres", length = 255)
    private String bayiAdres;

    @Column(name = "bayi_il", length = 100)
    private String bayiIl;

    @Column(name = "bayi_ilce", length = 100)
    private String bayiIlce;

    @Column(name = "bayi_mail", length = 150, unique = true)
    private String bayiMail;

    @Column(name = "bayi_statu")
    private int bayiStatu;

    @Column(name = "bayi_tel", length = 20)
    private String bayiTel;

    @Column(name = "bayi_ismi", length = 150)
    private String bayiIsmi;

    @Column(name = "bayi_kodu", length = 50, unique = true)
    private String bayiKodu;

    @Column(name = "bayi_acilis_tarih")
    private Timestamp bayiAcilisTarih;

    
    @Column(name = "bayi_güncelleme_tarihi")
    private Timestamp bayiGuncellemeTarihi;

    @Column(name = "bayi_vergi_no", length = 50, unique = true)
    private String bayiVergiNo;

    @Column(name = "bayi_vergi_dairesi", length = 100)
    private String bayiVergiDairesi;

    
    
    
    
}
