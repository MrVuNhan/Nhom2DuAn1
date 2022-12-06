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
import ulities.DBConnection;
import viewmodel.NhanVien;

/**
 *
 * @author vungo
 */
public class loginRepo {

    public List<NhanVien> getALLNV() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenNV]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Email]\n"
                + "      ,[MatKhau]\n"
                + "      ,[NgayCong]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]";
        List<NhanVien> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString("Id"));
                nv.setMa(rs.getString("Ma"));
                nv.setTen(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setNgaysinh(rs.getString("NgaySinh"));
                nv.setSdt(rs.getString("SDT"));
                nv.setDiachi(rs.getString("DiaChi"));
                nv.setEmailString(rs.getString("Email"));
                nv.setMatkhau(rs.getString("MatKHau"));
                nv.setTrangThai(rs.getInt("TrangThai"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

   
    public static void main(String[] args) {
//        String maNv = "nv01";
//        NhanVien nv = new loginRepo().getOneIDNV(maNv);
//        System.out.println(nv);

    }
}
