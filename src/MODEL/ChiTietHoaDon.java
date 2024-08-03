/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author phanc
 */
public class ChiTietHoaDon {
    private int maCTDH, maHD, maSP, soLuong;
    private double donGia;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maCTDH, int maHD, int maSP, int soLuong, double donGia) {
        this.maCTDH = maCTDH;
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaCTDH() {
        return maCTDH;
    }

    public void setMaCTDH(int maCTDH) {
        this.maCTDH = maCTDH;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
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
    
    
}
