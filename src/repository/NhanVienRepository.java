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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;
import viewmodel.NhanVien;
import viewmodel.NhanVienViewModel;

/**
 *
 * @author lenovo
 */
public class NhanVienRepository {

    public List<NhanVienViewModel> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenNV]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Email]\n"
                + "      ,[NgayVao]\n"
                + "      ,[MatKhau]\n"
                + "      ,[NgayCong]\n"
                + "      ,[Luong]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<NhanVienViewModel> listNV = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("TenNV");
                boolean GioiString = rs.getBoolean("GioiTinh");
                String NS = rs.getString("NgaySinh");
                String sdt = rs.getString("SDT");
                String diaChi = rs.getString("DiaChi");
                String email = rs.getString("Email");
                String mk = rs.getString("MatKhau");
                int ngayCong = rs.getInt("NgayCong");
                double luong = rs.getDouble("Luong");
                int tt = rs.getInt("TrangThai");
                NhanVienViewModel nv = new NhanVienViewModel(id, ma, ten, GioiString, NS, sdt, diaChi, email, mk, ngayCong, luong, tt);
                listNV.add(nv);
            }
            return listNV;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<NhanVienViewModel> Search(String timTen) {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenNV]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Email]\n"
                + "      ,[NgayVao]\n"
                + "      ,[MatKhau]\n"
                + "      ,[NgayCong]\n"
                + "      ,[Luong]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "  where TenNV = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, timTen);
            ResultSet rs = ps.executeQuery();
            List<NhanVienViewModel> listNV = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("TenNV");
                boolean GioiString = rs.getBoolean("GioiTinh");
                String NS = rs.getString("NgaySinh");
                String sdt = rs.getString("SDT");
                String diaChi = rs.getString("DiaChi");
                String email = rs.getString("Email");
                String mk = rs.getString("MatKhau");
                int ngayCong = rs.getInt("NgayCong");
                double luong = rs.getDouble("Luong");
                int tt = rs.getInt("TrangThai");
                NhanVienViewModel nv = new NhanVienViewModel(id, ma, ten, GioiString, NS, sdt, diaChi, email, mk, ngayCong, luong, tt);
                listNV.add(nv);
            }
            return listNV;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<NhanVienViewModel> SearchGT(boolean gioiTinh) {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenNV]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Email]\n"
                + "      ,[NgayVao]\n"
                + "      ,[MatKhau]\n"
                + "      ,[NgayCong]\n"
                + "      ,[Luong]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "  where GioiTinh = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gioiTinh);
            ResultSet rs = ps.executeQuery();
            List<NhanVienViewModel> listNV = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("TenNV");
                boolean GioiString = rs.getBoolean("GioiTinh");
                String NS = rs.getString("NgaySinh");
                String sdt = rs.getString("SDT");
                String diaChi = rs.getString("DiaChi");
                String email = rs.getString("Email");
                String mk = rs.getString("MatKhau");
                int ngayCong = rs.getInt("NgayCong");
                double luong = rs.getDouble("Luong");
                int tt = rs.getInt("TrangThai");
                NhanVienViewModel nv = new NhanVienViewModel(id, ma, ten, GioiString, NS, sdt, diaChi, email, mk, ngayCong, luong, tt);
                listNV.add(nv);
            }
            return listNV;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean add(NhanVienViewModel nv) {
        String query = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([Ma]\n"
                + "           ,[TenNV]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[SDT]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Email]\n"
                + "           ,[MatKhau]\n"
                + "           ,[NgayCong]\n"
                + "           ,[Luong]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.isGioitinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getMk());
            ps.setObject(9, nv.getNgayCong());
            ps.setObject(10, nv.getLuong());
            ps.setObject(11, nv.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean update(NhanVienViewModel nv, String id) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[TenNV] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[MatKhau] = ?\n"
                + "      ,[NgayCong] = ?\n"
                + "      ,[Luong] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.isGioitinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getMk());
            ps.setObject(9, nv.getNgayCong());
            ps.setObject(10, nv.getLuong());
            ps.setObject(11, nv.getTrangThai());
            ps.setObject(12, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[NhanVien]\n"
                + "      WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
