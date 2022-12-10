package domainmodel;

public class HoaDonCT {

    private String idHD;
    private String idCTSP;
    private int soLuong;
    private double donGia;

    public HoaDonCT() {
    }

    public HoaDonCT(String idHD, String idCTSP, int soLuong, double donGia) {
        this.idHD = idHD;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
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

    

    @Override
    public String toString() {
        return "HoaDonCT{" + "idHD=" + idHD + ", idCTSP=" + idCTSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

}
