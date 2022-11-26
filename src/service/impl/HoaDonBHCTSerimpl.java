/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.HoaDonCTBHRepo;
import service.HoaDonCTBHSer;
import viewmodel.HoaDonCTBHViewModel;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonBHCTSerimpl implements HoaDonCTBHSer {

    private HoaDonCTBHRepo re = new HoaDonCTBHRepo();

    @Override
    public List<HoaDonCTBHViewModel> getAll() {
        return re.getAll();
    }

}
