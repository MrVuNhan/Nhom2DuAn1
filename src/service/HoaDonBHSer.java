/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.HoaDonBH;
import java.util.List;
import viewmodel.HoaDonBHViewModel;

/**
 *
 * @author FPTSHOP
 */
public interface HoaDonBHSer {

    List<HoaDonBHViewModel> getAll();
    
    String add(HoaDonBH hd);
}
