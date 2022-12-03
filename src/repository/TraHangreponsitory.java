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
        String query = "SELECT dbo.KhachHang.ma,dbo.HoaDon.Ma, "
                + "dbo.KhachHang.TenKH, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThu, "
                + "dbo.HoaDon.DiaChi, dbo.HoaDon.SDT, dbo.HoaDon.TinhTrang\n"
                + "FROM   dbo.HoaDon INNER JOIN\n"
                + " dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonModel> listhoadon = new ArrayList();
            while (rs.next()) {
                HoaDonModel hd1 = new HoaDonModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getInt(8));
                listhoadon.add(hd1);
            }
            return listhoadon;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getallbymahoadon(HoaDonModel hd, String id) {

        String query = "select KhachHang.TenKH,HoaDon.Ma,ChiTietHD.SoLuong,ChiTietHD.DonGia \n"
                + "        from KhachHang \n"
                + "        join HoaDon on KhachHang.id = HoaDon.IdKH \n"
                + "        join ChiTietHD on HoaDon.Id = ChiTietHD.IdHD "
                + " where HoaDon.id=  ? ";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hd.setTenkh(rs.getString(1));
                hd.setMahd(rs.getString(2));
                hd.setSoluong(rs.getInt(3));
                hd.setDongia(rs.getDouble(4));

            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean updateCTHD(String idHD, int soLuongTra) {
        String query = "UPDATE [dbo].[ChiTietHD]\n"
                + "   SET \n"
                + "      [SoLuong] = SoLuong - ?\n"
                + "      \n"
                + " WHERE IdHD = ? ";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, soLuongTra);
            ps.setObject(2, idHD);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String idKH, String idHD, String idCTSP, String tenKH, int soLuong, double donGia) {
        String query = "INSERT INTO [dbo].[trahang]\n"
                + "           (\n"
                + "           [IdKH]\n"
                + "           ,[IdHD]\n"
                + "           ,[IdCTSP]\n"
                + "           ,[TenKH]\n"
                + "           ,[NgayTra]\n"
                + "           ,[SoLuong]\n"
                + "           ,[TongTienTL])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idKH);
            ps.setObject(2, idHD);
            ps.setObject(3, idCTSP);
            ps.setObject(4, tenKH);
            ps.setObject(5, date);
            ps.setObject(6, soLuong);
            ps.setObject(7, soLuong * donGia);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String getIDKH(String maKH) {
        String id = null;
        String query = "Select id from KhachHang where ma = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public String getIDHD(String maHD) {
        String id = null;
        String query = "Select id from HoaDon where ma = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public String getIDCTHD(String idHD) {
        String id = null;
        String query = "Select idCTSP from ChiTietHD where idHD = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("idCTSP");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public Integer getSoLuong(String idHD) {
        int sl = 0;
        String query = "Select SoLuong from ChiTietHD where idHD = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getInt("SoLuong");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sl;
    }

    public static void main(String[] args) {

        String maHD = "hd01";

    }
}
