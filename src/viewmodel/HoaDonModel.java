/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author vungo
 */
public class HoaDonModel {

    private String maKH;
    private String mahd;
    private String tenkh;
    private String ngaytao;
    private String ngaythu;
    private String diachi;
    private String sdt;
    private int trangthai;
    private int soluong;
    private double dongia;
    private String ngaytra;

    public HoaDonModel() {
    }

    public HoaDonModel(String maKH, String mahd, String tenkh, String ngaytao, String ngaythu, String diachi, String sdt, int trangthai) {
        this.maKH = maKH;
        this.mahd = mahd;
        this.tenkh = tenkh;
        this.ngaytao = ngaytao;
        this.ngaythu = ngaythu;
        this.diachi = diachi;
        this.sdt = sdt;
        this.trangthai = trangthai;
    }



   

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public HoaDonModel(String mahd, String tenkh, int soluong, double dongia, String ngaytra) {
        this.mahd = mahd;
        this.tenkh = tenkh;
        this.soluong = soluong;
        this.dongia = dongia;
        this.ngaytra = ngaytra;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNgaythu() {
        return ngaythu;
    }

    public void setNgaythu(String ngaythu) {
        this.ngaythu = ngaythu;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    // trạng thái tính tổng tiền 
    public double tongtien(int soLuong, double donGia) {
        return soluong * dongia;
    }

    public HoaDonModel(int soluong) {
        this.soluong = soluong;
    }

    // trang thái đã thu hoặc chưa thu
    public String trangthai1(int trangthai) {
        if (trangthai == 0) {
            return " Chưa Thử ";
        } else {
            return "Đã Thử ";
        }
    }

    public Object[] todata() {
        return new Object[]{maKH,mahd, tenkh, ngaytao, ngaythu, diachi, sdt, trangthai1(trangthai)};
    }

    public Object[] todatarow() {
        return new Object[]{mahd, tenkh, soluong, dongia, tongtien(soluong, dongia)};
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "mahd=" + mahd + ", tenkh=" + tenkh + ", ngaytao=" + ngaytao + ", ngaythu=" + ngaythu + ", diachi=" + diachi + ", sdt=" + sdt + ", trangthai=" + trangthai + ", soluong=" + soluong + ", dongia=" + dongia + ", ngaytra=" + ngaytra + '}';
    }

}
