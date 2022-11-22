/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.MauSacRep;
import service.MauSacService;
import viewmodel.MauSacViewmodel;

/**
 *
 * @author ADMIN
 */
public class MauSacimpl implements MauSacService{
    MauSacRep msr = new MauSacRep();
    @Override
    public List<MauSacViewmodel> getAll() {
       return msr.getAll();
    }

    @Override
    public String add(MauSacViewmodel msvmd) {
        if(msvmd.getMaMS().isEmpty()){
            return "khong duoc de trong";
        }
        if(msvmd.getTenMS().isEmpty()){
            return "khong duoc de trong";
        }
        boolean add = msr.add(msvmd);
        if(add){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }

    @Override
    public String update(MauSacViewmodel msvmd, String Ma) {
        boolean update = msr.update(msvmd, Ma);
        if(update){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }

    @Override
    public String delete(String Ma) {
        boolean delete = msr.delete(Ma);
        if(delete){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }
    
}
