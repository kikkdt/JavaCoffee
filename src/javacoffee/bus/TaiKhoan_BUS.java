/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javacoffee.dao.TaiKhoan_DAO;
import javacoffee.pojo.TaiKhoan_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class TaiKhoan_BUS {

    public boolean isExist(String tenDangNhap) {
        return getList().parallelStream().anyMatch(taikhoan -> taikhoan.getTenDangNhap().equals(tenDangNhap));
    }

    public String encryptPassword(String password) {
        try {
            //Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            //digest() method is called to calculate message digest
            //of an input digest() return array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            //Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            //Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } //For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public TaiKhoan_pojo login(String tenDangNhap, String matKhau) {
        if (!tenDangNhap.isBlank() && !matKhau.isBlank()) {
            TaiKhoan_pojo login = TaiKhoan_DAO.login(tenDangNhap, encryptPassword(matKhau + tenDangNhap));
            if (login != null) {
                return login;
            } else {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
            }
        } else if (tenDangNhap.isBlank() || matKhau.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập và mật khẩu không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return null;
    }

    public ArrayList<TaiKhoan_pojo> getList() {
        return TaiKhoan_DAO.getList();
    }

    public int insert(String tenDangNhap, String matKhau, String matKhau2, String tenHienThi, int idLoaiTK, int maNV) {
        boolean chkTenDangNhap = isExist(tenDangNhap);
        boolean chkNhanVien = new NhanVien_BUS().isExist(maNV);

        if (!tenDangNhap.isBlank() && !matKhau.isBlank() && !tenHienThi.isBlank() && !matKhau2.isBlank() && chkNhanVien && matKhau.equals(matKhau2) && !chkTenDangNhap) {
            return TaiKhoan_DAO.insert(tenDangNhap, encryptPassword(matKhau + tenDangNhap), tenHienThi, idLoaiTK, maNV);
        } else if (tenDangNhap.isBlank() || matKhau.isBlank() || tenHienThi.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập, mật khẩu và nhân viên không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (chkTenDangNhap) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại, mời thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!matKhau.equals(matKhau2)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkNhanVien) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên [+" + maNV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int update(String tenDangNhap, String matKhau, String matKhau2, String tenHienThi, int idLoaiTK, int maNV) {
        boolean chkNhanVien = new NhanVien_BUS().isExist(maNV);

        if (!tenDangNhap.isBlank() && !matKhau.isBlank() && !tenHienThi.isBlank() && !matKhau2.isBlank() && chkNhanVien && matKhau.equals(matKhau2)) {
            return TaiKhoan_DAO.update(tenDangNhap, encryptPassword(matKhau + tenDangNhap), tenHienThi, idLoaiTK, maNV);
        } else if (tenDangNhap.isBlank() || matKhau.isBlank() || tenHienThi.isBlank()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập, mật khẩu và tên hiển thị không được trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!matKhau.equals(matKhau2)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkNhanVien) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên [+" + maNV + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }

    public int delete(String tenDangNhap) {
        boolean chkTenDangNhap = isExist(tenDangNhap);

        if (chkTenDangNhap) {
            return TaiKhoan_DAO.delete(tenDangNhap);
        } else {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return 0;
    }
}
