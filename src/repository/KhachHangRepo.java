/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.KhachHang;
import java.util.List;
import viewmodel.KhachHangViewModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;

/**
 *
 * @author FPTSHOP
 */
public class KhachHangRepo {

    public List<KhachHangViewModel> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenKH]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[DiaChi]\n"
                + "  FROM [dbo].[KhachHang]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHangViewModel> listKH = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("TenKH");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String NS = rs.getString("NgaySinh");
                String sdt = rs.getString("SDT");
                String diaChi = rs.getString("DiaChi");
                KhachHangViewModel kh = new KhachHangViewModel(id, ma, ten, gioiTinh, NS, sdt, diaChi);
                listKH.add(kh);
            }
            return listKH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<KhachHangViewModel> search(List<KhachHangViewModel> listTim, String ma) {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenKH]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[DiaChi]\n"
                + "  FROM [dbo].[KhachHang]"
                + "Where Ma = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            List<KhachHangViewModel> listSe = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma1 = rs.getString("Ma");
                String ten = rs.getString("TenKH");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String NS = rs.getString("NgaySinh");
                String sdt = rs.getString("SDT");
                String diaChi = rs.getString("DiaChi");
                KhachHangViewModel kh = new KhachHangViewModel(id, ma, ten, gioiTinh, NS, sdt, diaChi);
                listSe.add(kh);
            }
            return listSe;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean add(KhachHang kh) {
        String query = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([Ma]\n"
                + "           ,[TenKH]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[SDT]\n"
                + "           ,[DiaChi]\n"
                + "           )\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.isGioiTinh());
            ps.setObject(4, kh.getNgaySinh());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getDiaChi());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean update(KhachHang kh, String ma) {
        String query = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[TenKH] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + " WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.isGioiTinh());
            ps.setObject(4, kh.getNgaySinh());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getDiaChi());
            ps.setObject(7, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean xoa(String ma) {
        String query = "DELETE FROM [dbo].[KhachHang]\n"
                + "      WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
