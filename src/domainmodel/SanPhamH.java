/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamH {

    private String id;
    private String maSP;
    private String tenSP;

    public SanPhamH() {
    }

    public SanPhamH(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

}
