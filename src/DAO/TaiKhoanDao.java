/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.NhanVien;
import MODEL.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class TaiKhoanDao {
     public List<TaiKhoan> readAllTaiKhoan() 
     {
        List<TaiKhoan> listTK = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TaiKhoan";
            Connection con = KetNoiCSDL.ketNoiCSDL();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenDN(rs.getString(1));
                 tk.setMatKhau(rs.getString(2));
                  tk.setVaiTro(rs.getString(3));
               tk.setMaNV(rs.getInt(4));

                listTK.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTK;
    }
     
     public int themTaiKhoan(TaiKhoan tk)
    {
        try{
            String sql = "Insert into TaiKhoan Values(?,?,?,?)";
            Connection con = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, tk.getTenDN());
            pstm.setString(2, tk.getMatKhau());
            pstm.setString(3, tk.getVaiTro());
            pstm.setInt(4, tk.getMaNV());
        
            return pstm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
     
     
      public int suaTaiKhoan(TaiKhoan tk) 
      {
        try {
            String sql = "UPDATE TaiKhoan SET Matkhau=?, Vaitro=?, MaNV=? WHERE Tendangnhap=?";
            Connection con = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, tk.getMatKhau());
            pstm.setString(2, tk.getVaiTro());
             pstm.setInt(3, tk.getMaNV());
              pstm.setString(4, tk.getTenDN());

            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
      
       public int xoaTaiKhoan(String tenDN){
        try {
            String sql = "Delete TaiKhoan where Tendangnhap=?";
             Connection con = KetNoiCSDL.ketNoiCSDL();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, tenDN);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
     
}
