/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.MauSacViewmodel;

/**
 *
 * @author ADMIN
 */
public interface MauSacService {
    List<MauSacViewmodel>getAll();
    String add(MauSacViewmodel msvmd);
    String update(MauSacViewmodel msvmd , String Ma);
    String delete(String Ma);
}
