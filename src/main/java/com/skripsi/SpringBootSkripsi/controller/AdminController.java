/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.controller;

//import com.skripsi.SpringBootSkripsi.controllerService.*;
import com.skripsi.SpringBootSkripsi.model.Admin;
import com.skripsi.SpringBootSkripsi.model.Keminatan;
import com.skripsi.SpringBootSkripsi.model.Mahasiswa;
import com.skripsi.SpringBootSkripsi.model.Role;
import com.skripsi.SpringBootSkripsi.model.Skripsi;
import com.skripsi.SpringBootSkripsi.repository.AdminRepository;
import com.skripsi.SpringBootSkripsi.repository.DosenRepository;
import com.skripsi.SpringBootSkripsi.repository.KeminatanRepository;
import com.skripsi.SpringBootSkripsi.repository.MahasiswaRepository;
import com.skripsi.SpringBootSkripsi.repository.SkripsiRepository;
import com.skripsi.SpringBootSkripsi.service.AdminService;
import com.skripsi.SpringBootSkripsi.service.DosenService;
import com.skripsi.SpringBootSkripsi.service.KeminatanService;
import com.skripsi.SpringBootSkripsi.service.MahasiswaService;
import com.skripsi.SpringBootSkripsi.service.NotificationService;
import com.skripsi.SpringBootSkripsi.service.SkripsiService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author muhammad
 */
@Controller
//@RestController
//@RequestMapping("/admin")
public class AdminController {
    
    //email sender logger
    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    
    //serice email sender
    @Autowired
    private NotificationService notificationService;

    //end of set email sender
    
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    DosenRepository dosenRepository;

    @Autowired
    private DosenService dosenService;

    @Autowired
    KeminatanRepository keminatanRepository;

    @Autowired
    private KeminatanService keminatanservice;
    
    @Autowired
    SkripsiRepository skripsirepository;
    
    @Autowired
    private SkripsiService skripsiService;
            

    //THIS IS ADMIN AREA
    @RequestMapping("/dashboard")
    public String data(Model model) {

        return "index";
    }
    @RequestMapping("/login")
    public String dataLogin(Model model) {

        return "login";
    }
    
    @RequestMapping("/registrasi")
    public String dataRegistrasi(Model model) {

        return "regis";
    }
    
    @RequestMapping("/profil")
    public String dataProfile(Model model) {

        return "profile";
    }

    @RequestMapping("/listAdmin")
    public String dataRegion(Model model) {
        model.addAttribute("listAdmin", adminService.adminList());

        return "admin";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
    public String formAddOrEdit(Model model) {
        model.addAttribute("admin", new Admin());
        return "formAddAdmin";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public String simpanAdmin(Model model, Integer nik, String nama, String pass, String image, String email) {
        Admin admin = new Admin(nik, nama, pass, image, email, new Role(1, ""));
        model.addAttribute("admin", adminService.saveOrUpdateAdmin(admin));
        
        try {
            notificationService.sendNotif(admin);
        } catch (MailException e) {
            //sending error
            logger.info("Error to send Email : " + e.getMessage());
        }
        
        return "redirect:/listAdmin";
    }

    //THIS IS STUDENT AREA
    @RequestMapping("/Mahasiswa")
    public String dataMahasiswa(Model model) {
        model.addAttribute("listMhs", mahasiswaService.mahasiswaList());
        return "mahasiswa";
    }
    
    @RequestMapping(value = "/addMahasiswa", method = RequestMethod.GET)
    public String formAddOrUpdate(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "mahasiswa";
    }

//    @RequestMapping(value = "/addMahasiswa", method = RequestMethod.POST)
//    public String simpanAdmin(Model model, Integer nim, String nama, String jurusan, String angkatan, String password, String image, String email) {
//        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, jurusan, angkatan, password, image, email, new Role(3, ""));
//        model.addAttribute("mahasiswa", mahasiswaService.addMahasiswa(mahasiswa));
//        
////        try {
////            notificationService.sendNotif(admin);
////        } catch (MailException e) {
////            //sending error
////            logger.info("Error to send Email : " + e.getMessage());
////        }
////        
//        return "";
//    }

    //THIS IS LECTURER AREA
    @RequestMapping("/Dosen")
    public String dataDosen(Model model) {
        model.addAttribute("listDosen", dosenService.dosenList());

        return "dosen";
    }

    //THIS IS MAJOR AREA
    @GetMapping("/listMinat")
    public String dataMinat(Model model) {
        model.addAttribute("listMinat", keminatanservice.ListMinat());
        return "keminatan";
    }
    
    @RequestMapping(value = "/addMinat", method = RequestMethod.GET)
    public String formAddOrEditMinat(Model model) {
        model.addAttribute("keminatan", new Keminatan());
        return "formAddMinat";
    }

    @RequestMapping(value = "/addMinat", method = RequestMethod.POST)
    public String simpanMinat(Model model, Integer id, String keminatan) {
        Keminatan minat = new Keminatan(id, keminatan);
        model.addAttribute("keminatan", keminatanservice.saveOrUpdateKeminatan(minat));
        return "redirect:/listMinat";
    }
    
    //THIS IS MAJOR AREA
    @RequestMapping("/listSkrip")
    public String dataSkripsi(Model model) {
        model.addAttribute("listSkripsi", skripsirepository.findAll());
        return "skripsi";
    }
    
    @RequestMapping("/Pengajuan")
    public String dataPengajuan (Model m){
        m.addAttribute("dataPengajuan", skripsirepository.findAll());
        return "pengajuan";
    }
    @RequestMapping("/listPengajuan")
    public String listPengajuan (Model m){
        m.addAttribute("listPengajuan", new Skripsi());
        m.addAttribute("listDosen", dosenService.dosenList());
        m.addAttribute("listMinat", keminatanservice.ListMinat());
        return "/mahasiswa/listPengajuan";
    }
    
    @RequestMapping("/halMahasiswa")
    public String datalistMahasiswa (Model m){
        m.addAttribute("halMahasiswa", skripsirepository.findAll());
        return "/mahasiswa/halMahasiswa";
    }
    @RequestMapping("/listMahasiswa")
    public String listMahasiswa (Model m){
        m.addAttribute("listMahasiswa", skripsirepository.findAll());
        return "/mahasiswa/listMahasiswa";
    }
    @RequestMapping("/halDosen")
    public String halDosen (Model m){
        m.addAttribute("halamanDosen", skripsirepository.findAll());
        return "/dosen/halDosen";
    }
    @RequestMapping("/dataDosen")
    public String listDosen (Model m){
        m.addAttribute("dataDosen", skripsirepository.findAll());
        return "/dosen/dataDosen";
    }
    @RequestMapping("/dataPengajuanDosen")
    public String dataPengajuanDosen (Model m){
        m.addAttribute("dataPengajuanDosen", skripsirepository.findAll());
        return "/dosen/dataPengajuan";
    }

}
