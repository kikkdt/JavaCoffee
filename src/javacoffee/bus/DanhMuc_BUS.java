/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.DanhMuc_DAO;
import javacoffee.pojo.DanhMuc_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class DanhMuc_BUS {

    public boolean isExist(int maDanhMuc) {
        return getList().parallelStream().anyMatch(danhmuc -> danhmuc.getMaDanhMuc() == maDanhMuc);
    }

    public boolean isExist(String tenDanhMuc) {
        return getList().parallelStream().anyMatch(danhmuc -> (danhmuc.getTenDanhMuc().equalsIgnoreCase(tenDanhMuc)));
    }

    public boolean isExist(int maDanhMuc, String tenDanhMuc) {
        return getList().parallelStream().anyMatch(danhmuc -> (danhmuc.getTenDanhMuc().equalsIgnoreCase(tenDanhMuc) && danhmuc.getMaDanhMuc() != maDanhMuc));
    }

    public ArrayList<DanhMuc_pojo> getList() {
        return DanhMuc_DAO.getList();
    }

    public int getMaDanhMuc(String tenDanhMuc) {
        return getList().parallelStream().filter(danhmuc -> danhmuc.getTenDanhMuc().equalsIgnoreCase(tenDanhMuc)).map(DanhMuc_pojo::getMaDanhMuc).findAny().orElse(0);
    }

    public String getTenDanhMuc(int maDanhMuc) {
        return getList().parallelStream().filter(danhmuc -> danhmuc.getMaDanhMuc() == maDanhMuc).map(DanhMuc_pojo::getTenDanhMuc).findAny().orElse("");
    }

    public int insert(String tenDanhMuc) {
        boolean chkTenDanhMuc = isExist(tenDanhMuc);

        if (!tenDanhMuc.isBlank() && !chkTenDanhMuc) {
            return DanhMuc_DAO.insert(tenDanhMuc);
        } else {
            JOptionPane.showMessageDialog(null, "Tên danh mục [" + tenDanhMuc + "] đã tồn tại, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maDanhMuc, String tenDanhMuc) {
        boolean chkMaDanhMuc = isExist(maDanhMuc);
        boolean chkTenDanhMuc = isExist(maDanhMuc, tenDanhMuc);

        if (!tenDanhMuc.isBlank() && chkMaDanhMuc && !chkTenDanhMuc) {
            return DanhMuc_DAO.update(maDanhMuc, tenDanhMuc);
        } else if (!chkMaDanhMuc) {
            JOptionPane.showMessageDialog(null, "Mã danh mục [" + maDanhMuc + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkTenDanhMuc) {
            JOptionPane.showMessageDialog(null, "Tên danh mục [" + tenDanhMuc + "] đã tồn tại ở danh mục khác, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maDanhMuc) {
        boolean chkMaDanhMuc = isExist(maDanhMuc);

        if (chkMaDanhMuc) {
            return DanhMuc_DAO.delete(maDanhMuc);
        } else {
            JOptionPane.showMessageDialog(null, "Mã danh mục [" + maDanhMuc + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
