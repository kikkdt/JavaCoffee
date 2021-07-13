/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.util.ArrayList;
import javacoffee.dao.XuatCTHoaDon_DAO;
import javacoffee.pojo.XuatCTHoaDon_pojo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kikkdt (KietDt)
 */
public class XuatCTHoaDon_BUS {

    HoaDon_BUS hoadon = new HoaDon_BUS();

    public ArrayList<XuatCTHoaDon_pojo> getList(int maHD) {
        if (hoadon.isExist(maHD)) {
            return XuatCTHoaDon_DAO.getList(maHD);
        } else {
            JOptionPane.showMessageDialog(null, "Mã hóa đơn [" + maHD + "] không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
            return null;
        }
    }
}
