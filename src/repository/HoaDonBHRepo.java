/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDonBH;
import java.util.List;
import viewmodel.HoaDonBHViewModel;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;
import viewmodel.HoaDonCTViewModel;
import viewmodel.NhanVien;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonBHRepo {
    
    public List<HoaDonBHViewModel> getAll() {
        String query = "SELECT dbo.HoaDon.Id ,dbo.HoaDon.Ma, dbo.NhanVien.TenNV, dbo.HoaDon.NgayTao, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id ";
//                + "where HoaDon.trangThai = 0 ";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonBHViewModel> listBH = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String tenNV = rs.getString("tenNV");
                Date ngayTao = rs.getDate("ngayTao");
                int trangThai = rs.getInt("trangThai");
                HoaDonBHViewModel hd = new HoaDonBHViewModel(id, ma, tenNV, ngayTao, trangThai);
                listBH.add(hd);
            }
            return listBH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<HoaDonBHViewModel> getAll1() {
        String query = "SELECT dbo.HoaDon.Id ,dbo.HoaDon.Ma, dbo.NhanVien.TenNV, dbo.HoaDon.NgayTao, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id "
                + "where HoaDon.trangThai = 0 ";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonBHViewModel> listBH = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String tenNV = rs.getString("tenNV");
                Date ngayTao = rs.getDate("ngayTao");
                int trangThai = rs.getInt("trangThai");
                HoaDonBHViewModel hd = new HoaDonBHViewModel(id, ma, tenNV, ngayTao, trangThai);
                listBH.add(hd);
            }
            return listBH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getOneIDNV(String maNV) {
        String id = null;
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[NhanVien] where ma = ? ";
        NhanVien nv = new NhanVien();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }
    
    public boolean add(String ma, String idNV) {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           (\n"
                + "            [Ma] \n"
                + "	      ,IdNV \n"
                + "           ,[NgayTao]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ps.setObject(2, idNV);
            ps.setObject(3, date);
            ps.setObject(4, 0);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
    
    public String getOneIDHD(String maHD) {
        String id = null;
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[HoaDon] where ma = ? ";
        NhanVien nv = new NhanVien();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }
    
    public boolean addCTHD(String idHD, String idCTSP, int soLuong, double DonGia) {
        String query = "INSERT INTO [dbo].[ChiTietHD]\n"
                + "           ("
                + "           [IdHD]\n"
                + "           ,[IdCTSP]\n"
                + "           ,[SoLuong]\n"
                + "           ,[DonGia])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
//        HoaDonCTViewModel hd = new HoaDonCTViewModel();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, idCTSP);
            ps.setObject(3, soLuong);
            ps.setObject(4, DonGia);
            check = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean updateSLCT(String idCTSP, int soLuong) {
        String query = "update ChiTietSP\n"
                + "set SoLuongTon = SoLuongTon - ? \n"
                + "where Id = ? ";
        int check = 0;
        HoaDonCTViewModel hd = new HoaDonCTViewModel();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            
            ps.setObject(2, idCTSP);
            ps.setObject(1, soLuong);
            check = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean updateTTHD(String idHD) {
        String query = "update hoadon \n"
                + "set TrangThai = ? \n"
                + "where Id = ?";
        int check = 0;
        HoaDonCTViewModel hd = new HoaDonCTViewModel();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            
            ps.setObject(1, 1);
            ps.setObject(2, idHD);
            check = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        List<HoaDonBHViewModel> list = new HoaDonBHRepo().getAll();
        list.forEach(l -> System.out.printf("%s \n", l.getId()));
        
    }
    
}
