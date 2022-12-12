/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import repository.UsersRepository;
import service.UsersSeverces;
import viewmodel.QuanLyViewModel;

/**
 *
 * @author Asus
 */
public class UsersImpl implements UsersSeverces {

    UsersRepository us = new UsersRepository();

//    @Override
//    public QuanLyViewModel getOne(String user, String password) {
//        return us.getOne(user, password);
//    }
//
//    @Override
//    public String upPass(QuanLyViewModel ql, String Ma) {
//        boolean A = us.upPass(ql, Ma);
//        if (A) {
//            return "Đỏi mật khẩu thành công";
//        } else {
//            return "Đổi mật khẩu thất bại";
//        }
//    }

    @Override
    public QuanLyViewModel getOne(String user, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String upPass(QuanLyViewModel ql, String Ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
