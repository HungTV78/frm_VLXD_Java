/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.HoaDon;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phanc
 */
public class HoaDonDAO {
    public List<HoaDon> docTatCaHoaDon() throws Exception{
        List<HoaDon> listHD = new ArrayList<>();
        String queryString = "select * from HoaDon";
        try(Connection conn = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);){
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaKH(rs.getInt("MaKH"));
                hd.setMaNV(rs.getInt("MaNV"));
                Date sqlDate = rs.getDate("NgayLapHD");
                java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
                hd.setNgayLapHD(utilDate);
                hd.setTongTien(rs.getDouble("TongTien"));
                listHD.add(hd);
            }
            return listHD;
        }
    }
    
    public List<HoaDon> docTatCaHoaDonTheoMaHD(String maHD) throws Exception{
        List<HoaDon> listHD = new ArrayList<>();
        String queryString = "select * from HoaDon where maHD like ?";
        try(Connection conn = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);) {
            pstm.setString(1, "%" + maHD + "%");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaKH(rs.getInt("MaKH"));
                hd.setMaNV(rs.getInt("MaNV"));
                Date sqlDate = rs.getDate("NgayLapHD");
                java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
                hd.setNgayLapHD(utilDate);
                hd.setTongTien(rs.getDouble("TongTien"));
                listHD.add(hd);
            }
            return listHD;
        }
    }
    
//    public boolean themHoaDon(HoaDon hd) throws Exception {
//        String queryString = "INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, TongTien) VALUES (?, ?, ?, ?)";
//        try(Connection conn = KetNoiCSDL.ketNoiCSDL();
//            PreparedStatement pstm = conn.prepareStatement(queryString);){
//            pstm.setInt(1, hd.getMaKH());
//            pstm.setInt(2, hd.getMaNV());
//            Date sqlDate = new Date(hd.getNgayLapHD().getTime());
//            pstm.setDate(3, sqlDate);
//            pstm.setDouble(4, hd.getTongTien());
//            int affectedRows = pstm.executeUpdate();
//            
//            if (affectedRows > 0) {
//                try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        hd.setMaHD(generatedKeys.getInt(1));
//                    }
//                }
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }
    
    public boolean themHoaDon(HoaDon hd) throws Exception {
    String queryString = "INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, TongTien) VALUES (?, ?, ?, ?)";
    try(Connection conn = KetNoiCSDL.ketNoiCSDL();
        PreparedStatement pstm = conn.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);){ // Enable retrieving generated keys
        pstm.setInt(1, hd.getMaKH());
        pstm.setInt(2, hd.getMaNV());
        Date sqlDate = new Date(hd.getNgayLapHD().getTime());
        pstm.setDate(3, sqlDate);
        pstm.setDouble(4, hd.getTongTien());
        int affectedRows = pstm.executeUpdate();
        
        if (affectedRows > 0) {
            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    hd.setMaHD(generatedKeys.getInt(1));
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
}
