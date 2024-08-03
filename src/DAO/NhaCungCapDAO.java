/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.NhaCungCap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Data Access Object for NhaCungCap
 * 
 * Handles database operations related to the NhaCungCap model.
 * 
 * @author Admin
 */
public class NhaCungCapDAO {

    public List<NhaCungCap> docTatCaNCC() {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NHACUNGCAP";
            Connection con = DAO.KetNoiCSDL.ketNoiCSDL();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("MANCC"));  
                ncc.setTenNCC(rs.getString("TENNCC"));
                ncc.setSoDT(rs.getString("SoDt"));
                ncc.setDiaChi(rs.getString("DiaChi")); 
                list.add(ncc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void themNhaCungCap(NhaCungCap ncc) {
        try {
            String sql = "INSERT INTO NHACUNGCAP (TENNCC,SODT,DIACHI)VALUES(?,?,?)";
            Connection con = DAO.KetNoiCSDL.ketNoiCSDL();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,ncc.getTenNCC());
            stm.setString(2,ncc.getSoDT());
            stm.setString(3,ncc.getDiaChi());
            
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nhà cung cấp đã được thêm vào cơ sở dữ liệu.");
            } else {
                System.out.println("Thêm nhà cung cấp không thành công.");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xoaNhaCungCap(int mancc) {
        try {
                String sql = "DELETE FROM NHACUNGCAP WHERE MANCC = ?";
                Connection con = KetNoiCSDL.ketNoiCSDL();
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, mancc);
                pstmt.executeUpdate();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public void suaNhaCungCap(NhaCungCap ncc) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Kết nối tới cơ sở dữ liệu
            con = KetNoiCSDL.ketNoiCSDL();

            // Câu lệnh SQL UPDATE
            String sql = "UPDATE NHACUNGCAP SET TENNCC = ? , SoDT = ?, DIACHI = ? WHERE MANCC = ?";

            // Chuẩn bị câu lệnh với PreparedStatement
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ncc.getTenNCC()); 
            pstmt.setString(2, ncc.getSoDT());
            pstmt.setString(3, ncc.getDiaChi());
            pstmt.setInt(4, ncc.getMaNCC());

            // Thực thi câu lệnh SQL
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cập nhật nhà cung cấp thành công");
            } else {
                System.out.println("Không tìm thấy nhà cung cấp để cập nhật");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng PreparedStatement và Connection
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean isTenNhaCungCapExist(String tenNCC) {
        String query = "SELECT COUNT(*) FROM NhaCungCap WHERE TenNCC = ?";
        try (Connection con = DAO.KetNoiCSDL.ketNoiCSDL();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, tenNCC);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return false;
    }

    public boolean isSoDTExist(String sdt) {
        String query = "SELECT COUNT(*) FROM NhaCungCap WHERE Sodt = ?";
         try (Connection con = DAO.KetNoiCSDL.ketNoiCSDL();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, sdt);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return false;
    }
    
    public List<NhaCungCap> docNhaCungCapTheoTen(String tenSP) throws Exception{
        List<NhaCungCap> list = new ArrayList<>();
        String queryString = "Select * from NhaCungCap where TenNCC like ?";
        try (Connection conn = DAO.KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);) {
            pstm.setString(1, "%" + tenSP + "%");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                NhaCungCap sp = new NhaCungCap();
                sp.setMaNCC(rs.getInt("MaNCC"));
                sp.setTenNCC(rs.getString("TenNCC"));
                sp.setSoDT(rs.getString("Sodt"));
                sp.setDiaChi(rs.getString("DiaChi"));          
                list.add(sp);
            }
            return list;
        }
    }
}
