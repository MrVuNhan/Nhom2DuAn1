/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.ThongKeRepository;
import service.ThongKeServices;
import viewmodel.ThongKeViewModle;

/**
 *
 * @author Asus
 */
public class ThongKeImpl implements ThongKeServices {

    ThongKeRepository tk = new ThongKeRepository();

    @Override
    public List<ThongKeViewModle> getAll() {
        return tk.getAll();
    }

    @Override
    public List<ThongKeViewModle> listNgay(String ma) {
        return tk.listNgay(ma);
    }

    @Override
    public List<ThongKeViewModle> listThang(String ma) {
        return tk.listThang(ma);
    }

    @Override
    public List<ThongKeViewModle> listNam(String ma) {
        return tk.listNam(ma);
    }

    @Override
    public List<ThongKeViewModle> listAll(String ma) {
        return tk.listAll(ma);
    }

    @Override
    public List<ThongKeViewModle> listNgayThang(String ngay, String thang) {
        return tk.listNgayThang(ngay, thang);
    }

    @Override
    public List<ThongKeViewModle> listNamThang(String thang, String nam) {
        return tk.listNamThang(thang, nam);
    }

    @Override
    public List<ThongKeViewModle> listNamNgay(String ngay, String nam) {
        return tk.listNamNgay(ngay, nam);
    }

}
