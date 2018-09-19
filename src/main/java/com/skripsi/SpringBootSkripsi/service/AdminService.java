/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Admin;
import com.skripsi.SpringBootSkripsi.repository.AdminRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Service
public class AdminService implements AdminServiceInterface{
    
    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> adminList() {
        return adminRepository.findAll();
    }

    @Override
    public Admin saveOrUpdateAdmin(Admin admin) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Admin saved = em.merge(admin);
        em.getTransaction().commit();
        return saved;
    }


    
}
