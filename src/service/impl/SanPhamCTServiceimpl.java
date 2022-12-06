/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.SanPhamCT;
import java.util.List;
import repository.SanPhamCTRepo;
import service.SanPhamCTService;
import viewmodel.SanPhamChiTietViewModel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamCTServiceimpl implements SanPhamCTService {

    private SanPhamCTRepo re = new SanPhamCTRepo();

    @Override
    public List<SanPhamChiTietViewModel> getAll() {
        return re.getAll();
    }

    @Override
    public String add(SanPhamCT sp) {
        boolean add = re.add(sp);
        if (add) {
            return ":))";
        } else {
            return ":((";
        }
    }

    @Override
    public String deleta(String id) {
        boolean add = re.xoa(id);
        if (add) {
            return ":))";
        } else {
            return ":((";
        }
    }

    @Override
    public String update(SanPhamCT sp, String ma) {
        boolean update = re.update(sp, ma);
        if (update) {
            return ":))";
        } else {
            return ":((";
        }
    }

    @Override
    public SanPhamChiTietViewModel getOneSP(SanPhamChiTietViewModel sp, int soLuong, String idSP) {
        return re.getOneSPCT(sp, soLuong, idSP);
    }

}
