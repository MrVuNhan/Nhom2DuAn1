/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.NhanVien;
import viewmodel.NhanVienViewModel;

/**
 *
 * @author lenovo
 */
public interface NhanVienService {

    List<NhanVienViewModel> getAll();

    List<NhanVienViewModel> Search(String timTen);

    List<NhanVienViewModel> SearchGT(boolean gioiTinh);

    String add(NhanVienViewModel nv);

    String update(NhanVienViewModel nv, String id);

    String delete(String ma);
}
