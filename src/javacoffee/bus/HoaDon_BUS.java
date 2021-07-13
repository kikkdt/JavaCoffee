/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.HoaDon_DAO;
import javacoffee.pojo.HoaDon_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class HoaDon_BUS {

    Ban_BUS ban = new Ban_BUS();
    NhanVien_BUS nhanvien = new NhanVien_BUS();
    KhachHang_BUS khachhang = new KhachHang_BUS();

    public boolean isExist(int maHoaDon) {
        return getList().parallelStream().anyMatch(hoadon -> hoadon.getMaHD() == maHoaDon);
    }

    public ArrayList<HoaDon_pojo> getList() {
        return HoaDon_DAO.getList();
    }

    public ArrayList<HoaDon_pojo> getList(int ngay, int thang, int nam) {
        return HoaDon_DAO.getList(ngay, thang, nam);
    }

    public int insert(int maNV, int maBan) {
        if (nhanvien.isExist(maNV) && ban.isExist(maBan)) {
            return HoaDon_DAO.insert(maNV, maBan);
        } else if (!nhanvien.isExist(maNV)) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên [" + maNV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!ban.isExist(maBan)) {
            JOptionPane.showMessageDialog(null, "Mã bàn [" + maBan + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maHD, int maKH) {
        if (khachhang.isExist(maKH) && isExist(maHD)) {
            return HoaDon_DAO.update(maHD, maKH);
        } else if (!khachhang.isExist(maKH)) {
            JOptionPane.showMessageDialog(null, "Mã khách hàng [" + maKH + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!isExist(maHD)) {
            JOptionPane.showMessageDialog(null, "Mã hoá đơn [" + maHD + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
