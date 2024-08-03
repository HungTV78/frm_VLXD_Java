/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phanc
 */
public class SanPhamDAO {
    public List<SanPham> docTatCaSanPham() {
        List<SanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SanPham";
            Connection con = DAO.KetNoiCSDL.ketNoiCSDL();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setMoTa(rs.getString("MoTa"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setHinhSP(rs.getString("hinh"));
                sp.setMaNCC(rs.getInt("MaNCC"));
                list.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<SanPham> docSanPhamTheoTen(String tenSP) throws Exception{
        List<SanPham> list = new ArrayList<>();
        String queryString = "Select * from SanPham where TenSP like ?";
        try (Connection conn = DAO.KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);) {
            pstm.setString(1, "%" + tenSP + "%");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setMoTa(rs.getString("MoTa"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setHinhSP(rs.getString("hinh"));
                sp.setMaNCC(rs.getInt("MaNCC"));
                list.add(sp);
            }
            return list;
        }
    }
    
    public boolean themSanPham(SanPham sp) throws Exception {
        String queryString = "INSERT INTO SanPham (TenSP, MaNCC, SoLuong, DonGia, Hinh, Mota) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DAO.KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);) {
            pstm.setString(1, sp.getTenSP());
            pstm.setInt(2, sp.getMaNCC());
            pstm.setInt(3, sp.getSoLuong());
            pstm.setDouble(4, sp.getDonGia());
            pstm.setString(5, sp.getHinhSP());
            pstm.setString(6, sp.getMoTa());
            return pstm.executeUpdate() > 0;
        }
    }
    
    public boolean suaSanPham(SanPham sp) throws Exception {
        String queryString = "UPDATE SanPham Set TenSP = ?, MaNCC = ?, SoLuong = ?, DonGia = ?, Hinh = ?, Mota = ? where MaSP = ?";
        try (Connection conn = DAO.KetNoiCSDL.ketNoiCSDL();
             PreparedStatement pstm = conn.prepareStatement(queryString);) {
            pstm.setString(1, sp.getTenSP());
            pstm.setInt(2, sp.getMaNCC());
            pstm.setInt(3, sp.getSoLuong());
            pstm.setDouble(4, sp.getDonGia());
            pstm.setString(5, sp.getHinhSP());
            pstm.setString(6, sp.getMoTa());
            pstm.setInt(7, sp.getMaSP());
            return pstm.executeUpdate() > 0;
        }
    }
    
    public boolean xoaHangHoa(String masp) throws Exception{
        String queryString = "delete from SanPham where MASP = ?";
        try(Connection conn = DAO.KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);){
            pstm.setString(1, masp);
            return pstm.executeUpdate() > 0;
        }
    }
}
