/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Asus
 */
public class ChiTietSanPhamTK {
    private String id;
    private SanPhamViewModel idSp;
    private double giaNhap;
    private double giaBan;

    public ChiTietSanPhamTK() {
    }

    public ChiTietSanPhamTK(String id, SanPhamViewModel idSp, double giaNhap, double giaBan) {
        this.id = id;
        this.idSp = idSp;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSanPhamTK(SanPhamViewModel idSp, double giaNhap, double giaBan) {
        this.idSp = idSp;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPhamViewModel getIdSp() {
        return idSp;
    }

    public void setIdSp(SanPhamViewModel idSp) {
        this.idSp = idSp;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
}
