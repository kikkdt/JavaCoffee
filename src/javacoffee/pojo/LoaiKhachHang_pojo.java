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
public class LoaiKhachHang_pojo {
    private int maLoaiKH;
    private String tenLoaiKH;
    private int phanTramGiam;
    private boolean daXoa;

    public int getMaLoaiKH() {
        return maLoaiKH;
    }

    public void setMaLoaiKH(int maLoaiKH) {
        this.maLoaiKH = maLoaiKH;
    }

    public String getTenLoaiKH() {
        return tenLoaiKH;
    }

    public void setTenLoaiKH(String tenLoaiKH) {
        this.tenLoaiKH = tenLoaiKH;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    public LoaiKhachHang_pojo(int maLoaiKH, String tenLoaiKH, int phanTramGiam, boolean daXoa) {
        this.maLoaiKH = maLoaiKH;
        this.tenLoaiKH = tenLoaiKH;
        this.phanTramGiam = phanTramGiam;
        this.daXoa = daXoa;
    }
}