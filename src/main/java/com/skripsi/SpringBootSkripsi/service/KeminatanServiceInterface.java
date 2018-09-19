/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.SpringBootSkripsi.service;

import com.skripsi.SpringBootSkripsi.model.Keminatan;
import java.util.List;

/**
 *
 * @author budiarti
 */
public interface KeminatanServiceInterface {
    public List<Keminatan> ListMinat();
    public Keminatan saveOrUpdateKeminatan(Keminatan minat);
}
