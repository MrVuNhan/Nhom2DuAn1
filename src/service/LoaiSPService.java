/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.LoaiSPViewmodel;

/**
 *
 * @author admin
 */
public interface LoaiSPService {

    List<LoaiSPViewmodel> getAll();

    String add(LoaiSPViewmodel lspvmd);

    String update(LoaiSPViewmodel lspvmd, String Ma);

    String delete(String Ma);
}
