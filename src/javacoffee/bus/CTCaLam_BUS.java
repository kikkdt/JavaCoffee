/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javacoffee.dao.CTCaLam_DAO;
import javacoffee.pojo.CTCaLam_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class CTCaLam_BUS {

    private final NhanVien_BUS nhanvien = new NhanVien_BUS();
    private final CaLam_BUS calam = new CaLam_BUS();

    public boolean isExist(int maNV, int maCaLam, Timestamp ngayLam) {
        return getList(ngayLam).parallelStream().anyMatch(ctcalam -> ctcalam.getMaNV() == maNV && ctcalam.getMaCaLam() == maCaLam);
    }

    public ArrayList<CTCaLam_pojo> getList(Timestamp ngayLam) {
        return CTCaLam_DAO.getList(ngayLam);
    }

    public int insert(int maNV, int maCaLam, Timestamp ngayLam) {
        boolean chkMaNV = nhanvien.isExist(maNV);
        boolean chkMaCaLam = calam.isExist(maCaLam);
        boolean chkNgayLam = (ngayLam.compareTo(new Date()) <= 0);

        if (chkMaNV && chkMaCaLam && chkNgayLam) {
            return CTCaLam_DAO.insert(maNV, maCaLam, ngayLam);
        } else if (!chkMaNV) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên [" + maNV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaCaLam) {
            JOptionPane.showMessageDialog(null, "Mã ca làm [" + maCaLam + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkNgayLam) {
            JOptionPane.showMessageDialog(null, "Ngày làm không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maNV, int maCaLam, int maCaLam1, Timestamp ngayLam) {
        boolean chkMaNV = nhanvien.isExist(maNV);
        boolean chkMaCaLam = calam.isExist(maCaLam);
        boolean chkNgayLam = (ngayLam.compareTo(new Date()) <= 0);

        if (chkMaNV && chkMaCaLam && chkNgayLam) {
            return CTCaLam_DAO.update(maNV, maCaLam, maCaLam1, ngayLam);
        } else if (!chkMaNV) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên [" + maNV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaCaLam) {
            JOptionPane.showMessageDialog(null, "Mã ca làm [" + maCaLam + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkNgayLam) {
            JOptionPane.showMessageDialog(null, "Ngày làm không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maNV, int maCaLam, Timestamp ngayLam) {
        boolean chkMaNV = nhanvien.isExist(maNV);
        boolean chkMaCaLam = calam.isExist(maCaLam);
        boolean chkNgayLam = (ngayLam.compareTo(new Date()) <= 0);

        if (chkMaNV && chkMaCaLam && chkNgayLam) {
            return CTCaLam_DAO.delete(maNV, maCaLam, ngayLam);
        } else if (!chkMaNV) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên [" + maNV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaCaLam) {
            JOptionPane.showMessageDialog(null, "Mã ca làm [" + maCaLam + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkNgayLam) {
            JOptionPane.showMessageDialog(null, "Ngày làm không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
