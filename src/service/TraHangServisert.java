/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HoaDonModel;

/**
 *
 * @author vungo
 */
public interface TraHangServisert {
    List<HoaDonModel> getall();
    List<HoaDonModel> getallbymahoadon(String mahd);
    
}
