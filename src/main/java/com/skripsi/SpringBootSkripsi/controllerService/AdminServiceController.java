/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controllerService;

import com.skripsi.SpringBootSkripsi.model.Admin;
import com.skripsi.SpringBootSkripsi.repository.AdminRepository;
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
@RequestMapping("/admin")
public class AdminServiceController {
    
    @Autowired
    AdminRepository adminRepository;
    
    @GetMapping("/list")
    public List<Admin> getAllAdmin(){
    
        return adminRepository.findAll();
    }
    
    @PostMapping("/add")
    public Admin saveAdm(@Valid @RequestBody Admin nik){
    
        return adminRepository.save(nik);
    }
    
    @GetMapping("/get/{nik}")
    public Optional<Admin> getByMinat(@PathVariable(value = "nik") Integer nik){
        return adminRepository.findById(nik);
    }
    
    @DeleteMapping("{/delete/{nik}}")
    public ResponseEntity<?> deleteKem(@PathVariable(value = "nik") Integer nik) {
        adminRepository.deleteById(nik);

        return ResponseEntity.ok().build();
    }
    
}
