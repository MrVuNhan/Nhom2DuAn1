/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.NhaCungCapviewmodel;

/**
 *
 * @author ADMIN
 */
public interface NhaCungCapService {
    List<NhaCungCapviewmodel>getAll();
    String add(NhaCungCapviewmodel nccvmd);
    String update(NhaCungCapviewmodel nccvmd, String Ma);
    String delete(String Ma);
}
