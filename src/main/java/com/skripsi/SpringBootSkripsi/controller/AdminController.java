/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controller;

//import com.skripsi.SpringBootSkripsi.controllerService.*;
import com.skripsi.SpringBootSkripsi.model.Admin;
import com.skripsi.SpringBootSkripsi.repository.AdminRepository;
import com.skripsi.SpringBootSkripsi.service.AdminService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

/**
 *
 * @author muhammad
 */
@Controller
//@RestController
//@RequestMapping("/admin")
public class AdminController {
    
        @Autowired
        AdminRepository adminRepository;
        
	@RequestMapping("/dashboard")
	public String data(Model model) {
		
            return "index";
	}
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("/listAdmin")
	public String dataRegion(Model model) {
            model.addAttribute("listAdmin", adminService.adminList());
		
            return "admin";
	}
    
}
