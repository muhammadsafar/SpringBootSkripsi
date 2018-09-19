/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Mahasiswa;
import com.skripsi.SpringBootSkripsi.repository.MahasiswaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Simbok_pc
 */

@Service
public class MahasiswaService implements MahasiswaServiceInterface{

    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    
    @Override
    public List<Mahasiswa> mahasiswaList() {
        return mahasiswaRepository.findAll();
    }

    @Override
    public Mahasiswa addMahasiswa(Mahasiswa mahasiswa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
