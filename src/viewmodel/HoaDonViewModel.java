
package viewmodel;

public class HoaDonViewModel {
    private String ma;
    private String tenSP;
    private String tenNguoiNhan;
    private int soLuong;
    private double donGia;
    private String ngayTao;
    private String ngayThu;
    private String trangThai;

    public HoaDonViewModel() {
    }
    
    public HoaDonViewModel(String ma, String tenSP, String tenNguoiNhan, int soLuong, double donGia, String ngayTao, String ngayThu, String trangThai) {
        this.ma = ma;
        this.tenSP = tenSP;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ngayTao = ngayTao;
        this.ngayThu = ngayThu;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
