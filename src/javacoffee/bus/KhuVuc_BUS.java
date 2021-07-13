/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.KhuVuc_DAO;
import javacoffee.pojo.KhuVuc_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class KhuVuc_BUS {

    public boolean isExist(int maKhuVuc) {
        return getList().parallelStream().anyMatch(khuvuc -> khuvuc.getMaKhuVuc() == maKhuVuc);
    }

    public boolean isExist(String tenKhuVuc) {
        return getList().parallelStream().anyMatch(khuvuc -> (khuvuc.getTenKhuVuc().equalsIgnoreCase(tenKhuVuc)));
    }

    public boolean isExist(int maKhuVuc, String tenKhuVuc) {
        return getList().parallelStream().anyMatch(khuvuc -> (khuvuc.getTenKhuVuc().equalsIgnoreCase(tenKhuVuc) && khuvuc.getMaKhuVuc() != maKhuVuc));
    }

    public ArrayList<KhuVuc_pojo> getList() {
        return KhuVuc_DAO.getList();
    }

    public int getMaKhuVuc(String tenKhuVuc) {
        return getList().parallelStream().filter(khuvuc -> khuvuc.getTenKhuVuc().equalsIgnoreCase(tenKhuVuc)).map(KhuVuc_pojo::getMaKhuVuc).findAny().orElse(0);
    }

    public String getTenKhuVuc(int maKhuVuc) {
        return getList().parallelStream().filter(khuvuc -> khuvuc.getMaKhuVuc() == maKhuVuc).map(KhuVuc_pojo::getTenKhuVuc).findAny().orElse("");
    }

    public int insert(String tenKhuVuc) {
        boolean isExist = isExist(tenKhuVuc);

        if (!tenKhuVuc.isBlank() && !isExist) {
            return KhuVuc_DAO.insert(tenKhuVuc);
        } else if (tenKhuVuc.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên khu vực không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (isExist) {
            JOptionPane.showMessageDialog(null, "Tên khu vực " + tenKhuVuc + " đã tồn tại, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maKV, String tenKhuVuc) {
        boolean chkMaKV = isExist(maKV);
        boolean chkTenKV = isExist(maKV, tenKhuVuc);

        if (chkMaKV && !tenKhuVuc.isBlank() && !chkTenKV) {
            return KhuVuc_DAO.update(maKV, tenKhuVuc);
        } else if (!chkMaKV) {
            JOptionPane.showMessageDialog(null, "Mã khu vực " + maKV + " không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (tenKhuVuc.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên khu vực không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkTenKV) {
            JOptionPane.showMessageDialog(null, "Tên khu vực đã tồn tại từ một khu vực khác.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maKV) {
        boolean chkMaKV = isExist(maKV);

        if (chkMaKV) {
            return KhuVuc_DAO.delete(maKV);
        } else {
            JOptionPane.showMessageDialog(null, "Khu vực có mã [" + maKV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
