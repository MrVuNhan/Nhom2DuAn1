/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.KhachHang;
import java.util.List;
import viewmodel.KhachHangViewModel;

/**
 *
 * @author FPTSHOP
 */
public interface KhachHangService {

    List<KhachHangViewModel> getAll();

    List<KhachHangViewModel> search(List<KhachHangViewModel> listTim, String ma);

    String add(KhachHang kh);

    String update(KhachHang kh, String ma);

    String xoa(String ma);
    
    KhachHangViewModel getOneKH(String idKH);
}
