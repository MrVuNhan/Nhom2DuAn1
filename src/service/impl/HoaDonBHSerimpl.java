/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HoaDonBH;
import java.util.List;
import repository.HoaDonBHRepo;
import service.HoaDonBHSer;
import viewmodel.HoaDonBHViewModel;
import viewmodel.NhanVien;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonBHSerimpl implements HoaDonBHSer {

    private HoaDonBHRepo re = new HoaDonBHRepo();

    @Override
    public List<HoaDonBHViewModel> getAll() {
        return re.getAll();
    }

    @Override
    public String add(String ma, String IDNV) {
        boolean add = re.add(ma, IDNV);
        if (add) {
            return "add thanh cong";
        } else {
            return " add that bai";
        }
    }

    @Override
    public String getIDNV(String maNV) {
        return re.getOneIDNV(maNV);
    }

    @Override
    public String addCTHD(String idHD, String idCTSP, int soLuong, double DonGia) {
        boolean add = re.addCTHD(idHD, idCTSP, soLuong, DonGia);
        if (add) {
            return "add thanh cong";
        } else {
            return " add that bai";
        }
    }

    @Override
    public String getIDHD(String maHD) {
        return re.getOneIDHD(maHD);
    }

    @Override
    public boolean updateCTSP(String idCTSP, int soLuong) {
        return re.updateSLCT(idCTSP, soLuong);
    }

    @Override
    public List<HoaDonBHViewModel> getAll1() {
        return re.getAll1();
    }

    @Override
    public boolean updateTTHD(String idHD) {
        return re.updateTTHD(idHD);
    }

}
