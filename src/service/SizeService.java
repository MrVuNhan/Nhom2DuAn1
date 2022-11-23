/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;


import domainmodel.Size;
import java.util.List;
import viewmodel.SizeViewModel;

/**
 *
 * @author FPTSHOP
 */
public interface SizeService {

    List<SizeViewModel> getAll();

    String add(Size sz);

    String update(Size sz, String ma);

    String delele(String ma);
}
