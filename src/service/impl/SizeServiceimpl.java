package service.impl;

import domainmodel.Size;
import java.util.List;
import repository.SizeRepo;
import service.SizeService;
import viewmodel.SizeViewModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FPTSHOP
 */
public class SizeServiceimpl implements SizeService {

    private SizeRepo re = new SizeRepo();

    @Override
    public List<SizeViewModel> getAll() {
        return re.getAll();
    }

    @Override
    public String add(Size sz) {
        boolean add = re.add(sz);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String update(Size sz, String ma) {
        boolean update= re.update(sz, ma);
        if (update){
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String delele(String ma) {
        boolean xoa = re.delete(ma);
        if (xoa) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

}
