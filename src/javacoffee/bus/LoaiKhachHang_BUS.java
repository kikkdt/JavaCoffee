/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.LoaiKhachHang_DAO;
import javacoffee.pojo.LoaiKhachHang_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class LoaiKhachHang_BUS {
    
    private ArrayList<LoaiKhachHang_pojo> lstLoaiKH = getList();

    public boolean isExist(int maLoaiKH) {
        return lstLoaiKH.parallelStream().anyMatch(loaiKH -> loaiKH.getMaLoaiKH() == maLoaiKH);
    }

    public int getMaLoaiKH(String tenLoaiKH) {
        return lstLoaiKH.parallelStream().filter(loaiKH -> loaiKH.getTenLoaiKH().equalsIgnoreCase(tenLoaiKH)).map(LoaiKhachHang_pojo::getMaLoaiKH).findAny().orElse(0);
    }

    public String getTenLoaiKH(int maLoaiKH) {
        return lstLoaiKH.parallelStream().filter(loaiKH -> loaiKH.getMaLoaiKH() == maLoaiKH).map(LoaiKhachHang_pojo::getTenLoaiKH).findAny().orElse("");
    }

    public ArrayList<LoaiKhachHang_pojo> getList() {
        return LoaiKhachHang_DAO.getList();
    }
}
