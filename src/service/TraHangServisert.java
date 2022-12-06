/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HoaDonModel;

/**
 *
 * @author vungo
 */
public interface TraHangServisert {

    List<HoaDonModel> getall();

    String getallbymahoadon(HoaDonModel hd,String mahd);

    String updateCTHD(String idHD, int soluongTra);

    String update(String idKH, String idHD,String tenKH,int soLuong,double donGia);
    
    String getoneIDKH(String maKH);
    
    String getOneIDHD(String maHD);
    
    String getIDCTHD(String idHD);
    
    Integer getSoLuong(String idHD);


}
