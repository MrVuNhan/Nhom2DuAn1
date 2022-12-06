/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDon;
import domainmodel.HoaDonBH;
import domainmodel.SanPhamCT;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ulities.DBConnection;
import viewmodel.ChiTietSanPhamTK;
import viewmodel.HoaDonTK;
import viewmodel.NhanVien;
import viewmodel.SanPhamViewModel;
import viewmodel.ThongKeViewModle;

public class ThongKeRepository {

    public List<ThongKeViewModle> getAll() {
        String query = "select NhanVien.Ma,NhanVien.TenNV,SanPham.Ma,SanPham.TenSP,HoaDon.NgayTao,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,SoLuong\n"
                + "                from NhanVien join HoaDon on NhanVien.Id = HoaDon.IdNV\n"
                + "                		 join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD\n"
                + "                		 join ChiTietSP on ChiTietHD.IdCTSP = ChiTietSP.Id\n"
                + "                		 join SanPham on ChiTietSP.IdSP = SanPham.Id;";
        List<ThongKeViewModle> list = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                HoaDonTK tk = new HoaDonTK(nv, rs.getString(3));
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(4), rs.getString(5));
                ChiTietSanPhamTK ctsp = new ChiTietSanPhamTK(sp, rs.getDouble(6), rs.getDouble(7));
                ThongKeViewModle sss = new ThongKeViewModle(tk, ctsp, rs.getInt(8));
                list.add(sss);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<ThongKeViewModle> listNgay(String ma) {
        String query = "select NhanVien.Ma,NhanVien.TenNV,SanPham.Ma,SanPham.TenSP,HoaDon.NgayTao,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,SoLuong\n"
                + "                from NhanVien join HoaDon on NhanVien.Id = HoaDon.IdNV\n"
                + "                		 join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD\n"
                + "                		 join ChiTietSP on ChiTietHD.IdCTSP = ChiTietSP.Id\n"
                + "                		 join SanPham on ChiTietSP.IdSP = SanPham.Id\n"
                + "				where Day(HoaDon.NgayTao)= ?;";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ThongKeViewModle> list = new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                HoaDonTK tk = new HoaDonTK(nv, rs.getString(3));
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(4), rs.getString(5));
                ChiTietSanPhamTK ctsp = new ChiTietSanPhamTK(sp, rs.getDouble(6), rs.getDouble(7));
                ThongKeViewModle sss = new ThongKeViewModle(tk, ctsp, rs.getInt(8));
                list.add(sss);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeViewModle> listThang(String ma) {
        String query = "select NhanVien.Ma,NhanVien.TenNV,SanPham.Ma,SanPham.TenSP,HoaDon.NgayTao,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,SoLuong\n"
                + "                from NhanVien join HoaDon on NhanVien.Id = HoaDon.IdNV\n"
                + "                		  join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD\n"
                + "                		 join ChiTietSP on ChiTietHD.IdCTSP = ChiTietSP.Id\n"
                + "                		 join SanPham on ChiTietSP.IdSP = SanPham.Id\n"
                + "				where Month(HoaDon.NgayTao)= ?;";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ThongKeViewModle> list = new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                HoaDonTK tk = new HoaDonTK(nv, rs.getString(3));
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(4), rs.getString(5));
                ChiTietSanPhamTK ctsp = new ChiTietSanPhamTK(sp, rs.getDouble(6), rs.getDouble(7));
                ThongKeViewModle sss = new ThongKeViewModle(tk, ctsp, rs.getInt(8));
                list.add(sss);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeViewModle> listNam(String ma) {
        String query = "select NhanVien.Ma,NhanVien.TenNV,SanPham.Ma,SanPham.TenSP,HoaDon.NgayTao,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,SoLuong\n"
                + "                from NhanVien join HoaDon on NhanVien.Id = HoaDon.IdNV\n"
                + "                		 join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD\n"
                + "                		 join ChiTietSP on ChiTietHD.IdCTSP = ChiTietSP.Id\n"
                + "                		 join SanPham on ChiTietSP.IdSP = SanPham.Id\n"
                + "				where Year(HoaDon.NgayTao)=?;";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ThongKeViewModle> list = new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                HoaDonTK tk = new HoaDonTK(nv, rs.getString(3));
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(4), rs.getString(5));
                ChiTietSanPhamTK ctsp = new ChiTietSanPhamTK(sp, rs.getDouble(6), rs.getDouble(7));
                ThongKeViewModle sss = new ThongKeViewModle(tk, ctsp, rs.getInt(8));
                list.add(sss);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeViewModle> listAll(String ma) {
        String query = "select NhanVien.Ma,NhanVien.TenNV,SanPham.Ma,SanPham.TenSP,HoaDon.NgayTao,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,SoLuong\n" +
"                from NhanVien join HoaDon on NhanVien.Id = HoaDon.IdNV\n" +
"                			 join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD\n" +
"                		 join ChiTietSP on ChiTietHD.IdCTSP = ChiTietSP.Id\n" +
"                		 join SanPham on ChiTietSP.IdSP = SanPham.Id\n" +
"				where HoaDon.NgayTao = ?;";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ThongKeViewModle> list = new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                HoaDonTK tk = new HoaDonTK(nv, rs.getString(3));
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(4), rs.getString(5));
                ChiTietSanPhamTK ctsp = new ChiTietSanPhamTK(sp, rs.getDouble(6), rs.getDouble(7));
                ThongKeViewModle sss = new ThongKeViewModle(tk, ctsp, rs.getInt(8));
                list.add(sss);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     public List<ThongKeViewModle> listNgayThang(String ngay, String thang) {
        String query = "select NhanVien.Ma,NhanVien.TenNV,SanPham.Ma,SanPham.TenSP,HoaDon.NgayTao,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,SoLuong\n" +
"                from NhanVien join HoaDon on NhanVien.Id = HoaDon.IdNV\n" +
"                			 join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD\n" +
"                		 join ChiTietSP on ChiTietHD.IdCTSP = ChiTietSP.Id\n" +
"                		 join SanPham on ChiTietSP.IdSP = SanPham.Id\n" +
"				where Day(HoaDon.NgayTao)= ? and Month(HoaDon.NgayTao)= ?;";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ThongKeViewModle> list = new ArrayList<>();
            ps.setObject(1, ngay);
            ps.setObject(2, thang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                HoaDonTK tk = new HoaDonTK(nv, rs.getString(3));
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(4), rs.getString(5));
                ChiTietSanPhamTK ctsp = new ChiTietSanPhamTK(sp, rs.getDouble(6), rs.getDouble(7));
                ThongKeViewModle sss = new ThongKeViewModle(tk, ctsp, rs.getInt(8));
                list.add(sss);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
      public List<ThongKeViewModle> listNamThang(String thang , String nam) {
        String query = "select NhanVien.Ma,NhanVien.TenNV,SanPham.Ma,SanPham.TenSP,HoaDon.NgayTao,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,SoLuong\n" +
"                from NhanVien join HoaDon on NhanVien.Id = HoaDon.IdNV\n" +
"                			 join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD\n" +
"                		 join ChiTietSP on ChiTietHD.IdCTSP = ChiTietSP.Id\n" +
"                		 join SanPham on ChiTietSP.IdSP = SanPham.Id\n" +
"				where Month(HoaDon.NgayTao)= ? and Year(HoaDon.NgayTao)=? ;";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ThongKeViewModle> list = new ArrayList<>();
            ps.setObject(1, thang);
            ps.setObject(2, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                HoaDonTK tk = new HoaDonTK(nv, rs.getString(3));
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(4), rs.getString(5));
                ChiTietSanPhamTK ctsp = new ChiTietSanPhamTK(sp, rs.getDouble(6), rs.getDouble(7));
                ThongKeViewModle sss = new ThongKeViewModle(tk, ctsp, rs.getInt(8));
                list.add(sss);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
       public List<ThongKeViewModle> listNamNgay(String ngay, String nam) {
        String query = "select NhanVien.Ma,NhanVien.TenNV,SanPham.Ma,SanPham.TenSP,HoaDon.NgayTao,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,SoLuong\n" +
"                from NhanVien join HoaDon on NhanVien.Id = HoaDon.IdNV\n" +
"                			 join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD\n" +
"                		 join ChiTietSP on ChiTietHD.IdCTSP = ChiTietSP.Id\n" +
"                		 join SanPham on ChiTietSP.IdSP = SanPham.Id\n" +
"				where Day(HoaDon.NgayTao)= ? and Year(HoaDon.NgayTao)=?;";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ThongKeViewModle> list = new ArrayList<>();
            ps.setObject(1, ngay);
            ps.setObject(2, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                HoaDonTK tk = new HoaDonTK(nv, rs.getString(3));
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(4), rs.getString(5));
                ChiTietSanPhamTK ctsp = new ChiTietSanPhamTK(sp, rs.getDouble(6), rs.getDouble(7));
                ThongKeViewModle sss = new ThongKeViewModle(tk, ctsp, rs.getInt(8));
                list.add(sss);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
