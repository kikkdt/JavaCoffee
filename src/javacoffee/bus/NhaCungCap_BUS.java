/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.NhaCungCap_DAO;
import javacoffee.pojo.NhaCungCap_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class NhaCungCap_BUS {

    public boolean isExist(int maNCC) {
        return getList().parallelStream().anyMatch(ncc -> ncc.getMaNCC() == maNCC);
    }

    public int getMaNCC(String tenNCC) {
        return getList().parallelStream().filter(ncc -> ncc.getTenNCC().equalsIgnoreCase(tenNCC)).map(NhaCungCap_pojo::getMaNCC).findAny().orElse(0);
    }

    public String getTenNCC(int maNCC) {
        return getList().parallelStream().filter(ncc -> ncc.getMaNCC() == maNCC).map(NhaCungCap_pojo::getTenNCC).findAny().orElse("");
    }

    public ArrayList<NhaCungCap_pojo> getList() {
        return NhaCungCap_DAO.getList();
    }

    public int insert(String tenNCC, String sdt) {
        boolean chkSdt = (sdt.length() == 10 && sdt.matches("^0[0-9]{9}$"));

        if (!tenNCC.isBlank() && !sdt.isBlank() && chkSdt) {
            return NhaCungCap_DAO.insert(tenNCC, sdt);
        } else if (tenNCC.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (sdt.isBlank()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkSdt) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maNCC, String tenNCC, String sdt) {
        boolean chkSdt = (sdt.length() == 10 && sdt.matches("^0[0-9]{9}$"));

        if (!tenNCC.isBlank() && !sdt.isBlank() && chkSdt) {
            return NhaCungCap_DAO.update(maNCC, tenNCC, sdt);
        } else if (tenNCC.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (sdt.isBlank()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkSdt) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maNCC) {
        if (isExist(maNCC)) {
            return NhaCungCap_DAO.delete(maNCC);
        } else {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp [" + maNCC + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
