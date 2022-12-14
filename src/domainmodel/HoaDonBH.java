/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.Date;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonBH {

    private String ma;
    private String tenNV;
    private Date ngayTao;
    private int trangThai;
    private String tenKH;

    public HoaDonBH() {
    }

    public HoaDonBH(String ma, String tenNV, Date ngayTao, int trangThai, String tenKH) {
        this.ma = ma;
        this.tenNV = tenNV;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.tenKH = tenKH;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }


}
