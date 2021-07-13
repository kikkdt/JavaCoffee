/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author kikkdt (KietDt)
 */
public class HoaDon_pojo {

    private int maHD;
    private int maNV;
    private int maKH;
    private int maBan;
    private Timestamp ngayXuatHD;
    private double tongTien;
    private double giamGia;
    private double thanhTien;
    private boolean trangThai;

    
    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public Timestamp getNgayXuatHD() {
        return ngayXuatHD;
    }

    public void setNgayXuatHD(Timestamp ngayXuatHD) {
        this.ngayXuatHD = ngayXuatHD;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDon_pojo(int maHD, int maNV, int maKH, int maBan) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maBan = maBan;
        this.ngayXuatHD = new Timestamp(new Date().getTime());
        this.tongTien = 0;
        this.giamGia = 0;
        this.thanhTien = 0;
        this.trangThai = false;
    }

    public HoaDon_pojo(int maHD, int maNV, int maBan) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = -1;
        this.maBan = maBan;
        this.ngayXuatHD = new Timestamp(new Date().getTime());
        this.tongTien = 0;
        this.giamGia = 0;
        this.thanhTien = 0;
        this.trangThai = false;
    }

    public HoaDon_pojo(int maHD, int maNV, int maKH, int maBan, Timestamp ngayXuatHD, double tongTien, double giamGia, double thanhTien, boolean trangThai) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maBan = maBan;
        this.ngayXuatHD = ngayXuatHD;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    
}
