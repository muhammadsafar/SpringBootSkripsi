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
@Table(name = "ROLE")
@EntityListeners(AuditingEntityListener.class)
public class Role{

    @Id
    @Column(name = "ID_ROLE")
    private Integer idRole;
    @Column(name = "ROLE")
    private String role;
    @OneToMany(mappedBy = "idRole", fetch = FetchType.LAZY)
    private List<Dosen> dosenList;
    @OneToMany(mappedBy = "idRole", fetch = FetchType.LAZY)
    private List<Admin> adminList;
    @OneToMany(mappedBy = "idRole", fetch = FetchType.LAZY)
    private List<Mahasiswa> mahasiswaList;

    public Role() {
    }

    public Role(Integer idRole, String role) {
        this.idRole = idRole;
        this.role = role;
    }

    public Role(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
