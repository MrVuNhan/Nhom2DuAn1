
package viewmodel;

public class HoaDonViewModel {
   private String ma;
    private String ngayTao;
    private String ngayThu;
    private String tinhTrang;
    private String tenNguoiNhan;
    private String diaChi;
    private int sdt;
    private int  trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String ma, String ngayTao, String ngayThu, String tinhTrang, String tenNguoiNhan, String diaChi, int sdt, int trangThai) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThu = ngayThu;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public HoaDonViewModel(String ma, String ngaytao, String ngaythu, String tinhtrang, String tennguoinhan, String diachi, int sdt, String trangthai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    public Object[] toDataRow() {
        return new Object[]{ma,ngayTao,ngayThu,tinhTrang,tenNguoiNhan,diaChi,sdt,trangThai};
    }
    
}
