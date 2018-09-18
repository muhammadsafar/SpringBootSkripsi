/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controllerService;

import com.skripsi.SpringBootSkripsi.model.Skripsi;
import com.skripsi.SpringBootSkripsi.repository.SkripsiRepository;
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
@RequestMapping("/skripsi")
public class SkripsiController {
    
    @Autowired
    SkripsiRepository repository;
    
    @GetMapping("/list")
    public List<Skripsi> getAllSkripsi(){
    
        return repository.findAll();
    }
    
    @PostMapping("/add")
    public Skripsi saveKeminatan(@Valid @RequestBody Skripsi skripsi){
        return repository.save(skripsi);
    }
    
    @GetMapping("/get/{id}")
    public Optional<Skripsi> getByMinat(@PathVariable(value = "id") Integer id){
        return repository.findById(id);
    }
    
    @DeleteMapping("{/delete/{id}}")
    public ResponseEntity<?> deleteKem(@PathVariable(value = "id") Integer id) {
        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
