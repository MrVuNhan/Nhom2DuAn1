/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ADMIN
 */
public class MauSacViewmodel {
    private String MaMS;
    private String TenMS;

    public MauSacViewmodel() {
    }

    public MauSacViewmodel(String TenMS) {
        this.TenMS = TenMS;
    }

    public MauSacViewmodel(String MaMS, String TenMS) {
        this.MaMS = MaMS;
        this.TenMS = TenMS;
    }

    public String getMaMS() {
        return MaMS;
    }

    public void setMaMS(String MaMS) {
        this.MaMS = MaMS;
    }

    public String getTenMS() {
        return TenMS;
    }

    public void setTenMS(String TenMS) {
        this.TenMS = TenMS;
    }
    public Object[] todatarow(){
        return new Object[]{MaMS,TenMS};
    }
}
