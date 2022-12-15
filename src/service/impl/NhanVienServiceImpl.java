/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.NhanVienRepository;
import service.NhanVienService;
import viewmodel.NhanVien;
import viewmodel.NhanVienViewModel;

/**
 *
 * @author lenovo
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nvrp = new NhanVienRepository();

    @Override
    public List<NhanVienViewModel> getAll() {
        return nvrp.getAll();
    }

    @Override
    public String add(NhanVienViewModel nv) {
        boolean add = nvrp.add(nv);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String update(NhanVienViewModel nv, String id) {
        boolean update = nvrp.update(nv, id);
        if (update) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = nvrp.delete(ma);
        if (delete) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public List<NhanVienViewModel> Search(String timTen) {
        return nvrp.Search(timTen);
    }

    @Override
    public List<NhanVienViewModel> SearchGT(boolean gioiTinh) {
        return nvrp.SearchGT(gioiTinh);
    }

}
