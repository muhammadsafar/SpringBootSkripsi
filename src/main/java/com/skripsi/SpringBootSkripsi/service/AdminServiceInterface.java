/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;
import com.skripsi.SpringBootSkripsi.model.Admin;

import java.util.List;

/**
 *
 * @author Dayinta Warih Wulandari
 */
public interface AdminServiceInterface {
    	public List<Admin> adminList();
        public Admin addAdmin(Admin admin);
}
