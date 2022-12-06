/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.ThongKeViewModle;

/**
 *
 * @author Asus
 */
public interface ThongKeServices {

    List<ThongKeViewModle> getAll();

    List<ThongKeViewModle> listNgay(String ma);

    List<ThongKeViewModle> listThang(String ma);

    List<ThongKeViewModle> listNam(String ma);

    List<ThongKeViewModle> listAll(String ma);
    
    List<ThongKeViewModle> listNgayThang(String ngay, String thang);
    
    List<ThongKeViewModle> listNamThang(String thang, String nam);
    
    List<ThongKeViewModle> listNamNgay(String ngay, String nam);
            
}
