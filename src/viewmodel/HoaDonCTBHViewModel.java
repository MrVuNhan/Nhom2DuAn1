/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCTBHViewModel {
    
    private String tenSP;
    private String tenLSP;
    private String tenMS;
    private String tenCL;
    private String tenSz;
    private String tenNsx;
    private int sl;
    private Double donGia;
    
    public HoaDonCTBHViewModel() {
    }
    
    public HoaDonCTBHViewModel(String tenSP, String tenLSP, String tenMS, String tenCL, String tenSz, String tenNsx, int sl, Double donGia) {
        this.tenSP = tenSP;
        this.tenLSP = tenLSP;
        this.tenMS = tenMS;
        this.tenCL = tenCL;
        this.tenSz = tenSz;
        this.tenNsx = tenNsx;
        this.sl = sl;
        this.donGia = donGia;
    }
    
    public String getTenSP() {
        return tenSP;
    }
    
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    
    public String getTenLSP() {
        return tenLSP;
    }
    
    public void setTenLSP(String tenLSP) {
        this.tenLSP = tenLSP;
    }
    
    public String getTenMS() {
        return tenMS;
    }
    
    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }
    
    public String getTenCL() {
        return tenCL;
    }
    
    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }
    
    public String getTenSz() {
        return tenSz;
    }
    
    public void setTenSz(String tenSz) {
        this.tenSz = tenSz;
    }
    
    public String getTenNsx() {
        return tenNsx;
    }
    
    public void setTenNsx(String tenNsx) {
        this.tenNsx = tenNsx;
    }
    
    public int getSl() {
        return sl;
    }
    
    public void setSl(int sl) {
        this.sl = sl;
    }
    
    public Double getDonGia() {
        return donGia;
    }
    
    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    
    public Double tinhTien() {
        return this.sl * this.donGia;
    }
    
    public Object[] toDataRow() {
        return new Object[]{tenSP, tenLSP, tenMS, tenCL, tenSz, tenNsx, sl, donGia, tinhTien()};
    }
}
