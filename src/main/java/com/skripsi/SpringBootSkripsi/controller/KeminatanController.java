/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controller;

import com.skripsi.SpringBootSkripsi.model.Keminatan;
import com.skripsi.SpringBootSkripsi.repository.KeminatanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author muhammad
 */
@RestController
@RequestMapping("/keminatan")
public class KeminatanController {
    
    @Autowired
    KeminatanRepository repository;
    
    @GetMapping("/list")
    public List<Keminatan> getAllKeminatan(){
    
        return repository.findAll();
    }
    
}
