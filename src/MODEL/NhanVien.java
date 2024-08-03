/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author phanc
 */
public class NhanVien {
    private int MaNV;
    private String TenNV;
    private String Email;
    private String SDT;
    private String DiaChi;

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public NhanVien() {
    }

    public NhanVien(int MaNV, String TenNV, String Email, String SDT, String DiaChi) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.Email = Email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
    }
}
