/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author admin
 */
public class LoaiSPViewmodel {

    private String maLoai;
    private String tenLoai;
    private String congDung;

    public LoaiSPViewmodel() {
    }

    public LoaiSPViewmodel(String maLoai, String tenLoai, String congDung) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.congDung = congDung;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getCongDung() {
        return congDung;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }

    public Object[] toDataRow() {
        return new Object[]{maLoai, tenLoai, congDung};
    }

    @Override
    public String toString() {
        return tenLoai;
    }

}
