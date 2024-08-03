/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 * Model class for NhaCungCap representing the NHACUNGCAP table.
 * 
 * @author Admin
 */
public class NhaCungCap {
    private int maNCC;
    private String tenNCC, soDT, diaChi;

    // Default constructor
    public NhaCungCap() {
    }

    public NhaCungCap(int maNCC, String tenNCC, String soDT, String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.soDT = soDT;
        this.diaChi = diaChi;
    }
    
   

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

}
