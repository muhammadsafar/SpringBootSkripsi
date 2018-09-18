/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controller;

import com.skripsi.SpringBootSkripsi.model.Dosen;
import com.skripsi.SpringBootSkripsi.repository.DosenRepository;
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
@RequestMapping("/dosen")
public class DosenController {
 
    @Autowired
    DosenRepository dosenRepository;
    
    @GetMapping("/listdosen")
    public List<Dosen> listDosen(){
    
        return dosenRepository.findAll();
    }
    
    
}
