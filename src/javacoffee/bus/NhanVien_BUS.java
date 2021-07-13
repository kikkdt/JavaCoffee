/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacoffee.dao.NhanVien_DAO;
import javacoffee.pojo.NhanVien_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class NhanVien_BUS {
    private ArrayList<NhanVien_pojo> lstNhanVien = getList();

    public boolean isExist(int maNV) {
        return lstNhanVien.parallelStream().anyMatch(nv -> nv.getMaNV() == maNV);
    }

    public String getTenNhanVien(int maNV) {
        return lstNhanVien.parallelStream().filter(nv -> nv.getMaNV() == maNV).map(NhanVien_pojo::getTenNV).findAny().orElse("");
    }

    public ArrayList<NhanVien_pojo> getList() {
        return NhanVien_DAO.getList();
    }

    public int insert(String tenNV, String gioiTinh, String chucVu, Timestamp ngayVaoLam, String diaChi, String sdt) {
        boolean chkGioiTinh = (gioiTinh.equalsIgnoreCase("nam") || gioiTinh.equalsIgnoreCase("nữ"));
        boolean chkNgayVaoLam = (ngayVaoLam.compareTo(new Timestamp(new Date().getTime())) <= 0);
        diaChi = diaChi.isBlank() ? "Chưa xác định" : diaChi;
        boolean chkSdt = (sdt.length() == 10 && sdt.matches("^0[0-9]{9}$"));

        if (!tenNV.isBlank() && !gioiTinh.isBlank() && !chucVu.isBlank() && !sdt.isBlank() && chkGioiTinh && chkNgayVaoLam && chkSdt) {
            return NhanVien_DAO.insert(tenNV, gioiTinh, chucVu, ngayVaoLam, diaChi, sdt);
        } else if (tenNV.isBlank() || gioiTinh.isBlank() || chucVu.isBlank() || sdt.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên nhân viên, giới tính, chức vụ và số điện thoại\nkhông được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkGioiTinh) {
            JOptionPane.showMessageDialog(null, "Giới tính phải là Nam hoặc Nữ.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkNgayVaoLam) {
            JOptionPane.showMessageDialog(null, "Ngày vào làm không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkSdt) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maNV, String tenNV, String gioiTinh, String chucVu, Timestamp ngayVaoLam, String diaChi, String sdt) {
        boolean chkMaNV = isExist(maNV);
        boolean chkGioiTinh = (gioiTinh.equalsIgnoreCase("nam") || gioiTinh.equalsIgnoreCase("nữ"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            ngayVaoLam = ngayVaoLam == null ? new Timestamp(sdf.parse(sdf.format(new Date())).getTime()) : ngayVaoLam;
        } catch (ParseException ex) {
            Logger.getLogger(NhanVien_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean chkNgayVaoLam = (ngayVaoLam.compareTo(Timestamp.valueOf(LocalDateTime.now())) <= 0);
        diaChi = diaChi.isBlank() ? "Chưa xác định" : diaChi;
        boolean chkSdt = (sdt.length() == 10 && sdt.matches("^0[0-9]{9}$"));

        if (chkMaNV && !tenNV.isBlank() && !gioiTinh.isBlank() && !chucVu.isBlank() && !sdt.isBlank() && chkGioiTinh && chkNgayVaoLam && chkSdt) {
            return NhanVien_DAO.update(maNV, tenNV, gioiTinh, chucVu, ngayVaoLam, diaChi, sdt);
        } else if (tenNV.isBlank() || gioiTinh.isBlank() || chucVu.isBlank() || sdt.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên nhân viên, giới tính, chức vụ và số điện thoại\nkhông được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaNV) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên [" + maNV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkGioiTinh) {
            JOptionPane.showMessageDialog(null, "Giới tính phải là Nam hoặc Nữ.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkNgayVaoLam) {
            JOptionPane.showMessageDialog(null, "Ngày vào làm không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkSdt) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maNV) {
        if (isExist(maNV)) {
            return NhanVien_DAO.delete(maNV);
        } else {
            JOptionPane.showMessageDialog(null, "Mã nhân viên [" + maNV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
