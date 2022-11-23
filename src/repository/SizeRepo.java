/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.SanPhamH;
import domainmodel.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulities.DBConnection;
import viewmodel.SanPhamViewModel;
import viewmodel.SizeViewModel;

/**
 *
 * @author FPTSHOP
 */
public class SizeRepo {

    public List<SizeViewModel> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenSize]\n"
                + "  FROM [dbo].[Size]";

        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<SizeViewModel> listSz = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("TenSize");
                SizeViewModel sz = new SizeViewModel(id, ma, ten);
                listSz.add(sz);
            }
            return listSz;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean add(Size sz) {
        String query = "INSERT INTO [dbo].[Size]\n"
                + "           ([Ma]\n"
                + "           ,[TenSize])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sz.getMa());
            ps.setObject(2, sz.getTen());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean update(Size sp, String ma) {
        String query = "UPDATE [dbo].[Size]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[TenSize] = ?\n"
                + " WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
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
        String query = "DELETE FROM [dbo].[Size]\n"
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
