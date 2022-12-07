/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhachHang;
import java.util.List;
import repository.KhachHangRepo;
import service.KhachHangService;
import viewmodel.KhachHangViewModel;

/**
 *
 * @author FPTSHOP
 */
public class KhachHangServiceimpl implements KhachHangService {

    private KhachHangRepo re = new KhachHangRepo();

    @Override
    public List<KhachHangViewModel> getAll() {
        return re.getAll();
    }

    @Override
    public String add(KhachHang kh) {
        boolean add = re.add(kh);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public List<KhachHangViewModel> search(List<KhachHangViewModel> listTim, String ma) {
        return re.search(listTim, ma);
    }

    @Override
    public String update(KhachHang kh, String ma) {
        boolean u = re.update(kh, ma);
        if (u) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String xoa(String ma) {

        boolean x = re.xoa(ma);
        if (x) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public KhachHangViewModel getOneKH(String idKH) {
        return re.getoneKH(idKH);
    }

}
