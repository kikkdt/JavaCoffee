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
public class Ban_pojo {

    private int maBan;
    private int maKhuVuc;
    private String tenBan;
    private boolean trangThai;
    private boolean daXoa;

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    public Ban_pojo(int maBan, int maKhuVuc, String tenBan, boolean trangThai, boolean daXoa) {
        this.maBan = maBan;
        this.maKhuVuc = maKhuVuc;
        this.tenBan = tenBan;
        this.trangThai = trangThai;
        this.daXoa = daXoa;
    }

}
