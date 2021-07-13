/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.pojo.Ban_pojo;
import javacoffee.dao.Ban_DAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class Ban_BUS {

    public boolean isExist(int maBan) {
        return getList().parallelStream().anyMatch(ban -> ban.getMaBan() == maBan);
    }

    public boolean isExist(String tenBan) {
        return getList().parallelStream().anyMatch(ban -> (ban.getTenBan().equalsIgnoreCase(tenBan)));
    }

    public boolean isExist(int maBan, String tenBan) {
        return getList().parallelStream().anyMatch(ban -> (ban.getTenBan().equalsIgnoreCase(tenBan) && ban.getMaBan() != maBan));
    }

    public String getTenBan(int maBan) {
        return getList().parallelStream().filter(ban -> ban.getMaBan() == maBan).map(Ban_pojo::getTenBan).findAny().orElse("");
    }

    public ArrayList<Ban_pojo> getList() {
        return Ban_DAO.getList();
    }

    public ArrayList<Ban_pojo> getList(int maKV) {
        ArrayList<Ban_pojo> lstBan = new ArrayList<>();
        if (new KhuVuc_BUS().isExist(maKV)) {
            lstBan = Ban_DAO.getList(maKV);
        } else {
            JOptionPane.showMessageDialog(null, "Mã khu vực [" + maKV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return lstBan;
    }

    public int updateStatus(int maBan, boolean trangThai) {
        if (Ban_BUS.this.isExist(maBan)) {
            return Ban_DAO.updateStatus(maBan, trangThai);
        } else {
            JOptionPane.showMessageDialog(null, "Mã bàn [" + maBan + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int insert(String tenBan, int maKV) {
        boolean chkMaKV = new KhuVuc_BUS().isExist(maKV);
        boolean chkTenBan = Ban_BUS.this.isExist(tenBan);

        if (!tenBan.isBlank() && !chkTenBan && chkMaKV) {
            return Ban_DAO.insert(tenBan, maKV);
        } else if (tenBan.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên bàn không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkTenBan) {
            JOptionPane.showMessageDialog(null, "Tên bàn " + tenBan + " đã tồn tại, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaKV) {
            JOptionPane.showMessageDialog(null, "Mã khu vực [" + maKV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maBan, String tenBan, int maKV) {
        boolean chkMaBan = Ban_BUS.this.isExist(maBan);
        boolean chkMaKV = new KhuVuc_BUS().isExist(maKV);
        boolean chkTenBan = isExist(maBan, tenBan);

        if (chkMaBan && !tenBan.isBlank() && !chkTenBan && chkMaKV) {
            return Ban_DAO.update(maBan, tenBan, maKV);
        } else if (tenBan.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên bàn không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkTenBan) {
            JOptionPane.showMessageDialog(null, "Tên bàn " + tenBan + " đã tồn tại, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaBan) {
            JOptionPane.showMessageDialog(null, "Mã bàn [" + maBan + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaKV) {
            JOptionPane.showMessageDialog(null, "Mã khu vực [" + maKV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maBan) {
        boolean chkMaBan = Ban_BUS.this.isExist(maBan);
        boolean isTrangThai = getList().stream().filter(ban -> ban.getMaBan() == maBan).findAny().map(Ban_pojo::isTrangThai).orElse(false);
        //mapBan.get(maBan).isTrangThai() == true;
        if (chkMaBan && !isTrangThai) {
            return Ban_DAO.delete(maBan);
        } else if (!chkMaBan) {
            JOptionPane.showMessageDialog(null, "Mã bàn [" + maBan + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (isTrangThai) {
            JOptionPane.showMessageDialog(null, "Bàn hiện đang phục vụ, không thể xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int deleteList(int maKV) {
        boolean chkMaKV = new KhuVuc_BUS().isExist(maKV);

        if (chkMaKV) {
            return Ban_DAO.deleteList(maKV);
        } else {
            JOptionPane.showMessageDialog(null, "Mã khu vực [" + maKV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
