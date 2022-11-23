/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.SanPhamH;
import java.util.List;
import repository.SanPhamRepo;
import service.SanPhamSer;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamSerimpl implements SanPhamSer {
    
    private SanPhamRepo rs = new SanPhamRepo();
    
    @Override
    public List<SanPhamViewModel> getAll() {
        return rs.getAll();
    }
    
    @Override
    public String add(SanPhamH sp) {
        boolean add = rs.add(sp);
        if (add) {
            return ":))";
        } else {
            return ":((";
        }
    }
    
    @Override
    public String update(SanPhamH sp, String ma) {
        boolean up = rs.update(sp, ma);
        if (up) {
            return ":))";
        } else {
            return ":((";
        }
    }
    
    @Override
    public String delele(String ma) {
        boolean xoa = rs.delete(ma);
        if (xoa) {
            return ":))";
        } else {
            return ":((";
        }
    }
    
}
