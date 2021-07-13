/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.sql.Time;
import java.util.ArrayList;
import javacoffee.dao.CaLam_DAO;
import javacoffee.pojo.CaLam_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class CaLam_BUS {

    public boolean isExist(String tenCaLam) {
        return getList().parallelStream().anyMatch(calam -> (calam.getTenCaLam().equalsIgnoreCase(tenCaLam)));
    }

    public boolean isExist(int maCaLam) {
        return getList().parallelStream().anyMatch(calam -> calam.getMaCaLam() == maCaLam);
    }

    public boolean isExist(int maCaLam, String tenCaLam) {
        return getList().parallelStream().anyMatch(calam -> (calam.getTenCaLam().equalsIgnoreCase(tenCaLam) && calam.getMaCaLam() != maCaLam));
    }

    public String getTenCaLam(int maCaLam) {
        return getList().parallelStream().filter(calam -> calam.getMaCaLam() == maCaLam).map(CaLam_pojo::getTenCaLam).findAny().orElse("");
    }

    public int getMaCaLam(String tenCaLam) {
        return getList().parallelStream().filter(calam -> tenCaLam.equals(calam.getTenCaLam())).map(CaLam_pojo::getMaCaLam).findAny().orElse(0);
    }

    public ArrayList<CaLam_pojo> getList() {
        return CaLam_DAO.getList();
    }

    public int insert(String tenCaLam, Time gioBatDau, Time gioKetThuc) {
        boolean chkTenCaLam = isExist(tenCaLam);
        boolean chkGio = (gioBatDau != null && gioKetThuc != null);

        if (!tenCaLam.isBlank() && !chkTenCaLam && chkGio) {
            return CaLam_DAO.insert(tenCaLam, gioBatDau, gioKetThuc);
        } else if (chkTenCaLam) {
            JOptionPane.showMessageDialog(null, "Tên ca làm đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (tenCaLam.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên ca làm không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkGio) {
            JOptionPane.showMessageDialog(null, "Giờ bắt đầu và kết thúc không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maCaLam, String tenCaLam, Time gioBatDau, Time gioKetThuc) {
        boolean chkTenCaLam = isExist(maCaLam, tenCaLam);
        boolean chkGio = (gioBatDau != null && gioKetThuc != null);

        if (!tenCaLam.isBlank() && !chkTenCaLam && chkGio) {
            return CaLam_DAO.update(maCaLam, tenCaLam, gioBatDau, gioKetThuc);
        } else if (chkTenCaLam) {
            JOptionPane.showMessageDialog(null, "Tên ca làm đã tồn tại ở một ca làm khác, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (tenCaLam.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên ca làm không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkGio) {
            JOptionPane.showMessageDialog(null, "Giờ bắt đầu và kết thúc không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maCaLam) {
        if (isExist(maCaLam)) {
            return CaLam_DAO.delete(maCaLam);
        } else {
            JOptionPane.showMessageDialog(null, "Mã ca làm [" + maCaLam + "] không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
