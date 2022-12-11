/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.SanPhamCT;
import java.util.List;
import repository.SanPhamCTRepo;
import service.SanPhamCTService;
import viewmodel.HoaDonCTBHViewModel;
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
        if(sp.getSlt() < 0){
            return "Số lượng phải là số dương";
        }
        if(sp.getGiaNhap()<0){
            return "Giá nhập phải là số dương";
        }
        if(sp.getGiaBan()<0){
            return "Giá bán phải là số dương";
        }
        boolean add = re.add(sp);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
    
    @Override
    public String deleta(String id) {
        boolean add = re.xoa(id);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
    
    @Override
    public String update(SanPhamCT sp, String ma) {
        boolean update = re.update(sp, ma);
        if (update) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
    
    @Override
    public SanPhamChiTietViewModel getOneSP(SanPhamChiTietViewModel sp, int soLuong, String idSP) {
        return re.getOneSPCT(sp, soLuong, idSP);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> search(List<SanPhamChiTietViewModel> listTim, String ma) {
        return re.search(listTim, ma);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> loclsp(String name) {
        return re.loclsp(name);
    }
    
    @Override
    public List<String> getalllsp() {
        return re.getalllsp();
    }
    
    @Override
    public List<SanPhamChiTietViewModel> loclsp1(String name) {
        return re.locloaiSP(name);
    }
    
    @Override
    public List<String> getalllsp1() {
        return re.getalllsp1();
    }
    
    @Override
    public List<SanPhamChiTietViewModel> locmau(String name) {
        return re.locMS(name);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> locchatlieu(String name) {
        return re.locchatlieu(name);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> locsize(String name) {
        return re.locsize(name);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> locnhacungcap(String name) {
        return re.locnhacungcap(name);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> searchTenSP(String ten) {
        return re.searchTenSP(ten);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> searchLoaiSP(String ten) {
        return re.searchLoaiSP(ten);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> searchCL(String ten) {
        return re.searchCL(ten);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> searchMau(String ten) {
        return re.searchMau(ten);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> searchSz(String ten) {
        return re.searchSz(ten);
    }
    
    @Override
    public List<SanPhamChiTietViewModel> searchNsx(String ten) {
        return re.searchNsx(ten);
    }
}
