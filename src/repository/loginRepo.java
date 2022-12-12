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
import viewmodel.QuanLyViewModel;

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

    public List<QuanLyViewModel> getALLQL() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenQL]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[SDT]\n"
                + "      ,[Email]\n"
                + "      ,[NgayVao]\n"
                + "      ,[NgayLamQuanLy]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[QuanLy]";
        List<QuanLyViewModel> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyViewModel nv = new QuanLyViewModel();
                nv.setId(rs.getString("Id"));
                nv.setMa(rs.getString("Ma"));
                nv.setTen(rs.getString("TenQL"));
                nv.setGioitinh(rs.getBoolean("GioiTinh"));
                nv.setNgayVao(rs.getString("NgayVao"));
                nv.setSdt(rs.getString("SDT"));
                nv.setNgayLamQuanLy(rs.getString("NgayLamQuanLy"));
                nv.setEmail(rs.getString("Email"));
                nv.setMatKhau(rs.getString("MatKHau"));
                nv.setTrangthai(rs.getInt("TrangThai"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean updatePassNV(String newPass, String maHV) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET \n"
                + "      [MatKhau] =? \n"
                + "      \n"
                + " WHERE Ma = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, newPass);
            ps.setObject(2, maHV);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        String maNv = "nv01";
//        NhanVien nv = new loginRepo().getOneIDNV(maNv);
//        System.out.println(nv);

    }
}
