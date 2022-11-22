
package domainmodel;


public class HoaDon {
    private String id;
    private String idKH;
    private String idNV;
    private String idKM;
    private String ma;
    private String ngayTao;
    private String ngayThu;
    private String tinhTrang;
    private String tenNguoiNhan;
    private String diaChi;
    private int sdt;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(String id, String idKH, String idNV, String idKM, String ma, String ngayTao, String ngayThu, String tinhTrang, String tenNguoiNhan, String diaChi, int sdt, String trangThai) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idKM = idKM;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThu = ngayThu;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", idKH=" + idKH + ", idNV=" + idNV + ", idKM=" + idKM + ", ma=" + ma + ", ngayTao=" + ngayTao + ", ngayThu=" + ngayThu + ", tinhTrang=" + tinhTrang + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChi=" + diaChi + ", sdt=" + sdt + ", trangThai=" + trangThai + '}';
    }

    
}
