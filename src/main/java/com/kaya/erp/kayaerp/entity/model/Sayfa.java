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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Sayfa_Tb")
public class Sayfa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan ID
	@Column(name = "id")
	int id;

	private String sayfa_adi;

	private String sayfa_kodu;

	private int sayfa_sira;

	private String sayfa_icon;

	private int sayfa_statu_id;

	private Timestamp sayfa_acilis_tarihi;

	private Timestamp sayfa_guncelleme_tarihi;

}
