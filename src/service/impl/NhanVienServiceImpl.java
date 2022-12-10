/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.NhanVienRepository;
import service.NhanVienService;
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

}
