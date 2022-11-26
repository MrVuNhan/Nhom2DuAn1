/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author syduong
 */
public interface HoaDonService {
    List<HoaDonViewModel> getAll();
    String add(HoaDonViewModel hdmv);
    String update(HoaDonViewModel hdvm,String ma);
    String delete(String ma);
}
