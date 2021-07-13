/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.pojo;

import java.sql.Time;

/**
 *
 * @author kikkdt (KietDt)
 */
public class CaLam_pojo {
    private int maCaLam;
    private String tenCaLam;
    private Time gioBatDau;
    private Time gioKetThuc;
    private boolean daXoa;

    public int getMaCaLam() {
        return maCaLam;
    }

    public void setMaCaLam(int maCaLam) {
        this.maCaLam = maCaLam;
    }

    public String getTenCaLam() {
        return tenCaLam;
    }

    public void setTenCaLam(String tenCaLam) {
        this.tenCaLam = tenCaLam;
    }

    public Time getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Time gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Time getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Time gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    public CaLam_pojo(int maCaLam, String tenCaLam, Time gioBatDau, Time gioKetThuc, boolean daXoa) {
        this.maCaLam = maCaLam;
        this.tenCaLam = tenCaLam;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.daXoa = daXoa;
    }
}
