/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HoaDon;
import java.util.List;
import repository.HoaDonRepository;
import service.HoaDonService;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author syduong
 */
public class HoaDonServiceImpl implements HoaDonService{
    private HoaDonRepository re = new HoaDonRepository();

    @Override
    public List<HoaDonViewModel> getAll() {
        return re.getAll();
    }

    @Override
    public String add(HoaDon hd) {
        boolean add = re.add(hd);
        if(add){
            return "thanh cong";
        }else{
            return "that bai";
        }
    }

    @Override
    public String update(HoaDon hd, String ma) {
        boolean update = re.update(hd, ma);
        if(update){
            return "thanh cong";
        }else{
            return "that bai";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = re.delete(ma);
        if(delete){
            return "thanh cong";
        }else{
            return "that bai";
        }
    }

    @Override
    public List<HoaDonViewModel> search(List<HoaDonViewModel> listTim, String tim) {
        return re.search(listTim, tim);
    }  

}
