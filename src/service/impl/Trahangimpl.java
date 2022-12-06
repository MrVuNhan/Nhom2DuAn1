/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.TraHangreponsitory;
import service.TraHangServisert;
import viewmodel.HoaDonModel;

/**
 *
 * @author vungo
 */
public class Trahangimpl implements TraHangServisert {

    private TraHangreponsitory rep = new TraHangreponsitory();

    @Override
    public List<HoaDonModel> getall() {
        return rep.getall();
    }

    @Override
    public String getallbymahoadon(HoaDonModel hd, String mahd) {
        return rep.getallbymahoadon(hd, mahd);
    }

    @Override
    public String updateCTHD(String idHD, int soluongTra) {

        boolean test = rep.updateCTHD(idHD, soluongTra);
        if (test) {
            return "update CTHD thành công";
        } else {
            return "update CTHD  thất bại";
        }
    }

    @Override
    public String update(String idKH, String idHD, String tenKH, int soLuong, double donGia) {
        boolean testhu = rep.update(idKH, idHD,  tenKH, soLuong, donGia);
        if (testhu) {
            return "UpDate thành công";
        } else {
            return "UpDate thất bại";
        }
    }

    @Override
    public String getoneIDKH(String maKH) {
        return rep.getIDKH(maKH);
    }

    @Override
    public String getOneIDHD(String maHD) {
        return rep.getIDHD(maHD);
    }

    @Override
    public String getIDCTHD(String idHD) {
        return rep.getIDCTHD(idHD);
    }

    @Override
    public Integer getSoLuong(String idHD) {
        return rep.getSoLuong(idHD);
    }
}
