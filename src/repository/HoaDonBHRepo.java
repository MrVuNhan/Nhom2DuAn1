/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

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
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id "
                + "group by dbo.HoaDon.Id ,dbo.HoaDon.Ma, dbo.NhanVien.TenNV, dbo.HoaDon.NgayTao, dbo.HoaDon.TrangThai\n"
                + "								 order by HoaDon.Ma desc ";
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

    public List<HoaDonBHViewModel> getTT(int trangThai) {
        String query = "SELECT dbo.HoaDon.Id ,dbo.HoaDon.Ma, dbo.NhanVien.TenNV, dbo.HoaDon.NgayTao, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id "
                + "where HoaDon.TrangThai = ? "
                + "group by dbo.HoaDon.Id ,dbo.HoaDon.Ma, dbo.NhanVien.TenNV, dbo.HoaDon.NgayTao, dbo.HoaDon.TrangThai\n"
                + "								 order by HoaDon.Ma desc ";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setObject(1, trangThai);
            ResultSet rs = ps.executeQuery();
            
            List<HoaDonBHViewModel> listBH = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String tenNV = rs.getString("tenNV");
                Date ngayTao = rs.getDate("ngayTao");

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
                + "  FROM [dbo].[HoaDon] where ma = ?  ";
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

    public String getOneIDKH(String ten) {
        String id = null;
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[KhachHang] where tenKH like ? ";
        NhanVien nv = new NhanVien();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public boolean updateTTHD(String idHD, String idKH,
            String ten, String dc, String sdt) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET \n"
                + "      [IdKH] = ?\n"
                + "      ,[NgayThu] = ?\n"
                + "      ,[TinhTrang] = ?\n"
                + "      ,[TenNguoiNhan] = ?\n"
                + "      ,[DiaChi] =? \n"
                + "      ,[SDT] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE Id=? ";
        int check = 0;
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(7, 1);
            ps.setObject(1, idKH);
            ps.setObject(2, date);
            ps.setObject(3, 1);
            ps.setObject(5, dc);
            ps.setObject(4, ten);
            ps.setObject(6, sdt);
            ps.setObject(8, idHD);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

//    public List<HoaDonBHViewModel> search(List<HoaDonBHViewModel> listTim, String tim){
//        List<HoaDonBHViewModel> list = new ArrayList<>();
//        String search ="select * from hoadon where Ma=?";
//        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(tim)){
//            ps.setObject(1, tim);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {                
//                String id = rs.getString("id");
//                String ma = rs.getString("ma");
//                string 
//                int  trangthai = rs.getInt("trangthai");
//                HoaDonBHViewModel hdvm = new HoaDonBHViewModell(ma, ma, tim, ngaytao, trangthai);
//                list.add(hdvm);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
    public static void main(String[] args) {
//        List<HoaDonBHViewModel> list = new HoaDonBHRepo().getAll();
//        list.forEach(l -> System.out.printf("%s \n", l.getId()));

        String ten = "My";
        String id = new HoaDonBHRepo().getOneIDKH(ten);
        System.out.println(id);

    }

}
