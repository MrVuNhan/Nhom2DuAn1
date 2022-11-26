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

/**
 *
 * @author FPTSHOP
 */
public class HoaDonBHRepo {

    public List<HoaDonBHViewModel> getAll() {
        String query = "SELECT dbo.HoaDon.Ma, dbo.NhanVien.TenNV, dbo.HoaDon.NgayTao, dbo.KhachHang.TenKH, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonBHViewModel> listBH = new ArrayList<>();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                String tenNV = rs.getString("tenNV");
                Date ngayTao = rs.getDate("ngayTao");
                int trangThai = rs.getInt("trangThai");
                String tenKH = rs.getString("tenKH");
                HoaDonBHViewModel hd = new HoaDonBHViewModel(ma, tenNV, ngayTao, trangThai, tenKH);
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

    public boolean add(HoaDonBH hd) {
        String query = "INSERT INTO HoaDon(Ma,NgayTao,TrangThai,IdNV,IdKH)\n"
                + "select ?,?,?,nv.Id, kh.Id FROM  NhanVien nv ,KhachHang kh\n"
                + "where nv.TenNV = ? and kh.TenKH = ? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hd.getMa());
            ps.setObject(2, hd.getNgayTao());
            ps.setObject(3, hd.getTrangThai());
            ps.setObject(4, hd.getTenNV());
            ps.setObject(5, hd.getTenKH());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
