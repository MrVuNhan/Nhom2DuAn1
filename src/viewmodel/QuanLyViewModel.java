/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author lenovo
 */
public class QuanLyViewModel {
    private String id;
    private String ma;
    private String ten;
    private String sdt;
    private String email;
    private String ngayVao;
    private String ngayLamQuanLy;
    private String matKhau;
    private int trangthai;
    private boolean gioitinh;

    public QuanLyViewModel() {
    }

    public QuanLyViewModel(String id, String ma, String ten, String sdt, String email, String ngayVao, String ngayLamQuanLy, String matKhau, int trangthai, boolean gioitinh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.ngayVao = ngayVao;
        this.ngayLamQuanLy = ngayLamQuanLy;
        this.matKhau = matKhau;
        this.trangthai = trangthai;
        this.gioitinh = gioitinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    

    public QuanLyViewModel(String ma) {
        this.ma = ma;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getNgayLamQuanLy() {
        return ngayLamQuanLy;
    }

    public void setNgayLamQuanLy(String ngayLamQuanLy) {
        this.ngayLamQuanLy = ngayLamQuanLy;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "QuanLyViewModel{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", sdt=" + sdt + ", email=" + email + ", ngayVao=" + ngayVao + ", ngayLamQuanLy=" + ngayLamQuanLy + ", matKhau=" + matKhau + ", trangthai=" + trangthai + ", gioitinh=" + gioitinh + '}';
    }

    

   
    
}
