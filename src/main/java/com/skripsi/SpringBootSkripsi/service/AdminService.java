/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Admin;
import com.skripsi.SpringBootSkripsi.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Service
public class AdminService implements AdminServiceInterface{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> adminList() {
        return adminRepository.findAll();
    }

    @Override
    public Admin addAdmin(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
