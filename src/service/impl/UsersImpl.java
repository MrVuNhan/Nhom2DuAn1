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

    @Override
    public QuanLyViewModel getOne(String user, String password) {
        return us.getOne(user, password);
    }

}
