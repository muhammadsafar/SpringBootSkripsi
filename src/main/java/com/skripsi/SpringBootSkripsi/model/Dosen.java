/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author budiarti
 */
@Entity
@Table(name = "DOSEN")
@EntityListeners(AuditingEntityListener.class)
public class Dosen {

    @Id
    @Column(name = "NIK")
    private BigDecimal nik;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "IMAGE")
    private String image;
    @OneToMany(mappedBy = "nik", fetch = FetchType.LAZY)
    private List<Skripsi> skripsiList;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role idRole;

    public Dosen() {
    }

    public Dosen(BigDecimal nik) {
        this.nik = nik;
    }

    public BigDecimal getNik() {
        return nik;
    }

    public void setNik(BigDecimal nik) {
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

    public void setSkripsiList(List<Skripsi> skripsiList) {
        this.skripsiList = skripsiList;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }
}
