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
public class NguyenLieu_pojo {
    private int maNL;
    private String tenNL;
    private int maNCC;
    private String donViTinh;
    private double donGia;
    private String moTa;
    private boolean daXoa;

    public int getMaNL() {
        return maNL;
    }

    public void setMaNL(int maNL) {
        this.maNL = maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    public NguyenLieu_pojo(int maNL, String tenNL, int maNCC, String donViTinh, double donGia, String moTa, boolean daXoa) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.maNCC = maNCC;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.moTa = moTa;
        this.daXoa = daXoa;
    }
}
