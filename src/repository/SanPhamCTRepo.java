/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.SanPhamCT;
import java.awt.image.SampleModel;
import java.util.List;
import viewmodel.SanPhamChiTietViewModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;
import view.SanPhamChiTiet;
import viewmodel.HoaDonCTBHViewModel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamCTRepo {

    public List<SanPhamChiTietViewModel> getAll() {
        String query = "SELECT dbo.ChiTietSP.Id, dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan, \n"
                + "                                  dbo.ChiTietSP.MoTa, dbo.ChiTietSP.TrangThai\n"
                + "                FROM     dbo.ChatLieu INNER JOIN\n"
                + "                                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                                 dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                                 dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id\n"
                + "Order by ChiTietSP.IdSP asc";
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
        } catch (Exception ex) {
            Logger.getLogger(SanPhamCTRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<SanPhamChiTietViewModel> search(List<SanPhamChiTietViewModel> listTim, String id) {
        String query = "SELECT dbo.ChiTietSP.Id, dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan, \n"
                + "                                                  dbo.ChiTietSP.MoTa, dbo.ChiTietSP.TrangThai\n"
                + "                               FROM     dbo.ChatLieu INNER JOIN\n"
                + "                                                 dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                                                 dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                                                 dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                                                 dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                                                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                                                 dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id\n"
                + "												 where dbo.ChiTietSP.Id = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<SanPhamChiTietViewModel> listSe = new ArrayList<>();
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
                listSe.add(spct);
            }
            return listSe;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamCTRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public SanPhamChiTietViewModel getOneSPCT(SanPhamChiTietViewModel sp, int SoLuongMua, String idSP) {
        String query = "select SanPham.TenSP,LoaiSanPham.TenLoai,MauSac.TenMau,ChatLieu.TenCL,\n"
                + "			 size.TenSize ,NhaCungCap.TenNcc,ChiTietSP.SoLuongTon,ChiTietSP.GiaBan\n"
                + "			 from SanPham\n"
                + "			 join ChiTietSP on SanPham.id = ChiTietSP.IdSP\n"
                + "			 join NhaCungCap on ChiTietSP.IdNcc = NhaCungCap.Id\n"
                + "			 join ChatLieu on ChiTietSP.IdCL = ChatLieu.Id\n"
                + "			 join Size on ChiTietSP.IdSz = Size.Id\n"
                + "			 join MauSac on ChiTietSP.IdMS = MauSac.Id\n"
                + "			 join LoaiSanPham on ChiTietSP.IdLSP = LoaiSanPham.Id\n"
                + "\n"
                + "			 where ChiTietSP.IdSP = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.setId(idSP);
                sp.setTenSP(rs.getString("TenSP"));
                sp.setLoaiSP(rs.getString("TenLoai"));
                sp.setMauSac(rs.getString("TenMau"));
                sp.setChatLieu(rs.getString("TenCL"));
                sp.setSize(rs.getString("TenSize"));
                sp.setNsx(rs.getString("TenNCC"));
                sp.setSlt(SoLuongMua);
                sp.setGiaBan(rs.getDouble("GiaBan"));

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamCTRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
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
        } catch (Exception ex) {
            Logger.getLogger(SanPhamCTRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean update(SanPhamCT sp, String ma) {
        String query = "UPDATE [dbo].[ChiTietSP]\n"
                + "   SET [IdSP] = (Select sp.id from SanPham sp where sp.TenSP =?)\n"
                + "      ,[IdLSP] = (Select lsp.id from LoaiSanPham lsp where lsp.TenLoai =?)\n"
                + "      ,[IdMS] = (Select ms.id from MauSac ms where ms.TenMau =?)\n"
                + "      ,[IdCL] = (Select cl.id from ChatLieu cl where cl.TenCL =?)\n"
                + "      ,[IdSz] = (Select sz.id from Size sz where sz.TenSize =?)\n"
                + "      ,[IdNcc] = (Select ncc.id from NhaCungCap ncc where ncc.TenNcc =?)\n"
                + "      ,[SoLuongTon] = ?\n"
                + "      ,[GiaNhap] = ?\n"
                + "      ,[GiaBan] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE Id like ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, sp.getTenSP());
            ps.setObject(2, sp.getLoaiSP());
            ps.setObject(3, sp.getMauSac());
            ps.setObject(4, sp.getChatLieu());
            ps.setObject(5, sp.getSize());
            ps.setObject(6, sp.getNsx());
            ps.setObject(7, sp.getSlt());
            ps.setObject(8, sp.getGiaNhap());
            ps.setObject(9, sp.getGiaBan());
            ps.setObject(10, sp.getMoTa());
            ps.setObject(11, sp.getTrangThai());
            ps.setObject(12, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamCTRepo.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<SanPhamChiTietViewModel> loclsp(String name) {
        String query = "SELECT dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietHD.SoLuong, dbo.ChiTietSP.GiaBan\n"
                + "FROM     dbo.ChatLieu INNER JOIN\n"
                + "                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                  dbo.ChiTietHD ON dbo.ChiTietSP.Id = dbo.ChiTietHD.IdCTSP INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "                  dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id where TenSP = ?";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPhamChiTietViewModel> listBH = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenLSP = rs.getString("TenLoai");
                String tenMs = rs.getString("TenMau");
                String tenCL = rs.getString("TenCL");
                String tenSz = rs.getString("TenSize");
                String tenNsx = rs.getString("TenNcc");
                int sl = rs.getInt("SoLuong");
                Double donGia = rs.getDouble("GiaBan");
                SanPhamChiTietViewModel hd = new SanPhamChiTietViewModel(tenSP, tenLSP, tenMs, tenCL, tenSz, tenNsx, sl, donGia);
                listBH.add(hd);
            }
            return listBH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonCTBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<SanPhamChiTietViewModel> locloaiSP(String name) {
        String query = "SELECT dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietHD.SoLuong, dbo.ChiTietSP.GiaBan\n"
                + "FROM     dbo.ChatLieu INNER JOIN\n"
                + "                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                  dbo.ChiTietHD ON dbo.ChiTietSP.Id = dbo.ChiTietHD.IdCTSP INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "                  dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id where LoaiSanPham.TenLoai = ? ";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPhamChiTietViewModel> listBH = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenLSP = rs.getString("TenLoai");
                String tenMs = rs.getString("TenMau");
                String tenCL = rs.getString("TenCL");
                String tenSz = rs.getString("TenSize");
                String tenNsx = rs.getString("TenNcc");
                int sl = rs.getInt("SoLuong");
                Double donGia = rs.getDouble("GiaBan");
                SanPhamChiTietViewModel hd = new SanPhamChiTietViewModel(tenSP, tenLSP, tenMs, tenCL, tenSz, tenNsx, sl, donGia);
                listBH.add(hd);
            }
            return listBH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonCTBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<SanPhamChiTietViewModel> locMS(String name) {
        String query = "SELECT dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietHD.SoLuong, dbo.ChiTietSP.GiaBan\n"
                + "FROM     dbo.ChatLieu INNER JOIN\n"
                + "                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                  dbo.ChiTietHD ON dbo.ChiTietSP.Id = dbo.ChiTietHD.IdCTSP INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "                  dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id where mausac.TenMau = ? ";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPhamChiTietViewModel> listBH = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenLSP = rs.getString("TenLoai");
                String tenMs = rs.getString("TenMau");
                String tenCL = rs.getString("TenCL");
                String tenSz = rs.getString("TenSize");
                String tenNsx = rs.getString("TenNcc");
                int sl = rs.getInt("SoLuong");
                Double donGia = rs.getDouble("GiaBan");
                SanPhamChiTietViewModel hd = new SanPhamChiTietViewModel(tenSP, tenLSP, tenMs, tenCL, tenSz, tenNsx, sl, donGia);
                listBH.add(hd);
            }
            return listBH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonCTBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public List<SanPhamChiTietViewModel> locchatlieu(String name) {
        String query = "SELECT dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietHD.SoLuong, dbo.ChiTietSP.GiaBan\n"
                + "FROM     dbo.ChatLieu INNER JOIN\n"
                + "                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                  dbo.ChiTietHD ON dbo.ChiTietSP.Id = dbo.ChiTietHD.IdCTSP INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "                  dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id where chatlieu.tenCL = ? ";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPhamChiTietViewModel> listBH = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenLSP = rs.getString("TenLoai");
                String tenMs = rs.getString("TenMau");
                String tenCL = rs.getString("TenCL");
                String tenSz = rs.getString("TenSize");
                String tenNsx = rs.getString("TenNcc");
                int sl = rs.getInt("SoLuong");
                Double donGia = rs.getDouble("GiaBan");
                SanPhamChiTietViewModel hd = new SanPhamChiTietViewModel(tenSP, tenLSP, tenMs, tenCL, tenSz, tenNsx, sl, donGia);
                listBH.add(hd);
            }
            return listBH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonCTBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public List<SanPhamChiTietViewModel> locsize(String name) {
        String query = "SELECT dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietHD.SoLuong, dbo.ChiTietSP.GiaBan\n"
                + "FROM     dbo.ChatLieu INNER JOIN\n"
                + "                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                  dbo.ChiTietHD ON dbo.ChiTietSP.Id = dbo.ChiTietHD.IdCTSP INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "                  dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id where size.tenSize = ?  ";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPhamChiTietViewModel> listBH = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenLSP = rs.getString("TenLoai");
                String tenMs = rs.getString("TenMau");
                String tenCL = rs.getString("TenCL");
                String tenSz = rs.getString("TenSize");
                String tenNsx = rs.getString("TenNcc");
                int sl = rs.getInt("SoLuong");
                Double donGia = rs.getDouble("GiaBan");
                SanPhamChiTietViewModel hd = new SanPhamChiTietViewModel(tenSP, tenLSP, tenMs, tenCL, tenSz, tenNsx, sl, donGia);
                listBH.add(hd);
            }
            return listBH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonCTBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       public List<SanPhamChiTietViewModel> locnhacungcap(String name) {
        String query = "SELECT dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoai, dbo.MauSac.TenMau, dbo.ChatLieu.TenCL, dbo.Size.TenSize, dbo.NhaCungCap.TenNcc, dbo.ChiTietHD.SoLuong, dbo.ChiTietSP.GiaBan\n"
                + "FROM     dbo.ChatLieu INNER JOIN\n"
                + "                  dbo.ChiTietSP ON dbo.ChatLieu.Id = dbo.ChiTietSP.IdCL INNER JOIN\n"
                + "                  dbo.ChiTietHD ON dbo.ChiTietSP.Id = dbo.ChiTietHD.IdCTSP INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.ChiTietHD.IdHD = dbo.HoaDon.Id INNER JOIN\n"
                + "                  dbo.LoaiSanPham ON dbo.ChiTietSP.IdLSP = dbo.LoaiSanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMS = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NhaCungCap ON dbo.ChiTietSP.IdNcc = dbo.NhaCungCap.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSz = dbo.Size.Id where nhacungcap.TenNcc =? ";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPhamChiTietViewModel> listBH = new ArrayList<>();
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                String tenLSP = rs.getString("TenLoai");
                String tenMs = rs.getString("TenMau");
                String tenCL = rs.getString("TenCL");
                String tenSz = rs.getString("TenSize");
                String tenNsx = rs.getString("TenNcc");
                int sl = rs.getInt("SoLuong");
                Double donGia = rs.getDouble("GiaBan");
                SanPhamChiTietViewModel hd = new SanPhamChiTietViewModel(tenSP, tenLSP, tenMs, tenCL, tenSz, tenNsx, sl, donGia);
                listBH.add(hd);
            }
            return listBH;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonCTBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<String> getalllsp() {
        String query = "select sanpham.tensp from sanpham";
            ArrayList<String> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               String x = rs.getString(1);
               list.add(x);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonCTBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
        public List<String> getalllsp1() {
        String query = "select TenLoai from Loaisanpham ";
            ArrayList<String> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               String x = rs.getString(1);
               list.add(x);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonCTBHRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        String name = "Bên Trong";
        List<SanPhamChiTietViewModel> list = new SanPhamCTRepo().locloaiSP(name);
        for (SanPhamChiTietViewModel x : list) {
            System.out.println(x.toString());
        }
        
        
    }
    
    

}
