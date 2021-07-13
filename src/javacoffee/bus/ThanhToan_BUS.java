/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import javacoffee.dao.ThanhToan_DAO;
import javacoffee.pojo.ThanhToan_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class ThanhToan_BUS {

    Ban_BUS b = new Ban_BUS();
    HoaDon_BUS hd = new HoaDon_BUS();

    public ThanhToan_pojo getThanhToan(int maBan) {
        if (b.isExist(maBan)) {
            return ThanhToan_DAO.getThanhToan(maBan);
        } else {
            JOptionPane.showMessageDialog(null, "Mã bàn [" + maBan + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
            return null;
        }
    }

    public int completeThanhToan(int maHD, int maBan) {
        if (hd.isExist(maHD) && b.isExist(maBan)) {
            return ThanhToan_DAO.completeThanhToan(maHD, maBan);
        } else if (!hd.isExist(maHD)) {
            JOptionPane.showMessageDialog(null, "Mã hoá đơn [" + maHD + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!b.isExist(maBan)) {
            JOptionPane.showMessageDialog(null, "Mã bàn [" + maBan + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
