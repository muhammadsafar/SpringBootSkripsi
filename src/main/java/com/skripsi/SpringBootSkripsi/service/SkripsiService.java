/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Skripsi;
import com.skripsi.SpringBootSkripsi.repository.SkripsiRepository;
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
public class SkripsiService implements SkripsiServiceInterface{
    
    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Autowired
    private SkripsiRepository repository;
            
    @Override
    public List<Skripsi> SkripsiAll() {
        return repository.findAll();
    }

    @Override
    public Skripsi saveOrUpdateAdmin(Skripsi skripsi) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Skripsi saved = em.merge(skripsi);
        em.getTransaction().commit();
        return saved;
    }

}
