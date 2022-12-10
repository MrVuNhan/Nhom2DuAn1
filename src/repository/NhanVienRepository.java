/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;
import viewmodel.NhanVienViewModel;

/**
 *
 * @author lenovo
 */
public class NhanVienRepository {

    public List<NhanVienViewModel> getAll() {
        String query = "SELECT [Ma]\n"
                + "      ,[TenNV]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Email]\n"
                + "      ,[NgayCong]\n"
                + "      ,[Luong]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<NhanVienViewModel> listNV = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel();
                nv.setMa(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setGioitinh(rs.getBoolean(3));
                nv.setNgaySinh(rs.getString(4));
                nv.setSdt(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setEmail(rs.getString(7));
                nv.setNgayCong(rs.getInt(8));
                nv.setLuong(rs.getDouble(9));
                nv.setTrangThai(rs.getInt(10));
                listNV.add(nv);
//                spct.setId(rs.getString(1));
//                spct.setTenSP(rs.getString(2));
//                spct.setLoaiSP(rs.getString(3));
//                spct.setMauSac(rs.getString(4));
//                spct.setChatLieu(rs.getString(5));
//                spct.setSize(rs.getString(6));
//                spct.setNsx(rs.getString(7));
//                spct.setSlt(rs.getInt(8));
//                spct.setGiaNhap(rs.getDouble(9));
//                spct.setGiaBan(rs.getDouble(10));
//                spct.setMoTa(rs.getString(11));
//                spct.setTrangThai(rs.getInt(12));
//                listSPCT.add(spct);
            }
            return listNV;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
