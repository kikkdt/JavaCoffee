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
public class KhachHang_pojo {
    private int maKH;
    private String tenKH;
    private int maLoaiKH;
    private int diemTichLuy;
    private String sdt;
    private boolean daXoa;

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getMaLoaiKH() {
        return maLoaiKH;
    }

    public void setMaLoaiKH(int maLoaiKH) {
        this.maLoaiKH = maLoaiKH;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
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

    public KhachHang_pojo(int maKH, String tenKH, int maLoaiKH, int diemTichLuy, String sdt, boolean daXoa) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.maLoaiKH = maLoaiKH;
        this.diemTichLuy = diemTichLuy;
        this.sdt = sdt;
        this.daXoa = daXoa;
    }
}
