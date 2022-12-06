/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.SanPhamCT;
import java.util.List;
import viewmodel.SanPhamChiTietViewModel;

/**
 *
 * @author FPTSHOP
 */
public interface SanPhamCTService {
    List<SanPhamChiTietViewModel> getAll();
    
    String add(SanPhamCT sp);
    String update(SanPhamCT sp, String ma);
    String deleta(String id);
    
    SanPhamChiTietViewModel getOneSP(SanPhamChiTietViewModel sp , int soLuong , String idSP);
}
