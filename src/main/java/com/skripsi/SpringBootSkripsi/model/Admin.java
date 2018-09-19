/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author budiarti
 */
@Entity
@Table(name = "ADMIN")
//@EntityListeners(AuditingEntityListener.class)
public class Admin {

    @Id
    @Column(name = "NIK")
    private Integer nik;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "IMAGE")
    private String image;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role idRole;

    public Admin() {
    }

    public Admin(Integer nik, String nama, String password, String image, Role idRole) {
        this.nik = nik;
        this.nama = nama;
        this.password = password;
        this.image = image;
        this.idRole = idRole;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

   
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

}
