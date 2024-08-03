/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.ChiTietHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phanc
 */
public class ChiTietHoaDonDAO {
    public List<ChiTietHoaDon> docChiTietSanPham(int maHD) throws Exception{
        List<ChiTietHoaDon> list = new ArrayList<>();
        String queryString = "SELECT * FROM ChiTietHoaDon where ChiTietHoaDon.MaHD = ?";
        try (Connection conn = DAO.KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);) {
            pstm.setInt(1, maHD);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaCTDH(rs.getInt("MaCTHD"));
                cthd.setMaHD(rs.getInt("MaHD"));
                cthd.setMaSP(rs.getInt("MaSP"));
                cthd.setSoLuong(rs.getInt("SoLuong"));
                cthd.setDonGia(rs.getDouble("DonGia"));
                list.add(cthd);
            }
            return list;
        }
    }
    
    public boolean themChiTietHoaDon(ChiTietHoaDon cthd) throws Exception {
        String queryString = "Insert into Chitiethoadon(MaHD, MaSP, SoLuong, DonGia) values (?,?,?,?)";
        try(Connection conn = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = conn.prepareStatement(queryString);){
            pstm.setInt(1, cthd.getMaHD());
            pstm.setInt(2, cthd.getMaSP());
            pstm.setInt(3, cthd.getSoLuong());
            pstm.setDouble(4, cthd.getDonGia());
            return pstm.executeUpdate() > 0;
        }
    }
}
