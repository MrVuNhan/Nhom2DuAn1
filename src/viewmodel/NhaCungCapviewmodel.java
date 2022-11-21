/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ADMIN
 */
public class NhaCungCapviewmodel {
    private String MaNhaCC;
    private String TenNhaCC;
    private String SDT;
    private String Email;

    public NhaCungCapviewmodel() {
    }

    public NhaCungCapviewmodel(String TenNhaCC, String SDT, String Email) {
        this.TenNhaCC = TenNhaCC;
        this.SDT = SDT;
        this.Email = Email;
    }

    public NhaCungCapviewmodel(String MaNhaCC, String TenNhaCC, String SDT, String Email) {
        this.MaNhaCC = MaNhaCC;
        this.TenNhaCC = TenNhaCC;
        this.SDT = SDT;
        this.Email = Email;
    }

    public String getMaNhaCC() {
        return MaNhaCC;
    }

    public void setMaNhaCC(String MaNhaCC) {
        this.MaNhaCC = MaNhaCC;
    }

    public String getTenNhaCC() {
        return TenNhaCC;
    }

    public void setTenNhaCC(String TenNhaCC) {
        this.TenNhaCC = TenNhaCC;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public Object[] todatarow(){
        return new Object[]{MaNhaCC,TenNhaCC,SDT,Email};
    }
}
