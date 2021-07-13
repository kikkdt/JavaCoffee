/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class TaiKhoan_pojo {
    private String tenDangNhap;
    private String matKhau;
    private String tenHienThi;
    private int idLoaiTK;
    private int maNV;
    private boolean daXoa;

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

    public String getTenHienThi() {
        return tenHienThi;
    }

    public void setTenHienThi(String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }

    public int getIdLoaiTK() {
        return idLoaiTK;
    }

    public void setIdLoaiTK(int idLoaiTK) {
        this.idLoaiTK = idLoaiTK;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    public TaiKhoan_pojo(String tenDangNhap, String matKhau, String tenHienThi, int idLoaiTK, int maNV, boolean daXoa) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.tenHienThi = tenHienThi;
        this.idLoaiTK = idLoaiTK;
        this.maNV = maNV;
        this.daXoa = daXoa;
    }
}
