/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Dosen;
import com.skripsi.SpringBootSkripsi.repository.DosenRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Simbok_pc
 */

@Service
public class DosenService implements DosenServiceInterface{
    
    @Autowired
    public DosenRepository dosenRepository;

    @Override
    public List<Dosen> dosenList() {
        return dosenRepository.findAll();
    }

    @Override
    public Dosen addDosen(Dosen dosen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
