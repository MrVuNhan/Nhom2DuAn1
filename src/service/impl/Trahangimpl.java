/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.TraHangreponsitory;
import service.TraHangServisert;
import viewmodel.HoaDonModel;

/**
 *
 * @author vungo
 */
public class Trahangimpl implements TraHangServisert {

    private TraHangreponsitory rep = new TraHangreponsitory();

    @Override
    public List<HoaDonModel> getall() {
        return rep.getall();
    }

    @Override
    public List<HoaDonModel> getallbymahoadon(String mahd) {
        return rep.getallbymahoadon(mahd);
    }

    @Override
    public String add(HoaDonModel hd11) {
        
        boolean test = rep.add(hd11);
        if (test) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(HoaDonModel hd11, int soluong) {
        
        boolean testhu = rep.update(hd11, soluong);
        if (testhu) {
            return "UpDate thành công";
        } else {
            return "UpDate thất bại";
        }
    }
}
