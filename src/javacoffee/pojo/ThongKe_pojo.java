/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.pojo;

import java.sql.Date;

/**
 *
 * @author kikkdt (KietDt)
 */
public class ThongKe_pojo {
    private Date ngayXuatHD;
    private double thanhTien;

    public Date getNgayXuatHD() {
        return ngayXuatHD;
    }

    public void setNgayXuatHD(Date ngayXuatHD) {
        this.ngayXuatHD = ngayXuatHD;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public ThongKe_pojo(Date ngayXuatHD, double thanhTien) {
        this.ngayXuatHD = ngayXuatHD;
        this.thanhTien = thanhTien;
    }
}
