/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author budiarti
 */
@Entity
@Table(name = "KEMINATAN")
//@EntityListeners(AuditingEntityListener.class)
public class Keminatan {

    @Id
    @Column(name = "ID_MINAT")
    private Integer idMinat;
    @Column(name = "KEMINATAN")
    private String keminatan;
    @OneToMany(mappedBy = "idMinat")
    private List<Skripsi> skripsiList;

    public Keminatan() {
    }

    public Keminatan(Integer idMinat, String keminatan) {
        this.idMinat = idMinat;
        this.keminatan = keminatan;
    }
    
    public Integer getIdMinat() {
        return idMinat;
    }

    public void setIdMinat(Integer idMinat) {
        this.idMinat = idMinat;
    }

    public String getKeminatan() {
        return keminatan;
    }

    public void setKeminatan(String keminatan) {
        this.keminatan = keminatan;
    }

    public void setSkripsiList(List<Skripsi> skripsiList) {
        this.skripsiList = skripsiList;
    }

}
