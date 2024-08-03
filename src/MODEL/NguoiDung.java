/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Admin
 */
public class NguoiDung {
    private String tenDangNhap;
    private String matKhau;
    private String role;

    public NguoiDung() {
    }

    public NguoiDung(String tenDangNhap, String matKhau, String role) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.role = role;
    }

    // Các phương thức getter và setter cho các thuộc tính
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
