/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Keminatan;
import com.skripsi.SpringBootSkripsi.repository.KeminatanRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author budiarti
 */
@Service
public class KeminatanService implements KeminatanServiceInterface{

    private EntityManagerFactory emf;
    
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Autowired
    KeminatanRepository repository;
    
   
    @Override
    public List<Keminatan> ListMinat() {
        return repository.findAll();
    }

    @Override
    public Keminatan saveOrUpdateKeminatan(Keminatan minat) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Keminatan saved = em.merge(minat);
        em.getTransaction().commit();
        return saved;
    }
    
}
