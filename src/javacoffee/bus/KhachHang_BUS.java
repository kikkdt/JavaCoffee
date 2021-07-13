/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.KhachHang_DAO;
import javacoffee.pojo.KhachHang_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class KhachHang_BUS {

    private ArrayList<KhachHang_pojo> lstKhachHang = getList();

    public boolean isExist(int maKH) {
        return lstKhachHang.parallelStream().anyMatch(kh -> kh.getMaKH() == maKH);
    }

    public boolean isExist(String sdt) {
        return lstKhachHang.parallelStream().anyMatch(kh -> (kh.getSdt().equalsIgnoreCase(sdt)));
    }

    public boolean isExist(int maKH, String sdt) {
        return lstKhachHang.parallelStream().anyMatch(kh -> (kh.getSdt().equalsIgnoreCase(sdt) && kh.getMaKH() != maKH));
    }

    public String getTenKH(int maKH) {
        return lstKhachHang.parallelStream().filter(kh -> kh.getMaKH() == maKH).map(KhachHang_pojo::getTenKH).findAny().orElse("");
    }

    public int getDiemTichLuy(int maKH) {
        return lstKhachHang.parallelStream().filter(kh -> kh.getMaKH() == maKH).map(KhachHang_pojo::getDiemTichLuy).findAny().orElse(0);
    }

    public ArrayList<KhachHang_pojo> getList() {
        return KhachHang_DAO.getList();
    }

    public int insert(String tenKH, String sdt, int loaiKH) {
        boolean chkLoaiKH = new LoaiKhachHang_BUS().isExist(loaiKH);
        boolean chkSdtExist = isExist(sdt);
        boolean chkSdt = (sdt.matches("^0[0-9]{9}$"));

        if (!tenKH.isBlank() && !sdt.isBlank() && chkLoaiKH && chkSdt && !chkSdtExist) {
            return KhachHang_DAO.insert(tenKH, sdt, loaiKH);
        } else if (tenKH.isBlank() || sdt.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên khách hàng hoặc Số điện thoại không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkSdt) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkSdtExist) {
            JOptionPane.showMessageDialog(null, "Số điện thoại này đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkLoaiKH) {
            JOptionPane.showMessageDialog(null, "Loại thành viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maKH, String tenKH, String sdt, int loaiKH) {
        boolean chkLoaiKH = new LoaiKhachHang_BUS().isExist(loaiKH);
        boolean chkSdtExist = isExist(maKH, sdt);
        boolean chkSdt = (sdt.matches("^0[0-9]{9}$"));

        if (!tenKH.isBlank() && !sdt.isBlank() && chkLoaiKH && !chkSdtExist && chkSdt) {
            return KhachHang_DAO.update(maKH, tenKH, sdt, loaiKH);
        } else if (tenKH.isBlank() || sdt.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên khách hàng hoặc Số điện thoại không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkSdt) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkSdtExist) {
            JOptionPane.showMessageDialog(null, "Số điện thoại này đã tồn tại từ người khác.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkLoaiKH) {
            JOptionPane.showMessageDialog(null, "Loại thành viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maKH) {
        if (isExist(maKH)) {
            return KhachHang_DAO.delete(maKH);
        } else {
            JOptionPane.showMessageDialog(null, "Mã khách hàng [" + maKH + "] không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
