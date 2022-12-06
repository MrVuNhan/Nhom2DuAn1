/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Asus
 */
public class HoaDonTK {
    private String id;
    private NhanVien idNV;
    private String ngayTao;

    public HoaDonTK() {
    }

    public HoaDonTK(String id, NhanVien idNV, String ngayTao) {
        this.id = id;
        this.idNV = idNV;
        this.ngayTao = ngayTao;
    }

    public HoaDonTK(NhanVien idNV, String ngayTao) {
        this.idNV = idNV;
        this.ngayTao = ngayTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

   
    
    
}
