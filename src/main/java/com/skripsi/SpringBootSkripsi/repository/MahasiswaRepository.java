/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.repository;

import com.skripsi.SpringBootSkripsi.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author muhammad
 */
@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer>{
    
}
