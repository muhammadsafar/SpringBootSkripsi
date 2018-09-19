/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Dosen;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface DosenServiceInterface {
    public List<Dosen> dosenList();
    public Dosen addDosen(Dosen dosen);
}
