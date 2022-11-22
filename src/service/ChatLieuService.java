/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.ChatlieuViewModel;

/**
 *
 * @author Asus
 */
public interface ChatLieuService {

    List<ChatlieuViewModel> getAll();
    
    ChatlieuViewModel getOne(String Ma);

    String add(ChatlieuViewModel chatLieu);

    String update(ChatlieuViewModel chatLieu, String Ma);

    String delete(String Ma);
}
