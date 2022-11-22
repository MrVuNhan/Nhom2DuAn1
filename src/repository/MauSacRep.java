/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import viewmodel.MauSacViewmodel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import ulities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class MauSacRep {

    public List<MauSacViewmodel> getAll() {
        String query = "SELECT [Ma]\n"
                + "      ,[TenMau]\n"
                + "  FROM [dbo].[MauSac]";
        List<MauSacViewmodel> lists = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSacViewmodel svmd = new MauSacViewmodel(rs.getString(1), rs.getString(2));
                lists.add(svmd);

            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(MauSacViewmodel msvmd) {
        String query = "INSERT INTO [dbo].[MauSac]\n"
                + "           ([Ma]\n"
                + "           ,[TenMau])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, msvmd.getMaMS());
            ps.setObject(2, msvmd.getTenMS());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(MauSacViewmodel msvmd, String Ma) {
        String query = "UPDATE [dbo].[MauSac]\n"
                + "   SET \n"
                + "      [TenMau] = ?\n"
                + " WHERE Ma like ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, msvmd.getTenMS());
            ps.setObject(2, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[MauSac]\n"
                + "WHERE Ma=?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }
}
