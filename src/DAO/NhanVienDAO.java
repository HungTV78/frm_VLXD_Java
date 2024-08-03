/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phanc
 */
public class NhanVienDAO {
    public List<NhanVien> readAllNhanVien(){
        List <NhanVien> listNV = new ArrayList<>();
        try {
            String sql = "select *from NhanVien";
            Connection con = KetNoiCSDL.ketNoiCSDL();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV((rs.getInt(1)));
                nv.setTenNV(rs.getString(2));
                nv.setEmail(rs.getString(3));
                nv.setSDT(rs.getString(4));
                nv.setDiaChi(rs.getString(5));
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
    public List<NhanVien> findNhanVien(String keyword) {
        List<NhanVien> listNV = new ArrayList<>();
        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            String sql;
            PreparedStatement ps;
            
            if (keyword.matches(".*\\d.*")) {
                sql = "SELECT * FROM NhanVien WHERE Sodt LIKE ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
            } else {
                sql = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
            }
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setEmail(rs.getString("Email"));
                nv.setSDT(rs.getString("Sodt"));
                nv.setDiaChi(rs.getString("DiaChi"));
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
    
    public  NhanVien searchNhanVienTheoma(int MaNV) {
        NhanVien nv = null;
        try {
          
      
            String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
            Connection con = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, MaNV);
            ResultSet rs = pstmt.executeQuery();

            // Di chuyển con trỏ đến hàng dữ liệu đầu tiên (nếu có)
            if (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getInt(1));
                nv.setTenNV(rs.getString(2));
                nv.setEmail(rs.getString(3));
                nv.setSDT(rs.getString(4));
                nv.setDiaChi(rs.getString(5));

            
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }
    
    public  NhanVien timNhanVienTheoTen(String tenNV) {
        NhanVien nv = null; // Initialize ncc to null
        try {
            String sql = "SELECT * FROM NhanVien WHERE TenNV = ?";
            Connection con = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tenNV);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getInt(1));
                nv.setTenNV(rs.getString(2));
                nv.setEmail(rs.getString(3));
                nv.setSDT(rs.getString(4));
                nv.setDiaChi(rs.getString(5));
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }
    
    public boolean themNhanVien(NhanVien nv) {
        boolean success = false;
        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            String sql = "INSERT INTO NhanVien (TenNV, Email, Sodt, DiaChi) VALUES ( ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getEmail());
            ps.setString(3, nv.getSDT());
            ps.setString(4, nv.getDiaChi());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try {
                    
                    success = true;
                } catch (Exception e) {
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    public boolean xoaNhanVien(int maNV) {
        boolean success = false;
        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maNV);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    public boolean suaNhanVien(NhanVien nv) {
        boolean success = false;
        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            String sql = "UPDATE NhanVien SET TenNV = ?, Email = ?, Sodt = ?, Diachi = ? WHERE MaNV = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getEmail());
            ps.setString(3, nv.getSDT());
            ps.setString(4, nv.getDiaChi());
            ps.setInt(5, nv.getMaNV());
            System.out.println(sql);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    public boolean isCustomerDataValid(String email, String phone) {
        boolean isValid = true;
        PreparedStatement emailStmt = null;
        PreparedStatement phoneStmt = null;
        ResultSet rsEmail = null;
        ResultSet rsPhone = null;

        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();

            // Kiểm tra email đã tồn tại trong cơ sở dữ liệu
            String emailQuery = "SELECT COUNT(*) FROM NhanVien WHERE email = ?";
            emailStmt = con.prepareStatement(emailQuery);
            emailStmt.setString(1, email);
            rsEmail = emailStmt.executeQuery();
            if (rsEmail.next() && rsEmail.getInt(1) > 0) {
                isValid = false;
                System.out.println("Email đã tồn tại trong Hệ thống!");
            }

            // Đóng ResultSet và PreparedStatement của truy vấn email
            rsEmail.close();
            emailStmt.close();

            // Kiểm tra số điện thoại đã tồn tại trong cơ sở dữ liệu
            String phoneQuery = "SELECT COUNT(*) FROM NhanVien WHERE Sodt = ?";
            phoneStmt = con.prepareStatement(phoneQuery);
            phoneStmt.setString(1, phone);
            rsPhone = phoneStmt.executeQuery();
            if (rsPhone.next() && rsPhone.getInt(1) > 0) {
                isValid = false;
                System.out.println("Số điện thoại đã tồn tại trong cơ sở dữ liệu.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            isValid = false;
        } finally {
            // Đảm bảo đóng tất cả các ResultSet và PreparedStatement
            try {
                if (rsEmail != null) rsEmail.close();
                if (rsPhone != null) rsPhone.close();
                if (emailStmt != null) emailStmt.close();
                if (phoneStmt != null) phoneStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isValid;
    }
    public boolean isCustomerDataValidSua(int customerId, String email, String phone) {
        boolean isValid = true;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = KetNoiCSDL.ketNoiCSDL();
            String emailQuery = "SELECT COUNT(*) FROM NhanVien WHERE email = ? AND MaNV <> ?";
            stmt = con.prepareStatement(emailQuery);
            stmt.setString(1, email);
            stmt.setInt(2, customerId);
            rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                isValid = false;
                System.out.println("Email đã tồn tại trong cơ sở dữ liệu.");
            }

            String phoneQuery = "SELECT COUNT(*) FROM NhanVien WHERE Sodt = ? AND MaNV <> ?";
            stmt = con.prepareStatement(phoneQuery);
            stmt.setString(1, phone);
            stmt.setInt(2, customerId);
            rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                isValid = false;
                System.out.println("Số điện thoại đã tồn tại trong cơ sở dữ liệu.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            isValid = false;
        } finally {
            // Đóng kết nối, statement và result set
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isValid;
    }
}
