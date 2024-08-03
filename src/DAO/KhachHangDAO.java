/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author phanc
 */
public class KhachHangDAO {
    public List<KhachHang> docTatCaKhachHang() throws Exception{
        String queryString = "Select * from KhachHang";
        List<KhachHang> listKH = new ArrayList<>();
        try(Connection conn = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);){
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setSoDT(rs.getString("SoDT"));
                kh.setDiaChi(rs.getString("DiaChi"));
                listKH.add(kh);
            }
            return listKH;
        }
    }
    
//    public boolean themKhachHang(KhachHang kh) throws Exception {
//        String queryString = "INSERT INTO KhachHang (TenKH, Sodt, Diachi) VALUES (?, ?, ?)";
//        try(Connection conn = KetNoiCSDL.ketNoiCSDL();
//            PreparedStatement pstm = conn.prepareStatement(queryString);){
//            pstm.setString(1, kh.getTenKH());
//            pstm.setString(2, kh.getSoDT());
//            pstm.setString(3, kh.getDiaChi());
//            return pstm.executeUpdate() > 0;
//        }
//    }
    
//    public boolean suaKhachHang(KhachHang kh) throws Exception {
//        String queryString = "Update KhachHang SET TenKH = ?, Sodt = ?, Diachi = ? WHERE MaKH = ?";
//        try(Connection conn = KetNoiCSDL.ketNoiCSDL();
//            PreparedStatement pstm = conn.prepareStatement(queryString);){
//            pstm.setString(1, kh.getTenKH());
//            pstm.setString(2, kh.getSoDT());
//            pstm.setString(3, kh.getDiaChi());
//            pstm.setInt(4, kh.getMaKH());
//            return pstm.executeUpdate() > 0;
//        }
//    }
    
    public List<KhachHang> readAllKhachHang(){
        List <KhachHang> listKH = new ArrayList<>();
        try {
            String sql = "select *from KhachHang";
            Connection con = KetNoiCSDL.ketNoiCSDL();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH((rs.getInt(1)));
                kh.setTenKH(rs.getString(2));
                kh.setSoDT(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
    public List<KhachHang> findKhachHang(String keyword) {
        List<KhachHang> listKH = new ArrayList<>();
        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            String sql;
            PreparedStatement ps;
            
            if (keyword.matches(".*\\d.*")) {
                sql = "SELECT * FROM KhachHang WHERE Sodt LIKE ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                System.out.println(sql);
            } else {
                sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                System.out.println(sql);
            }
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH((rs.getInt("MaKH")));
                kh.setTenKH(rs.getString("TenKH"));
                
                kh.setSoDT(rs.getString("Sodt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
    public boolean themKhachHang(KhachHang kh) {
        boolean success = false;
        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            String sql = "INSERT INTO KhachHang (TenKH, Sodt, DiaChi) VALUES ( ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getSoDT());
            ps.setString(3, kh.getDiaChi());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    public boolean xoaKhachHang(int maKH) {
        boolean success = false;
        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maKH);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    public boolean suaKhachHang(KhachHang kh) {
        boolean success = false;
        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            String sql = "UPDATE KhachHang SET TenKH = ?, Sodt = ?, Diachi = ? WHERE MaKH = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getSoDT());
            ps.setString(3, kh.getDiaChi());
            ps.setInt(4, kh.getMaKH());
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
    public boolean isCustomerDataValid(String phone) {
        boolean isValid = true;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Connection con = KetNoiCSDL.ketNoiCSDL();
            // Kiểm tra số điện thoại đã tồn tại trong cơ sở dữ liệu
            String phoneQuery = "SELECT COUNT(*) FROM KhachHang WHERE Sodt = ?";
            stmt = con.prepareStatement(phoneQuery);
            stmt.setString(1, phone);
            rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                isValid = false;
                System.out.println("Số điện thoại đã được sử dụng");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            isValid = false;

        }

        return isValid;
    }
    public boolean isCustomerDataValidSua(int customerId, String phone) {
        boolean isValid = true;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            // Kết nối với cơ sở dữ liệu
            con = KetNoiCSDL.ketNoiCSDL();
            // Kiểm tra số điện thoại đã tồn tại trong cơ sở dữ liệu (trừ số điện thoại của nhân viên đang sửa)
            String phoneQuery = "SELECT COUNT(*) FROM KhachHang WHERE Sodt = ? AND MaKH <> ?";
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
