/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.LoaiTaiKhoan_DAO;
import javacoffee.pojo.LoaiTaiKhoan_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class LoaiTaiKhoan_BUS {

    public boolean isExist(int id) {
        return getList().parallelStream().anyMatch(loaiTK -> loaiTK.getId() == id);
    }

    public int getIdLoaiTK(String tenLoaiTK) {
        return getList().parallelStream().filter(loaiTK -> loaiTK.getTenLoaiTK().equalsIgnoreCase(tenLoaiTK)).map(LoaiTaiKhoan_pojo::getId).findAny().orElse(0);
    }

    public String getTenLoaiTK(int id) {
        return getList().parallelStream().filter(loaiTK -> loaiTK.getId() == id).map(LoaiTaiKhoan_pojo::getTenLoaiTK).findAny().orElse("");
    }

    public ArrayList<LoaiTaiKhoan_pojo> getList() {
        return LoaiTaiKhoan_DAO.getList();
    }
}
