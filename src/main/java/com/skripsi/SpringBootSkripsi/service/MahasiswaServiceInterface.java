/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Mahasiswa;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface MahasiswaServiceInterface {
    public List<Mahasiswa> mahasiswaList();
    public Mahasiswa addMahasiswa(Mahasiswa mahasiswa);
}
