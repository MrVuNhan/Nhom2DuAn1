/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import viewmodel.QuanLyViewModel;

/**
 *
 * @author Asus
 */
public interface UsersSeverces {

    QuanLyViewModel getOne(String user, String password);

    String upPass(QuanLyViewModel ql, String Ma);
}
