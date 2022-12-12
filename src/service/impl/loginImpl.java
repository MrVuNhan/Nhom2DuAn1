/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.loginRepo;
import service.loginService;
import viewmodel.NhanVien;
import viewmodel.QuanLyViewModel;

/**
 *
 * @author vungo
 */
public class loginImpl implements loginService {

    loginRepo login = new loginRepo();

    @Override
    public List<NhanVien> getALLNV() {
        return login.getALLNV();
    }

    @Override
    public List<QuanLyViewModel> getALLQL() {
        return login. getALLQL();
    }

    @Override
    public String updateNV(String newPass, String maNV) {
         boolean update = login.updatePassNV(newPass, maNV);
         if(update){
             return "Update thành công";
         }else{
             return "Update không thành công";
         }
    }

    

}
