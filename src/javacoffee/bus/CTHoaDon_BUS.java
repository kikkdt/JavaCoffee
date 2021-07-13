/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.CTHoaDon_DAO;
import javacoffee.pojo.CTHoaDon_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class CTHoaDon_BUS {

    private final HoaDon_BUS hoadon = new HoaDon_BUS();
    private final SanPham_BUS sanpham = new SanPham_BUS();

    public ArrayList<CTHoaDon_pojo> getList(int maHD) {
        ArrayList<CTHoaDon_pojo> lstCTHD = new ArrayList<>();
        if (hoadon.isExist(maHD)) {
            lstCTHD = CTHoaDon_DAO.getList(maHD);
        } else {
            JOptionPane.showMessageDialog(null, "Mã hoá đơn [" + maHD + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return lstCTHD;
    }

    public int insert(int maHD, int maSP) {
        if (hoadon.isExist(maHD) && sanpham.isExist(maSP)) {
            return CTHoaDon_DAO.insert(maHD, maSP);
        } else if (!hoadon.isExist(maHD)) {
            JOptionPane.showMessageDialog(null, "Mã hoá đơn [" + maHD + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!sanpham.isExist(maSP)) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm [" + maSP + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maHD, int maSP) {
        if (hoadon.isExist(maHD) && sanpham.isExist(maSP)) {
            return CTHoaDon_DAO.delete(maHD, maSP);
        } else if (!hoadon.isExist(maHD)) {
            JOptionPane.showMessageDialog(null, "Mã hoá đơn [" + maHD + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
            return 0;
        } else if (!sanpham.isExist(maSP)) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm [" + maSP + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maHD, int maSP, int soLuong) {
        if (hoadon.isExist(maHD) && sanpham.isExist(maSP) && soLuong >= 0) {
            return CTHoaDon_DAO.update(maHD, maSP, soLuong);
        } else if (!hoadon.isExist(maHD)) {
            JOptionPane.showMessageDialog(null, "Mã hoá đơn [" + maHD + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!sanpham.isExist(maSP)) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm [" + maSP + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (soLuong < 0) {
            JOptionPane.showMessageDialog(null, "Số lượng là số nguyên dương", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
