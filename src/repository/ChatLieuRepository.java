/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import viewmodel.ChatlieuViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ulities.DBConnection;

/**
 *
 * @author Asus
 */
public class ChatLieuRepository {

    public List<ChatlieuViewModel> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenCL]\n"
                + "      ,[DacTinh]\n"
                + "      ,[QuyTrinhSX]\n"
                + "  FROM [dbo].[ChatLieu]";
        List<ChatlieuViewModel> list = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatlieuViewModel ss = new ChatlieuViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(ss);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public ChatlieuViewModel getOne(String maSV) {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TenCL]\n"
                + "      ,[DacTinh]\n"
                + "      ,[QuyTrinhSX]\n"
                + "  FROM [dbo].[ChatLieu]"
                + "WHERE Ma = ?";

        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maSV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new ChatlieuViewModel(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(ChatlieuViewModel chatLieu) {
        String query = "INSERT INTO [dbo].[ChatLieu]\n"
                + "           ([Ma]\n"
                + "           ,[TenCL]\n"
                + "           ,[DacTinh]\n"
                + "           ,[QuyTrinhSX])\n"
                + "     VALUES (?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chatLieu.getMa());
            ps.setObject(2, chatLieu.getTen());
            ps.setObject(3, chatLieu.getDacTinh());
            ps.setObject(4, chatLieu.getQuyTrinh());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChatlieuViewModel chatLieu, String Ma) {
        String query = "UPDATE [dbo].[ChatLieu]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[TenCL] = ?\n"
                + "      ,[DacTinh] = ?\n"
                + "      ,[QuyTrinhSX] = ?"
                + " WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chatLieu.getMa());
            ps.setObject(2, chatLieu.getTen());
            ps.setObject(3, chatLieu.getDacTinh());
            ps.setObject(4, chatLieu.getQuyTrinh());
            ps.setObject(5, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[ChatLieu]\n"
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

    public static void main(String[] args) {
        List<ChatlieuViewModel> lists = new ChatLieuRepository().getAll();
    }
}
