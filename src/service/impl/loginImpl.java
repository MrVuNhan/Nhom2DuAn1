/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.loginRepo;
import service.loginService;
import viewmodel.NhanVien;

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

    

}
