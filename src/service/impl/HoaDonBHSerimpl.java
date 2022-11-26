/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HoaDonBH;
import java.util.List;
import repository.HoaDonBHRepo;
import service.HoaDonBHSer;
import viewmodel.HoaDonBHViewModel;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonBHSerimpl implements HoaDonBHSer {

    private HoaDonBHRepo re = new HoaDonBHRepo();

    @Override
    public List<HoaDonBHViewModel> getAll() {
        return re.getAll();
    }

    @Override
    public String add(HoaDonBH hd) {
        boolean add = re.add(hd);
        if (add) {
            return ":))";
        } else {
            return ":((";
        }
    }

}
