/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controllerService;

import com.skripsi.SpringBootSkripsi.model.Mahasiswa;
import com.skripsi.SpringBootSkripsi.repository.MahasiswaRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author muhammad
 */

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    
    @Autowired
    MahasiswaRepository mahasiswaRepository;
    
    @GetMapping("/list")
    public List<Mahasiswa> getAllmsh(){
    
        return mahasiswaRepository.findAll();
    }
    
    @PostMapping("/add")
    public Mahasiswa savemhs(@Valid @RequestBody Mahasiswa nim){
    
        return mahasiswaRepository.save(nim);
    }
    
    @GetMapping("/get/{nim}")
    public Optional<Mahasiswa> getBymhs(@PathVariable(value = "nim") Integer nim){
        return mahasiswaRepository.findById(nim);
    }
    
    @DeleteMapping("{/delete/{nim}}")
    public ResponseEntity<?> deletemhs(@PathVariable(value = "nim") Integer nim) {

        return ResponseEntity.ok().build();
    }
}
