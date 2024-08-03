/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author ACER
 */
public class TaiKhoan {
    public String tenDN;
    public String matKhau;
    public String vaiTro;
    public int maNV;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDN, String matKhau, String vaiTro, int maNV) {
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.maNV = maNV;
    }

    public String getTenDN() {
        return tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    
    
    
}
