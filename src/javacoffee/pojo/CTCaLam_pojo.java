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
public class CTCaLam_pojo {

    private int maNV;
    private int maCaLam;
    private Timestamp ngayLam;

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaCaLam() {
        return maCaLam;
    }

    public void setMaCaLam(int maCaLam) {
        this.maCaLam = maCaLam;
    }

    public Timestamp getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(Timestamp ngayLam) {
        this.ngayLam = ngayLam;
    }

    public CTCaLam_pojo(int maNV, int maCaLam, Timestamp ngayLam) {
        this.maNV = maNV;
        this.maCaLam = maCaLam;
        this.ngayLam = ngayLam;
    }
}
