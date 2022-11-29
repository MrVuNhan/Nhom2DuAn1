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
import viewmodel.HoaDonModel;

/**
 *
 * @author vungo
 */
public class TraHangreponsitory {

    public List<HoaDonModel> getall() {
        String query = "SELECT dbo.HoaDon.Ma, dbo.NhanVien.TenNV, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThu, dbo.ChiTietHD.SoLuong, dbo.ChiTietHD.DonGia, dbo.HoaDon.TinhTrang, dbo.KhachHang.TenNV AS Expr1\n"
                + "FROM   dbo.ChiTietHD INNER JOIN\n"
                + "             dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "             dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id INNER JOIN\n"
                + "             dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id where ";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonModel> listhoadon = new ArrayList();
            while (rs.next()) {
                HoaDonModel hd1 = new HoaDonModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7));
                listhoadon.add(hd1);
            }
            return listhoadon;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonModel> getallbymahoadon(String mahd) {

        String query = "SELECT dbo.HoaDon.Ma, dbo.NhanVien.TenNV, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThu, dbo.ChiTietHD.SoLuong, dbo.ChiTietHD.DonGia, dbo.HoaDon.TinhTrang, dbo.KhachHang.TenNV AS Expr1\n"
                + "FROM   dbo.ChiTietHD INNER JOIN\n"
                + "             dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "             dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id INNER JOIN\n"
                + "             dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id where dbo.HoaDon.Ma = ?";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, mahd);
            ResultSet rs = ps.executeQuery();

            List<HoaDonModel> listhoadon = new ArrayList();
            while (rs.next()) {
                HoaDonModel hd1 = new HoaDonModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7));
                listhoadon.add(hd1);
            }
            return listhoadon;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
