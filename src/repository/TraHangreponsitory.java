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
        String query = "SELECT dbo.HoaDon.Ma, dbo.KhachHang.TenKH, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThu, dbo.HoaDon.DiaChi, dbo.HoaDon.SDT, dbo.HoaDon.TinhTrang\n"
                + "FROM   dbo.HoaDon INNER JOIN\n"
                + "             dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonModel> listhoadon = new ArrayList();
            while (rs.next()) {
                HoaDonModel hd1 = new HoaDonModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                listhoadon.add(hd1);
            }
            return listhoadon;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonModel> getallbymahoadon(String mahd) {

        String query = "SELECT dbo.KhachHang.TenKH, dbo.HoaDon.Ma, dbo.ChiTietHD.SoLuong, dbo.ChiTietHD.DonGia, dbo.trahang.NgayTra\n"
                + "FROM   dbo.ChiTietHD INNER JOIN\n"
                + "             dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "             dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id INNER JOIN\n"
                + "             dbo.trahang ON dbo.HoaDon.Id = dbo.trahang.IdHD AND dbo.KhachHang.Id = dbo.trahang.IdKH where HoaDon.Ma = ?";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, mahd);
            ResultSet rs = ps.executeQuery();

            List<HoaDonModel> listhoadon = new ArrayList();
            while (rs.next()) {
                HoaDonModel hd1 = new HoaDonModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
                listhoadon.add(hd1);
            }
            return listhoadon;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonModel hd11) {
        String query = "";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd11.getTenkh());
            ps.setObject(2, hd11.getMahd());
            ps.setObject(3, hd11.getNgaytra());
            ps.setObject(4, hd11.getSoluong());
            ps.setObject(5, hd11.getDongia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonModel hd11, int soluong) {
        String query = "";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd11.getMahd());
            ps.setObject(1, hd11.getTenkh());
            ps.setObject(2, hd11.getMahd());
            ps.setObject(3, hd11.getNgaytra());
            ps.setObject(4, hd11.getSoluong());
            ps.setObject(5, hd11.getDongia());
            ps.setObject(6, soluong);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<HoaDonModel> test = new TraHangreponsitory().getallbymahoadon("HD02");
        for (HoaDonModel hoaD : test) {
            System.out.println(hoaD.getSoluong());
        }
    }
}
