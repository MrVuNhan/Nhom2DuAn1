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
public class Trahangimpl implements TraHangServisert{
    private TraHangreponsitory rep = new TraHangreponsitory();    
    @Override
    public List<HoaDonModel> getall() {
        return  rep.getall();
    }
    
}
