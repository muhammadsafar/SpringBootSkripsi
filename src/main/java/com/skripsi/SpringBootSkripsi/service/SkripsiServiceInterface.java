/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Skripsi;
import java.util.List;

/**
 *
 * @author Dayinta Warih Wulandari
 */
public interface SkripsiServiceInterface {
    List<Skripsi> SkripsiAll();
    public Skripsi saveOrUpdateAdmin(Skripsi skripsi);
}
