/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Asus
 */
public class ChatlieuViewModel {

    private String id;
    private String ma;
    private String ten;
    private String dacTinh;
    private String quyTrinh;

    public ChatlieuViewModel() {
    }

    public ChatlieuViewModel(String id, String ma, String ten, String dacTinh, String quyTrinh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.dacTinh = dacTinh;
        this.quyTrinh = quyTrinh;
    }

    public ChatlieuViewModel(String ma, String ten, String dacTinh, String quyTrinh) {
        this.ma = ma;
        this.ten = ten;
        this.dacTinh = dacTinh;
        this.quyTrinh = quyTrinh;
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

    public String getDacTinh() {
        return dacTinh;
    }

    public void setDacTinh(String dacTinh) {
        this.dacTinh = dacTinh;
    }

    public String getQuyTrinh() {
        return quyTrinh;
    }

    public void setQuyTrinh(String quyTrinh) {
        this.quyTrinh = quyTrinh;
    }

    public Object[] toRowData() {
        return new Object[]{this.ma, this.ten, this.dacTinh, this.quyTrinh};
    }
}
