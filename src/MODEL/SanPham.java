/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import static java.lang.Math.round;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author phanc
 */
public class SanPham {
    private int maSP;
    private String tenSP;
    private int maNCC;
    private int soLuong;
    private double donGia;
    private String hinhSP;
    private String moTa;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, int maNCC, int soLuong, double donGia, String hinhSP, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maNCC = maNCC;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.hinhSP = hinhSP;
        this.moTa = moTa;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(String hinhSP) {
        this.hinhSP = hinhSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public double thanhTien(){
        return this.soLuong * this.donGia;
    }
}