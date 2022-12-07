/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.HoaDonBH;
import java.util.List;
import viewmodel.HoaDonBHViewModel;
import viewmodel.KhachHangViewModel;
import viewmodel.NhanVien;

/**
 *
 * @author FPTSHOP
 */
public interface HoaDonBHSer {

    List<HoaDonBHViewModel> getAll();

    List<HoaDonBHViewModel> getAll1();

    String add(String ma, String IDNV);

    String getIDNV(String maNV);

    String addCTHD(String idHD, String idCTSP, int soLuong, double DonGia);

    String getIDHD(String maHD);

    boolean updateCTSP(String idCTSP, int soLuong);

    boolean updateTTHD(String idHD,String idKH,String ten, String dc, String sdt);
    
    String getIDKH(String tenKH);
}
