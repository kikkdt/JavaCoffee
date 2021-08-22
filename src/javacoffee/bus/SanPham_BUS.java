/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.SanPham_DAO;
import javacoffee.pojo.SanPham_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class SanPham_BUS {

    DanhMuc_BUS danhmuc = new DanhMuc_BUS();

    public boolean isExist(int maSanPham) {
        return getList().parallelStream().anyMatch(sp -> sp.getMaSanPham() == maSanPham);
    }

    public boolean isExist(String tenSanPham) {
        return getList().parallelStream().anyMatch(sp -> (sp.getTenSanPham().equalsIgnoreCase(tenSanPham)));
    }

    public boolean isExist(int maSanPham, String tenSanPham) {
        return getList().parallelStream().anyMatch(sp -> (sp.getTenSanPham().equalsIgnoreCase(tenSanPham) && sp.getMaSanPham() != maSanPham));
    }

    public int getMaSP(String tenSP) {
        return getList().parallelStream().filter(sp -> sp.getTenSanPham().equalsIgnoreCase(tenSP)).map(SanPham_pojo::getMaSanPham).findAny().orElse(0);
    }

    public String getTenSP(int maSP) {
        return getList().parallelStream().filter(sp -> sp.getMaSanPham() == maSP).map(SanPham_pojo::getTenSanPham).findAny().orElse("");
    }

    public double getGiaBan(int maSP) {
        return getList().parallelStream().filter(sp -> sp.getMaSanPham() == maSP).map(SanPham_pojo::getGiaBan).findAny().orElse(0.0);
    }

    public ArrayList<SanPham_pojo> getList() {
        return SanPham_DAO.getList();
    }

    public ArrayList<SanPham_pojo> getList(int maDanhMuc) {
        ArrayList<SanPham_pojo> lstSP = new ArrayList<>();
        if (danhmuc.isExist(maDanhMuc)) {
            lstSP = SanPham_DAO.getList(maDanhMuc);
        } else {
            JOptionPane.showMessageDialog(null, "Mã danh mục [" + maDanhMuc + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return lstSP;
    }

    public int insert(String tenSP, String hinhAnh, String giaBan, int maDanhMuc) {
        boolean chkTenSP = isExist(tenSP);
        boolean chkDanhMuc = danhmuc.isExist(maDanhMuc);
        boolean chkGiaBan = false;
        if (giaBan.matches("^[0-9]+$")) {
            chkGiaBan = Double.parseDouble(giaBan) >= 0;
        }

        if (!tenSP.isBlank() && !giaBan.isBlank() && !chkTenSP && chkDanhMuc && chkGiaBan) {
            return SanPham_DAO.insert(tenSP, hinhAnh, Double.parseDouble(giaBan), maDanhMuc);
        } else if (tenSP.isBlank() || giaBan.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên món và giá bán không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkTenSP) {
            JOptionPane.showMessageDialog(null, "Tên món" + tenSP + " đã tồn tại, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkDanhMuc) {
            JOptionPane.showMessageDialog(null, "Mã danh mục [" + maDanhMuc + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkGiaBan) {
            JOptionPane.showMessageDialog(null, "Giá bán phải là số và không được âm.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(int maSP, String tenSP, String hinhAnh, String giaBan, int maDanhMuc) {
        boolean chkMaSP = isExist(maSP);
        boolean chkTenSP = isExist(maSP, tenSP);
        boolean chkDanhMuc = danhmuc.isExist(maDanhMuc);
        boolean chkGiaBan = false;
        if (giaBan.matches("^[0-9]+$")) {
            chkGiaBan = Double.parseDouble(giaBan) >= 0;
        }

        if (!tenSP.isBlank() && !giaBan.isBlank() && chkMaSP && !chkTenSP && chkDanhMuc && chkGiaBan) {
            return SanPham_DAO.update(maSP, tenSP, hinhAnh, Double.parseDouble(giaBan), maDanhMuc);
        } else if (tenSP.isBlank() || giaBan.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên món, hình ảnh và giá bán không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkMaSP) {
            JOptionPane.showMessageDialog(null, "Mã món" + maSP + " không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkTenSP) {
            JOptionPane.showMessageDialog(null, "Tên món" + tenSP + " đã tồn tại ở món khác, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkDanhMuc) {
            JOptionPane.showMessageDialog(null, "Mã danh mục [" + maDanhMuc + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkGiaBan) {
            JOptionPane.showMessageDialog(null, "Giá bán phải là số và không được âm.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(int maSP) {
        boolean chkMaSP = isExist(maSP);

        if (chkMaSP) {
            return SanPham_DAO.delete(maSP);
        } else {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm [" + maSP + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int deleteList(int maDanhMuc) {
        boolean chkMaDanhMuc = new DanhMuc_BUS().isExist(maDanhMuc);

        if (chkMaDanhMuc) {
            return SanPham_DAO.deleteList(maDanhMuc);
        } else {
            JOptionPane.showMessageDialog(null, "Mã danh mục [" + maDanhMuc + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
