/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author FPTSHOP
 */
public class KhachHangViewModel {

    private String id;
    private String ma;
    private String ten;
    private boolean gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String diaChi;

    public KhachHangViewModel() {
    }

    public KhachHangViewModel(String id, String ma, String ten, boolean gioiTinh, String ngaySinh, String sdt, String diaChi) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String gioiTinh(boolean gioiTinh) {
        if (gioiTinh == true) {
            return "Nữ";
        } else {
            return "Nam";
        }
    }

    public Object[] toDataRow() {
        return new Object[]{ma, ten, gioiTinh(gioiTinh), ngaySinh, sdt, diaChi, id};
    }

    @Override
    public String toString() {
        return "KhachHangViewModel{" + "ma=" + ma + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", diaChi=" + diaChi + '}';
    }
    
}
