/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.sql.Timestamp;
import java.util.ArrayList;
import javacoffee.dao.Luong_DAO;
import javacoffee.pojo.Luong_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class Luong_BUS {

    public ArrayList<Luong_pojo> calcLuong(double luongCB, Timestamp from, Timestamp to) {
        ArrayList<Luong_pojo> result = new ArrayList<>();
        boolean chkLuongCB = (luongCB >= 0);
        boolean chkNgay = (from.compareTo(to) <= 0);

        if (chkLuongCB && chkNgay) {
            result = Luong_DAO.calcLuong(luongCB, from, to);
        } else if (!chkLuongCB) {
            JOptionPane.showMessageDialog(null, "Lương cơ bản không được âm.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else if (!chkNgay) {
            JOptionPane.showMessageDialog(null, "Khoảng thời gian không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        }
        return result;
    }
}
