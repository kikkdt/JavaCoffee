/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.pojo;

import java.sql.Timestamp;

/**
 *
 * @author kikkdt (KietDt)
 */
public class NhanVien_pojo {

    private int maNV;
    private String tenNV;
    private String gioiTinh;
    private String chucVu;
    private Timestamp ngayVaoLam;
    private String diaChi;
    private String sdt;
    private boolean daXoa;

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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Timestamp getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Timestamp ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    public NhanVien_pojo(int maNV, String tenNV, String gioiTinh, String chucVu, Timestamp ngayVaoLam, String diaChi, String sdt, boolean daXoa) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.ngayVaoLam = ngayVaoLam;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.daXoa = daXoa;
    }
}
