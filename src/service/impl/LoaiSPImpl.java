/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.LoaiSPRepo;
import service.LoaiSPService;
import viewmodel.LoaiSPViewmodel;

/**
 *
 * @author admin
 */
public class LoaiSPImpl implements LoaiSPService {

    LoaiSPRepo lsprepo = new LoaiSPRepo();

    @Override
    public List<LoaiSPViewmodel> getAll() {
        return lsprepo.getAll();
    }

    @Override
    public String add(LoaiSPViewmodel lspvmd) {
        if (lspvmd.getMaLoai().isEmpty()) {
            return "khong duoc de trong";
        }
        if (lspvmd.getTenLoai().isEmpty()) {
            return "khong duoc de trong";
        }
        if (lspvmd.getCongDung().isEmpty()) {
            return "khong duoc de trong";
        }
        if (lspvmd.getTenLoai().matches("[a-z A-Z]+") == false) {
            return "ten phai la chu";
        }

        boolean add = lsprepo.add(lspvmd);
        if (add) {
            return "thanh cong";
        } else {
            return "that bai";
        }

    }

    @Override
    public String update(LoaiSPViewmodel lspvmd, String Ma) {
        if (lspvmd.getTenLoai().isEmpty()) {
            return "khong duoc de trong";
        }
        if (lspvmd.getTenLoai().matches("[a-z A-Z]+") == false) {
            return "ten phai la chu";
        }
        if (lspvmd.getCongDung().isEmpty()) {
            return "khong duoc de trong ";
        }

        if (lspvmd.getMaLoai().isEmpty()) {
            return "khong duoc de trong ";
        }
        boolean update = lsprepo.update(lspvmd, Ma);
        if (update) {
            return "thanh cong";
        } else {
            return "that bai";
        }
    }

    @Override
    public String delete(String Ma) {
        boolean delete = lsprepo.delete(Ma);
        if (delete) {
            return "thanh cong";
        } else {
            return "that bai";
        }
    }

}
