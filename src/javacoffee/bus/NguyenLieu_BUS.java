/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.NguyenLieu_DAO;
import javacoffee.pojo.NguyenLieu_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class NguyenLieu_BUS {

    public boolean isExist(int maNL) {
        return getList().parallelStream().anyMatch(nl -> nl.getMaNL() == maNL);
    }

    public ArrayList<NguyenLieu_pojo> getList() {
        return NguyenLieu_DAO.getList();
    }

    public int insert(String tenNL, int maNCC, String donViTinh, double donGia, String moTa) {
        boolean chkMaNCC = new NhaCungCap_BUS().isExist(maNCC);

        if (!tenNL.isBlank() && chkMaNCC && !donViTinh.isBlank() && donGia >= 0) {
            return NguyenLieu_DAO.insert(tenNL, maNCC, donViTinh, donGia, moTa);
        } else if (tenNL.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên nguyên liệu không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaNCC) {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp [" + maNCC + "] không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (donViTinh.isBlank()) {
            JOptionPane.showMessageDialog(null, "Đơn vị tính không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (donGia < 0) {
            JOptionPane.showMessageDialog(null, "Đơn giá phải là số không âm", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maNL, String tenNL, int maNCC, String donViTinh, double donGia, String moTa) {
        boolean chkMaNL = isExist(maNL);
        boolean chkMaNCC = new NhaCungCap_BUS().isExist(maNCC);

        if (chkMaNL && !tenNL.isBlank() && chkMaNCC && !donViTinh.isBlank() && donGia >= 0) {
            return NguyenLieu_DAO.update(maNL, tenNL, maNCC, donViTinh, donGia, moTa);
        } else if (!chkMaNL) {
            JOptionPane.showMessageDialog(null, "Mã nguyên liệu [" + maNL + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (tenNL.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên nguyên liệu không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaNCC) {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp [" + maNCC + "] không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (donViTinh.isBlank()) {
            JOptionPane.showMessageDialog(null, "Đơn vị tính không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (donGia < 0) {
            JOptionPane.showMessageDialog(null, "Đơn giá phải là số không âm", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maNL) {
        if (isExist(maNL)) {
            return NguyenLieu_DAO.delete(maNL);
        } else {
            JOptionPane.showMessageDialog(null, "Mã nguyên liệu [" + maNL + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int deleteList(int maNCC) {
        if (new NhaCungCap_BUS().isExist(maNCC)) {
            return NguyenLieu_DAO.deleteList(maNCC);
        } else {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp [" + maNCC + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
