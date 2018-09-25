/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author budiarti
 */
@Entity
@Table(name = "MAHASISWA")
@EntityListeners(AuditingEntityListener.class)
public class Mahasiswa {

    @Id
    @Column(name = "NIM")
    private Integer nim;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "JURUSAN")
    private String jurusan;
    @Column(name = "ANGKATAN")
    private String angkatan;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "IMAGE")
    private String image;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "nim", fetch = FetchType.LAZY)
    private List<Skripsi> skripsiList;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role idRole;

    public Mahasiswa() {
    }

    public Mahasiswa(Integer nim, String nama, String jurusan, String angkatan, String password, String image, String email, Role idRole) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.angkatan = angkatan;
        this.password = password;
        this.image = image;
        this.email = email;
        this.idRole = idRole;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    

}
