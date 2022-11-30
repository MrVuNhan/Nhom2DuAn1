/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import viewmodel.QuanLyViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ulities.DBConnection;
/**
 *
 * @author Asus
 */
public class UsersRepository {
    public QuanLyViewModel getOne(String user, String password) {
        String query = "select * from QuanLy us where Ma = ? and MatKhau =? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, user);
            ps.setObject(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new QuanLyViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean upPass(QuanLyViewModel ql, String Ma) {
        String query = "UPDATE [dbo].[QuanLy]\n"
                + "   SET [MatKhau] = ?\n"
                + " WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ql.getMatKhau());
            ps.setObject(2, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
