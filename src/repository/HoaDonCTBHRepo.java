/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDonBH;
import domainmodel.HoaDonCTBH;
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
import viewmodel.HoaDonBHViewModel;
import viewmodel.HoaDonCTBHViewModel;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCTBHRepo {
    
    public List<HoaDonCTBHViewModel> getAll() {
        String query = "SELECT dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietHD.SoLuong, dbo.ChiTietSP.GiaBan\n"
                + "FROM     dbo.ChatLieu INNER JOIN\n"
                + "                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                  dbo.ChiTietHD ON dbo.ChiTietSP.Id = dbo.ChiTietHD.IdCTSP INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "                  dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonCTBHViewModel> listBH = new ArrayList<>();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenLSP = rs.getString("TenLoai");
                String tenMs = rs.getString("TenMau");
                String tenCL = rs.getString("TenCL");
                String tenSz = rs.getString("TenSize");
                String tenNsx = rs.getString("TenNcc");
                int sl = rs.getInt("SoLuong");
                Double donGia = rs.getDouble("GiaBan");
                HoaDonCTBHViewModel hd = new HoaDonCTBHViewModel(tenSP, tenLSP, tenMs, tenCL, tenSz, tenNsx, sl, donGia);
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
    
    public boolean add(HoaDonCTBH hd) {
        String query = "";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
    
}
