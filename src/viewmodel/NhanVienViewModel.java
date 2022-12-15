/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class NhanVienViewModel {

    private String id, ma, ten;
    private boolean gioitinh;
    private String ngaySinh, sdt, diaChi, email;
    private String mk;
    private int ngayCong;
    private double luong;
    private int trangThai;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(String id, String ma, String ten, boolean gioitinh, String ngaySinh, String sdt, String diaChi, String email, String mk, int ngayCong, double luong, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.mk = mk;
        this.ngayCong = ngayCong;
        this.luong = luong;
        this.trangThai = trangThai;
    }

    public NhanVienViewModel(String ma, String ten, boolean gioitinh, String ngaySinh, String sdt, String diaChi, String email, String mk, int ngayCong, double luong, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.mk = mk;
        this.ngayCong = ngayCong;
        this.luong = luong;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String gtinh(boolean gioiTinh) {
        if (gioiTinh == true) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    public double lg() {
        return ngayCong * 90000;
    }

    public String tthai() {
        if (trangThai == 1) {
            return "Còn Làm";
        } else {
            return "Nghỉ Làm";
        }
    }

    public Object[] toDataRow() {
        return new Object[]{ma, ten, gtinh(gioitinh), ngaySinh, sdt, diaChi, email, ngayCong, lg(), tthai(),mk};
    }
}
