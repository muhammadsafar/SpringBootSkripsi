/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controllerService;

import com.skripsi.SpringBootSkripsi.model.Keminatan;
import com.skripsi.SpringBootSkripsi.repository.KeminatanRepository;
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
@RequestMapping("/keminatan")
public class KeminatanController {
    
    @Autowired
    KeminatanRepository repository;
    
    @GetMapping("/list")
    public List<Keminatan> getAllKeminatan(){
    
        return repository.findAll();
    }
    
    @PostMapping("/add")
    public Keminatan saveKeminatan(@Valid @RequestBody Keminatan k){
        return repository.save(k);
    }
    
    @GetMapping("/get/{idMinat}")
    public Optional<Keminatan> getByMinat(@PathVariable(value = "idMinat") Integer idMinat){
        return repository.findById(idMinat);
    }
    
    @DeleteMapping("{/delete/{idMinat}}")
    public ResponseEntity<?> deleteKem(@PathVariable(value = "idMinat") Integer idMinat) {
        repository.deleteById(idMinat);

        return ResponseEntity.ok().build();
    }
}
