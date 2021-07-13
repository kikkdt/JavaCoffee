/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.pojo;

import java.util.ArrayList;

/**
 *
 * @author kikkdt (KietDt)
 */
public class ThanhToan_pojo {

    private HoaDon_pojo hoadon;
    private Ban_pojo ban;
    private KhuVuc_pojo khuvuc;
    private ArrayList<CTHoaDon_pojo> ctHoaDon;

    public HoaDon_pojo getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDon_pojo hoadon) {
        this.hoadon = hoadon;
    }

    public Ban_pojo getBan() {
        return ban;
    }

    public void setBan(Ban_pojo ban) {
        this.ban = ban;
    }

    public KhuVuc_pojo getKhuvuc() {
        return khuvuc;
    }

    public void setKhuvuc(KhuVuc_pojo khuvuc) {
        this.khuvuc = khuvuc;
    }

    public ArrayList<CTHoaDon_pojo> getCtHoaDon() {
        return ctHoaDon;
    }

    public void setCtHoaDon(ArrayList<CTHoaDon_pojo> ctHoaDon) {
        this.ctHoaDon = ctHoaDon;
    }

    public ThanhToan_pojo(HoaDon_pojo hoadon, Ban_pojo ban, KhuVuc_pojo khuvuc, ArrayList<CTHoaDon_pojo> ctHoaDon) {
        this.hoadon = hoadon;
        this.ban = ban;
        this.khuvuc = khuvuc;
        this.ctHoaDon = ctHoaDon;
    }
}
