/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controllerService;

import com.skripsi.SpringBootSkripsi.model.Dosen;
import com.skripsi.SpringBootSkripsi.repository.DosenRepository;
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
@RequestMapping("/dosen")
public class DosenController {
 
    @Autowired
    DosenRepository dosenRepository;
    
    @GetMapping("/list")
    public List<Dosen> listDosen(){
    
        return dosenRepository.findAll();
    }
    
    @PostMapping("/add")
    public Dosen savedos(@Valid @RequestBody Dosen nik){
    
        return dosenRepository.save(nik);
    }
    
    @GetMapping("/get/{nik}")
    public Optional<Dosen> getByMinat(@PathVariable(value = "nik") Integer nik){
        return dosenRepository.findById(nik);
    }
    
    @DeleteMapping("{/delete/{nik}}")
    public ResponseEntity<?> deleteKem(@PathVariable(value = "nik") Integer nik) {
        dosenRepository.deleteById(nik);

        return ResponseEntity.ok().build();
    }
}
