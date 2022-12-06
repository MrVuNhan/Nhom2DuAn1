/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.text.DecimalFormat;
import ulities.DBConnection;

/**
 *
 * @author Asus
 */
public class ThongKeViewModle {

    private HoaDonTK idHD;
    private ChiTietSanPhamTK idCTSP;
    private int soLuong;
    private double donGia;

    public ThongKeViewModle() {
    }

    public ThongKeViewModle(HoaDonTK idHD, ChiTietSanPhamTK idCTSP, int soLuong, double donGia) {
        this.idHD = idHD;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ThongKeViewModle(HoaDonTK idHD, ChiTietSanPhamTK idCTSP, int soLuong) {
        this.idHD = idHD;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
    }

    public HoaDonTK getIdHD() {
        return idHD;
    }

    public void setIdHD(HoaDonTK idHD) {
        this.idHD = idHD;
    }

    public ChiTietSanPhamTK getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(ChiTietSanPhamTK idCTSP) {
        this.idCTSP = idCTSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public Double thTien(){
        return (idCTSP.getGiaBan() - idCTSP.getGiaNhap())*soLuong;
    }
    public Object[] toDataRow() {
        DecimalFormat ds = new DecimalFormat("###,###,###,###");
        return new Object[]{idHD.getIdNV().getMa(),idHD.getIdNV().getTen(),idHD.getNgayTao()
                , idCTSP.getIdSp().getMaSP(),idCTSP.getIdSp().getTenSP(),ds.format(soLuong)
                ,ds.format(idCTSP.getGiaNhap() *soLuong),ds.format(idCTSP.getGiaBan() * soLuong)
                , ds.format(thTien())};
    }

}
