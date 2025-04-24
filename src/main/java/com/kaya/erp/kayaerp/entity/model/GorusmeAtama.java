package com.kaya.erp.kayaerp.entity.model;

import java.time.LocalDateTime;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Gorusme_Atama_Tb")
public class GorusmeAtama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artan
    private Integer gaid;

    private Integer gid;
    private String gadealer;
    private String gausername;

    @Column(name = "gatarih")
    private LocalDateTime gatarih; // datetime için uygun veri tipi

    private Integer gastatu;
    private String gastatubilgi;
    private Double gafiyat;
}
