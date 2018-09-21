/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controller;

import com.skripsi.SpringBootSkripsi.model.Admin;
import com.skripsi.SpringBootSkripsi.model.Role;
import com.skripsi.SpringBootSkripsi.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author muhammad
 */
@RestController
public class RegistrationController {
    
    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    
    @Autowired
    private NotificationService notificationService;
    
    @RequestMapping("/signup")
    public String signup(){
    
        return "please sign up before";
    }
    
    @RequestMapping("/signup-success")
    public String signupSUccess(){
    
        //create admin
        Admin admin = new Admin();
        admin.setNik(12345);
        admin.setNama("budi");
        admin.setPassword("kosong");
        admin.setEmail("muhammadsafartanjoeng@gmail.com");
        admin.setIdRole(new Role(1, ""));
        
        //send notification
        try {
            notificationService.sendNotif(admin);
        } catch (MailException e) {
            //sending error
            logger.info("Error to send Email : " + e.getMessage());
        }
        
        return "thanks for sign up";
    }
    
}