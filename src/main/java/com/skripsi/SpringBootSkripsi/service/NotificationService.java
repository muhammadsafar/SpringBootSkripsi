/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author muhammad
 */
@Service
public class NotificationService {
    
    private JavaMailSender javaMailSender;
    
    @Autowired

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    public void sendNotif(Admin admin) throws MailException{
        //send mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(admin.getEmail());
        mail.setFrom("muhammad.ict1487@gmail.com");
        mail.setSubject("Noreply, this is just an amazing email sender notification");
        mail.setText("welcome to the project, Congrats you are have been registration");
        
        javaMailSender.send(mail);
    }
}
