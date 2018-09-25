/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author budiarti
 */
@Entity
@Table(name = "SKRIPSI")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Skripsi{

    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TOPIK")
    private String topik;
    @Column(name = "JUDUL")
    private String judul;
    @Column(name = "DESKRIPSI")
    private String deskripsi;
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "PESAN")
    private String pesan;
    
    @JoinColumn(name = "NIK", referencedColumnName = "NIK")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dosen nik;
    
    @JoinColumn(name = "ID_MINAT")
    @ManyToOne()
    private Keminatan idMinat;
    
    @JoinColumn(name = "NIM", referencedColumnName = "NIM")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mahasiswa nim;

    public Skripsi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Skripsi(Integer id, String topik, String judul, String deskripsi, String status, String pesan, Dosen nik, Keminatan idMinat, Mahasiswa nim) {
        this.id = id;
        this.topik = topik;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.status = status;
        this.pesan = pesan;
        this.nik = nik;
        this.idMinat = idMinat;
        this.nim = nim;
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Dosen getNik() {
        return nik;
    }

    public void setNik(Dosen nik) {
        this.nik = nik;
    }

    public Keminatan getIdMinat() {
        return idMinat;
    }

    public void setIdMinat(Keminatan idMinat) {
        this.idMinat = idMinat;
    }

    public Mahasiswa getNim() {
        return nim;
    }

    public void setNim(Mahasiswa nim) {
        this.nim = nim;
    }

}
