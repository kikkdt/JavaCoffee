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
public class Luong_pojo {
    private int maNV;
    private String tenNV;
    private int tongCaLam;
    private double thanhTien;

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTongCaLam() {
        return tongCaLam;
    }

    public void setTongCaLam(int tongCaLam) {
        this.tongCaLam = tongCaLam;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Luong_pojo(int maNV, String tenNV, int tongCaLam, double thanhTien) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tongCaLam = tongCaLam;
        this.thanhTien = thanhTien;
    }
}
