/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author admin
 */
public class LoaiSP {

    private String id;
    private String maLoai;
    private String tenLoai;
    private String congDung;

    public LoaiSP(String maLoai, String tenLoai, String congDung) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.congDung = congDung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LoaiSP(String id, String maLoai, String tenLoai, String congDung) {
        this.id = id;
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.congDung = congDung;
    }

    public LoaiSP() {
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

   

}
