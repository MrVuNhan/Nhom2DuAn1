/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

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
    public String add(HoaDonViewModel hdmv) {
        boolean add = re.add(hdmv);
        if(hdmv.getMa().isEmpty()){
            return "khong dc de trong";
        }
        if(hdmv.getNgayTao().isEmpty()){
            return "khong dc de trong";
        }
        if(hdmv.getNgayThu().isEmpty()){
            return "khong dc de trong";
        }
        if(hdmv.getTinhTrang().isEmpty()){
            return "khong dc de trong";
        }
        if(hdmv.getTenNguoiNhan().isEmpty()){
            return "khong dc de trong";
        }
        if(hdmv.getDiaChi().isEmpty()){
            return "khong dc de trong";
        }
        if(add){
            return "thanh cong";
        }else{
            return "that bai";
        }
    }

    @Override
    public String update(HoaDonViewModel hdvm, String ma) {
        boolean update = re.update(hdvm, ma);
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
