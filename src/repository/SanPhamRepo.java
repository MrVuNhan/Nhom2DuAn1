/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.SanPhamH;
import java.util.List;
import viewmodel.SanPhamViewModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamRepo {
    
    public List<SanPhamViewModel> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenSP]\n"
                + "  FROM [dbo].[SanPham]";
        
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamViewModel> listSP = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("TenSP");
                SanPhamViewModel sp = new SanPhamViewModel(id, ma, ten);
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean add(SanPhamH sp) {
        String query = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([Ma]\n"
                + "           ,[TenSP])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
    
    public boolean update(SanPhamH sp, String ma) {
        String query = "UPDATE [dbo].[SanPham]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[TenSP] = ?\n"
                + " WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
    
    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[SanPham]\n"
                + "      WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
