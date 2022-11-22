/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamChiTietViewModel {
    
    private String id;
    private String tenSP;
    private String loaiSP;
    private String mauSac;
    private String chatLieu;
    private String Size;
    private String Nsx;
    private int slt;
    private Double giaNhap;
    private Double giaBan;
    private String moTa;
    private int trangThai;
    
    public SanPhamChiTietViewModel() {
    }
    
    public SanPhamChiTietViewModel(String id, String tenSP, String loaiSP, String mauSac, String chatLieu, String Size, String Nsx, int slt, Double giaNhap, Double giaBan, String moTa, int trangThai) {
        this.id = id;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.Size = Size;
        this.Nsx = Nsx;
        this.slt = slt;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTenSP() {
        return tenSP;
    }
    
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    
    public String getLoaiSP() {
        return loaiSP;
    }
    
    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }
    
    public String getMauSac() {
        return mauSac;
    }
    
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    
    public String getChatLieu() {
        return chatLieu;
    }
    
    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }
    
    public String getSize() {
        return Size;
    }
    
    public void setSize(String Size) {
        this.Size = Size;
    }
    
    public String getNsx() {
        return Nsx;
    }
    
    public void setNsx(String Nsx) {
        this.Nsx = Nsx;
    }
    
    public int getSlt() {
        return slt;
    }
    
    public void setSlt(int slt) {
        this.slt = slt;
    }
    
    public Double getGiaNhap() {
        return giaNhap;
    }
    
    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }
    
    public Double getGiaBan() {
        return giaBan;
    }
    
    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }
    
    public String getMoTa() {
        return moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public int getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String trangThai1(int trangThai) {
        if (trangThai == 0) {
            return "Còn hàng";
        } else {
            return "Hết hàng";
        }
    }
    
    public Object[] toDataRow() {
        return new Object[]{id, tenSP, loaiSP, mauSac, chatLieu, Size, Nsx, slt, giaNhap, giaBan, moTa, trangThai1(trangThai)};
    }
}
