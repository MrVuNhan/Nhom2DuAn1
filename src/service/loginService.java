/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.NhanVien;
import viewmodel.QuanLyViewModel;

/**
 *
 * @author vungo
 */
public interface loginService {

    List<NhanVien> getALLNV();

    List<QuanLyViewModel> getALLQL();
    
    String updateNV(String newPass,String maNV);

}
