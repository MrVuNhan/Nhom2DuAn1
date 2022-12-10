/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.SanPhamCT;
import java.util.List;
import viewmodel.HoaDonCTBHViewModel;
import viewmodel.SanPhamChiTietViewModel;

/**
 *
 * @author FPTSHOP
 */
public interface SanPhamCTService {

    List<SanPhamChiTietViewModel> getAll();

    List<SanPhamChiTietViewModel> search(List<SanPhamChiTietViewModel> listTim, String ma);

    String add(SanPhamCT sp);

    String update(SanPhamCT sp, String ma);

    String deleta(String id);

    SanPhamChiTietViewModel getOneSP(SanPhamChiTietViewModel sp, int soLuong, String idSP);

    List<SanPhamChiTietViewModel> loclsp(String name);

    List<String> getalllsp();

    List<SanPhamChiTietViewModel> loclsp1(String name);
    List<SanPhamChiTietViewModel> locmau(String name);
     List<SanPhamChiTietViewModel> locchatlieu(String name);
     List<SanPhamChiTietViewModel> locsize(String name);
     List<SanPhamChiTietViewModel> locnhacungcap(String name);
    

    List<String> getalllsp1();
    
}
