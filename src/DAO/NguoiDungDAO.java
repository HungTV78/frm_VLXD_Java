/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class NguoiDungDAO {
    private Connection conn;

    public NguoiDungDAO(Connection connection) {
        this.conn = connection;
    }

   public NguoiDung kiemTraDangNhap(String tenDangNhap, String matKhau) throws SQLException {
        String sql = "SELECT * FROM TAIKHOAN WHERE TENDANGNHAP = ? and MATKHAU = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, tenDangNhap);
            statement.setString(2, matKhau);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    NguoiDung user = new NguoiDung();
                    user.setTenDangNhap(resultSet.getString("tendangnhap"));
                    user.setRole(resultSet.getString("vaitro"));
                    return user;
                }
            }
        }
        return null;
    }
}
