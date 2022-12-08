/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.HoaDon;
import java.util.List;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author syduong
 */
public interface HoaDonService {

    List<HoaDonViewModel> getAll();

    String add(HoaDon hd);

    String update(HoaDon hd, String ma);

    String delete(String ma);

    List<HoaDonViewModel> search(List<HoaDonViewModel> listTim, String tim);
}
