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
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author syduong
 */
public class HoaDonRepository {
    public List<HoaDonViewModel> getAll(){
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
                    String select = "select * from hoadon";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String ma = rs.getString("ma");
                String ngaytao = rs.getString("ngaytao");
                String ngaythu = rs.getString("ngaythu");
                String tinhtrang = rs.getString("tinhtrang");
                String tennguoinhan = rs.getString("tennguoinhan");
                String diachi = rs.getString("diachi");
                int sdt = rs.getInt("sdt");
                int trangthai = rs.getInt("trangthai");
                HoaDonViewModel hdvm = new HoaDonViewModel( ma, ngaytao, ngaythu, tinhtrang, tennguoinhan, diachi, sdt, trangthai);
                list.add(hdvm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public List<HoaDonViewModel> search(List<HoaDonViewModel> listTim, String tim){
        List<HoaDonViewModel> list = new ArrayList<>();
        String search ="select * from hoadon where Ma=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(tim)){
            ps.setObject(1, tim);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String ma = rs.getString("ma");
                String ngaytao = rs.getString("ngaytao");
                String ngaythu = rs.getString("ngaythu");
                String tinhtrang = rs.getString("tinhtrang");
                String tennguoinhan = rs.getString("tennguoinhan");
                String diachi = rs.getString("diachi");
                int sdt = rs.getInt("sdt");
                int  trangthai = rs.getInt("trangthai");
                HoaDonViewModel hdvm = new HoaDonViewModel( ma, ngaytao, ngaythu, tinhtrang, tennguoinhan, diachi, sdt, trangthai);
                list.add(hdvm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean add(HoaDonViewModel hdvm){
        String insert = "INSERT INTO [dbo].[HoaDon]\n"
                + "([Ma]\n"
                + ",[NgayTao]\n"
                + ",[NgayThu]\n"
                + ",[TinhTrang]\n"
                + ",[tenNguoiNhan]\n"
                + ",[Diachi]\n"
                + ",[SDT]\n"
                + ",[TrangThai])\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(insert)){
            ps.setObject(1, hdvm.getMa());
            ps.setObject(2, hdvm.getNgayTao());
            ps.setObject(3, hdvm.getNgayThu());
            ps.setObject(4, hdvm.getTinhTrang());
            ps.setObject(5, hdvm.getTenNguoiNhan());
            ps.setObject(6, hdvm.getDiaChi());
            ps.setObject(7, hdvm.getSdt());
            ps.setObject(8, hdvm.getTrangThai());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    public boolean update(HoaDonViewModel hdvm, String ma) {
        String update = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[NgayTao] = ?\n"
                + "      ,[TinhTrang]=?\n"
                + "      ,[tenNguoiNhan]=?\n"
                + "      ,[Diachi]=?\n"
                + "      ,[SDT]=?\n"
                + "      ,[TrangThai]=?"
                + " WHERE Ma = ?";
        int check = 0;
        try( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(update)) {
            ps.setObject(1, hdvm.getMa());
            ps.setObject(2, hdvm.getNgayTao());
            ps.setObject(3, hdvm.getNgayThu());
            ps.setObject(4, hdvm.getTinhTrang());
            ps.setObject(5, hdvm.getTenNguoiNhan());
            ps.setObject(6, hdvm.getDiaChi());
            ps.setObject(7, hdvm.getSdt());
            ps.setObject(8, hdvm.getTrangThai());
            ps.setObject(9,ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }
    public boolean delete(String ma){
        String delete ="DELETE FROM [dbo].[HoaDon]\n"
                + "      WHERE Ma = ?";
        int check = 0;
        try( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(delete)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }
}
