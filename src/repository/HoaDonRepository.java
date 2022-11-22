/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author syduong
 */
public class HoaDonRepository {
    public List<HoaDonViewModel> getAll(){
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
                    String select = "select hd.Ma,hd.tennguoinhan,hd.ngaytao,hd.ngaythu,hd.trangthai,hdct.soluong,hdct.dongia,sp.tensp,nv.tennv from \n"
                    +"NhanVien nv join HoaDon hd on hd.IDNV = nv.ID join ChiTietHD hdct on hd.id = hdct.idhd \n"
                    +"join ChiTietSP ctsp on hdct.idCTSP = ctsp.id join sanpham sp on ctsp.idSP=sp.id";
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                String ma = rs.getString("ma");
                String tensanpham = rs.getString("tensanpham");
                String tennguoinhan = rs.getString("tennguoinhan");
                int soluong = rs.getInt("soluong");
                double dongia = rs.getDouble("dongia");
                String ngaytao = rs.getString("ngaytao");
                String ngaythu = rs.getString("ngaythu");
                String trangthai = rs.getString("trangthai");
                HoaDonViewModel hdvm = new HoaDonViewModel(ma, tensanpham, tennguoinhan, soluong, dongia, ngaytao, ngaythu, trangthai);
                list.add(hdvm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            return list;
    }
    
    
    
}
