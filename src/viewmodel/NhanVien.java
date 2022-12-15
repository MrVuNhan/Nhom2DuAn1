/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author FPTSHOP
 */
public class NhanVien {

    private String id, ma, ten, sdt, diachi, emailString, ngaysinh, matkhau;
    private int ngayCong;
    private int GioiTinh, trangThai;

    private boolean gioiTinh1, trangThai1;
    private double luong;
    private Date ngayVao;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String sdt, String diachi, String emailString, String ngaysinh, String matkhau, int ngayCong, boolean gioiTinh1, boolean trangThai1, double luong, Date ngayVao) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.emailString = emailString;
        this.ngaysinh = ngaysinh;
        this.matkhau = matkhau;
        this.ngayCong = ngayCong;
        this.gioiTinh1 = gioiTinh1;
        this.trangThai1 = trangThai1;
        this.luong = luong;
        this.ngayVao = ngayVao;
    }

    public NhanVien(String ma, String ten, String sdt, String diachi, String emailString, String ngaysinh, String matkhau, int ngayCong, int GioiTinh, int trangThai, double luong) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.emailString = emailString;
        this.ngaysinh = ngaysinh;
        this.matkhau = matkhau;
        this.ngayCong = ngayCong;
        this.GioiTinh = GioiTinh;
        this.trangThai = trangThai;
        this.luong = luong;

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

    public Date getNgayVao() {
        return ngayVao;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isGioiTinh1() {
        return gioiTinh1;
    }

    public void setGioiTinh1(boolean gioiTinh1) {
        this.gioiTinh1 = gioiTinh1;
    }

    public boolean isTrangThai1() {
        return trangThai1;
    }

    public void setTrangThai1(boolean trangThai1) {
        this.trangThai1 = trangThai1;
    }

    public void setNgayVao(Date ngayVao) {
        this.ngayVao = ngayVao;
    }

    public NhanVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmailString() {
        return emailString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String gtinh() {
        if (gioiTinh1 == true) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    public String tthai() {
        if (trangThai1 == true) {
            return "Còn Làm";
        } else {
            return "Nghỉ Làm";
        }
    }

    public Object[] toDataRow() {
        return new Object[]{ma,};
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", sdt=" + sdt + ", diachi=" + diachi + ", emailString=" + emailString + ", ngaysinh=" + ngaysinh + ", matkhau=" + matkhau + ", gioiTinh=" + gioiTinh1 + ", trangThai=" + trangThai1 + '}';
    }
}
