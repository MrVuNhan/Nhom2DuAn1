/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import viewmodel.NhaCungCapviewmodel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import ulities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class NhaCungCapRepository {

    public List<NhaCungCapviewmodel> getAll() {
        String query = "SELECT [Ma]\n"
                + "      ,[TenNcc]\n"
                + "      ,[SDT]\n"
                + "      ,[Email]\n"
                + "  FROM [dbo].[NhaCungCap]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<NhaCungCapviewmodel> listncc = new ArrayList<>();
            while (rs.next()) {
                NhaCungCapviewmodel ncc = new NhaCungCapviewmodel(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                listncc.add(ncc);
            }
            return listncc;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(NhaCungCapviewmodel nccvmd) {
        String query = "INSERT INTO [dbo].[NhaCungCap]\n"
                + "           ([Ma]\n"
                + "           ,[TenNcc]\n"
                + "           ,[SDT]\n"
                + "           ,[Email])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nccvmd.getMaNhaCC());
            ps.setObject(2, nccvmd.getTenNhaCC());
            ps.setObject(3, nccvmd.getSDT());
            ps.setObject(4, nccvmd.getEmail());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NhaCungCapviewmodel nccvmd, String Ma) {
        String query = "UPDATE [dbo].[NhaCungCap]\n"
                + "   SET \n"
                + "      [TenNcc] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[Email] = ?\n"
                + " WHERE Ma like ? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nccvmd.getTenNhaCC());
            ps.setObject(2, nccvmd.getSDT());
            ps.setObject(3, nccvmd.getEmail());
            ps.setObject(4, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[NhaCungCap]\n"
                + "      WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
