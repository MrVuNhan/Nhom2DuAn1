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
import viewmodel.LoaiSPViewmodel;

/**
 *
 * @author admin
 */
public class LoaiSPRepo {

    public List<LoaiSPViewmodel> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenLoai]\n"
                + "      ,[CongDung]\n"
                + "  FROM [dbo].[LoaiSanPham]";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<LoaiSPViewmodel> listncc = new ArrayList<>();
            while (rs.next()) {
                LoaiSPViewmodel lsp = new LoaiSPViewmodel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
                listncc.add(lsp);
            }
            return listncc;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(LoaiSPViewmodel lspvmd) {
        String query = "INSERT INTO [dbo].[LoaiSanPham]\n"
                + "           ([Ma]\n"
                + "           ,[TenLoai]\n"
                + "           ,[CongDung])\n"
                + "     VALUES (?,?,?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, lspvmd.getMaLoai());
            ps.setObject(2, lspvmd.getTenLoai());
            ps.setObject(3, lspvmd.getCongDung());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[LoaiSanPham]\n"
                + "      WHERE ma = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(LoaiSPViewmodel lspvmd, String Ma) {
        String query = "UPDATE [dbo].[LoaiSanPham]\n"
                + "   SET [Ma] =?\n"
                + "      ,[TenLoai] =?\n"
                + "      ,[CongDung] = ?\n"
                + " WHERE Ma like ? ";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, lspvmd.getTenLoai());
            ps.setObject(2, lspvmd.getCongDung());
            ps.setObject(3, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
