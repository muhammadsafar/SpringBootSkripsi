/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Skripsi;
import com.skripsi.SpringBootSkripsi.repository.SkripsiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Service
public class SkripsiService implements SkripsiServiceInterface{

    @Autowired
    private SkripsiRepository repository;
            
    @Override
    public List<Skripsi> SkripsiAll() {
        return repository.findAll();
    }

}
