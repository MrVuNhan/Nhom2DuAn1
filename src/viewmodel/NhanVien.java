/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author lenovo
 */
public class NhanVien {

    private String id,ma, ten, sdt, diachi, emailString, ngaysinh, matkhau;
    private int gioiTinh, trangThai;

    public NhanVien() {
    }

    public NhanVien(String id, String ma, String ten, String sdt, String diachi, String emailString, String ngaysinh, String matkhau, int gioiTinh, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.emailString = emailString;
        this.ngaysinh = ngaysinh;
        this.matkhau = matkhau;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
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

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String gtinh() {
        if (gioiTinh == 1) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    public String tthai() {
        if (trangThai == 1) {
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
        return "NhanVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", sdt=" + sdt + ", diachi=" + diachi + ", emailString=" + emailString + ", ngaysinh=" + ngaysinh + ", matkhau=" + matkhau + ", gioiTinh=" + gioiTinh + ", trangThai=" + trangThai + '}';
    }
    
}
