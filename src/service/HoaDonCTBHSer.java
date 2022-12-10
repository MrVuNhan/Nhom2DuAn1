/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HoaDonCTBHViewModel;

/**
 *
 * @author FPTSHOP
 */
public interface HoaDonCTBHSer {
    List<HoaDonCTBHViewModel> getAll();
    List<HoaDonCTBHViewModel> loclsp(String name);
    List<String> getalllsp() ;
    
}
