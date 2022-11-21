/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.NhaCungCapRepository;
import service.NhaCungCapService;
import viewmodel.NhaCungCapviewmodel;

/**
 *
 * @author ADMIN
 */
public class NhaCungCapIMPL implements NhaCungCapService{
    NhaCungCapRepository nccrep = new NhaCungCapRepository();
    @Override
    public List<NhaCungCapviewmodel> getAll() {
       return nccrep.getAll();
    }

    @Override
    public String add(NhaCungCapviewmodel nccvmd) {
//        if(nccvmd.getMaNhaCC().isEmpty()){
//            return "khong duoc de trong";
//        }
        if(nccvmd.getTenNhaCC().isEmpty()){
            return "khong duoc de trong";
        }
        if(nccvmd.getTenNhaCC().matches("[a-z A-Z]+")==false){
            return "ten phai la chu";
        }
        if(nccvmd.getSDT().isEmpty()){
            return "khong duoc de trong SDT";
        }
        if(nccvmd.getSDT().matches("\\d+")==false){
            return "SDT phai la so";
        }
        if(nccvmd.getEmail().isEmpty()){
            return "khong duoc de trong email";
        }
        boolean add = nccrep.add(nccvmd);
        if(add){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }

    @Override
    public String update(NhaCungCapviewmodel nccvmd, String Ma) {
//       if(nccvmd.getMaNhaCC().isEmpty()){
//            return "khong duoc de trong";
//        }
        if(nccvmd.getTenNhaCC().isEmpty()){
            return "khong duoc de trong";
        }
        if(nccvmd.getTenNhaCC().matches("[a-z A-Z]+")==false){
            return "ten phai la chu";
        }
        if(nccvmd.getSDT().isEmpty()){
            return "khong duoc de trong SDT";
        }
        if(nccvmd.getSDT().matches("\\d+")==false){
            return "SDT phai la so";
        }
        if(nccvmd.getEmail().isEmpty()){
            return "khong duoc de trong email";
        }
        boolean update = nccrep.update(nccvmd, Ma);
        if(update){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }

    @Override
    public String delete(String Ma) {
       boolean delete = nccrep.delete(Ma);
        if(delete){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }
    
    
}
