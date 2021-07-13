/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import javacoffee.pojo.XuatCTHoaDon_pojo;
import javacoffee.sqlprovider.SqlServerProvider;
import java.sql.ResultSet;

/**
 *
 * @author kikkdt (KietDt)
 */
public class XuatCTHoaDon_DAO {

    public static ArrayList<XuatCTHoaDon_pojo> getList(int maHD) {
        ArrayList<XuatCTHoaDon_pojo> lst = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();
        try {
            sql.open();
            String sqlCmd = String.format("SELECT * FROM tb_CTHoaDon, tb_SanPham WHERE tb_CTHoaDon.MaSP=tb_SanPham.MaSP AND MaHD=%d", maHD);

            ResultSet result = sql.executeQuery(sqlCmd);
            while (result.next()) {
                lst.add(new XuatCTHoaDon_pojo(result.getNString("TenSP"), result.getInt("SoLuong"), result.getDouble("GiaBan"), result.getDouble("ThanhTien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(XuatCTHoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lst;
    }
}
