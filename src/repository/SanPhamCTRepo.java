/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.SanPhamCT;
import java.util.List;
import viewmodel.SanPhamChiTietViewModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;
import view.SanPhamChiTiet;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamCTRepo {

    public List<SanPhamChiTietViewModel> getAll() {
        String query = "SELECT dbo.ChiTietSP.Id, dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan, \n"
                + "                  dbo.ChiTietSP.MoTa, dbo.ChiTietSP.TrangThai\n"
                + "FROM     dbo.ChatLieu INNER JOIN\n"
                + "                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                  dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamChiTietViewModel> listSPCT = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTietViewModel spct = new SanPhamChiTietViewModel();
                spct.setId(rs.getString(1));
                spct.setTenSP(rs.getString(2));
                spct.setLoaiSP(rs.getString(3));
                spct.setMauSac(rs.getString(4));
                spct.setChatLieu(rs.getString(5));
                spct.setSize(rs.getString(6));
                spct.setNsx(rs.getString(7));
                spct.setSlt(rs.getInt(8));
                spct.setGiaNhap(rs.getDouble(9));
                spct.setGiaBan(rs.getDouble(10));
                spct.setMoTa(rs.getString(11));
                spct.setTrangThai(rs.getInt(12));
                listSPCT.add(spct);
            }
            return listSPCT;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(SanPhamCT sp) {
        String query = "insert into ChiTietSP(IdSP,IdLSP,IdMS,IdCL,IdSz,IdNcc,SoLuongTon,GiaNhap,GiaBan,MoTa,TrangThai)\n"
                + "select sp.Id,lsp.Id,ms.Id,cl.Id,sz.Id,ncc.Id,?,?,?,?,? From SanPham sp , LoaiSanPham lsp , MauSac ms , ChatLieu cl, Size sz , NhaCungCap ncc \n"
                + "where sp.TenSP = ? and lsp.TenLoai =? and ms.TenMau =? and cl.TenCL = ? and sz.TenSize =? and ncc.TenNcc =?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getSlt());
            ps.setObject(2, sp.getGiaNhap());
            ps.setObject(3, sp.getGiaBan());
            ps.setObject(4, sp.getMoTa());
            ps.setObject(5, sp.getTrangThai());
            ps.setObject(6, sp.getTenSP());
            ps.setObject(7, sp.getLoaiSP());
            ps.setObject(8, sp.getMauSac());
            ps.setObject(9, sp.getChatLieu());
            ps.setObject(10, sp.getSize());
            ps.setObject(11, sp.getNsx());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean xoa(String id) {
        String query = "DELETE FROM [dbo].[ChiTietSP]\n"
                + "      WHERE Id = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamCTRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
