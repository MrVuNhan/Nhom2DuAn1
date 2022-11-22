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
     private String mahd;
    private String tennv;
    private String ngaytao;
    private String ngaythu;
    private int    soluong;
    private double dongia;
    private int trangthai;

    public HoaDonModel() {
    }

    public HoaDonModel(String mahd, String tennv, String ngaytao, String ngaythu, int soluong, double dongia, int trangthai) {
        this.mahd = mahd;
        this.tennv = tennv;
        this.ngaytao = ngaytao;
        this.ngaythu = ngaythu;
        this.soluong = soluong;
        this.dongia = dongia;
        this.trangthai = trangthai;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
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

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    public double tongtien(int soluong , double dongia){
        return soluong * dongia;
    }
    public String trangthai1( int trangthai){
        if(trangthai==0){
            return "Da Thu";
        }
        else{
            return "chua thu";
        }
    }
    public Object[] todata(){
        return new Object[] {mahd,tennv,ngaytao,ngaythu,soluong,dongia,tongtien(soluong, dongia),trangthai1(trangthai)};
    }
    
}
